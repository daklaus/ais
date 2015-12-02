/* A simple server in the internet domain using TCP
   The port number is passed as an argument 
   This version runs forever, forking off a separate 
   process for each connection
*/
#define _GNU_SOURCE   /* setresuid */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <sys/wait.h> 
#include <netinet/in.h>

#include "auth.h"
#include "canary.h" // we don't trust the standard canaries. we use our own

//#define FORK

void handle_con(int sock);

int auth_user(char *user, char *pass);

FILE *f;

int newsockfd;
char seed1[10],seed2[10];

char *user, *pass;

void handle_sig(int signal)
{
  wait3(NULL, WNOHANG, NULL); 
}

void error(char *msg)
{
    perror(msg);
    exit(1);
}

int main(int argc, char *argv[])
{
#ifdef FORK
  int pid;
#endif

unsigned int clilen;
  int sockfd, portno, on;
  struct sockaddr_in serv_addr, cli_addr;

  f=fopen("./root/ch3.log","a");

  signal(SIGCHLD, handle_sig);

  if (argc < 2) {
    fprintf(stderr,"error: no port provided\n");
    exit(1);
  }

  sockfd = socket(AF_INET, SOCK_STREAM, 0);

  if (sockfd < 0) 
    error("error: opening socket");

  on = 1;
  if (setsockopt(sockfd, SOL_SOCKET, SO_REUSEADDR, &on, sizeof(on)) < 0)
    error("error: set socket option");

  memset((char *) &serv_addr, 0, sizeof(serv_addr));
  portno = atoi(argv[1]);
  serv_addr.sin_family = AF_INET;
  serv_addr.sin_addr.s_addr = INADDR_ANY;
  serv_addr.sin_port = htons(portno);
  
  if (bind(sockfd, (struct sockaddr *) &serv_addr, sizeof(serv_addr)) < 0) 
    error("error: bind");

  listen(sockfd,5);
  clilen = sizeof(cli_addr);

  while (1) {

//	printf("server: Listening to incoming connections...\n\n");

    newsockfd = accept(sockfd, (struct sockaddr *) &cli_addr, &clilen);

    if (newsockfd < 0) 
      error("error: accept");

#ifdef FORK
    pid = fork();

    if (pid < 0)
      error("error: fork");

    if (pid == 0)  {
      close(sockfd);
#endif


      /* drop privileges */
      handle_con(newsockfd);
//      close(newsockfd);

#ifdef FORK
      exit(0);
    }
    else close(newsockfd);
#endif


  }

  return 0; /* we never get here */

}

void respond(char *m) 
{
	char canary1;
	char buf[400];
	char canary2;
		
	init_canary(&canary1,seed1);
	init_canary(&canary2,seed2);

	//printf("respond: %s\n",m);
	strcpy(buf,m);
	//printf("respond done: %s\n", buf);

	
	if (!check_canary(&canary1,seed1) || !check_canary(&canary2,seed2)) {
	  write(newsockfd, "STACK SMASHING DETECTED\n", 25);
	  exit(0);	
	}
}


void handle_con(int sock)
{
  int n, uid, tuid;
  size_t len;
  char msg[4096];
  char *message;
 
  len = sizeof(msg);
  memset(msg, 0, len);

  n = read(sock, msg, len - 1);
  if (n < 0) 
    error("error: reading from socket");

#ifdef DEBUG
  printf("%s\n", msg);
#endif

  /* very simple authentication */
  msg[10] = '\0';
  msg[19] = '\0';

#ifdef DEBUG
  printf("%s\n", msg);
  printf("%s\n", msg+11);
  printf("%s\n", msg+20);
#endif

  /* 
   * login with your user id and the password in the challenge description
   * 	e.g.	"inetsec999:XXXXXXXX:<message>"
   *
   */
  user = msg;

  /* 
   * you will find your password in your challenge description
   *
   * please check twice before sending us email ;-) 
   *
   */
  pass = msg + 11;

  message = msg + 20;

  //printf("user: \"%s\", pass: \"%s\", message: \"%s\"\n", user, pass, message);

  if ((uid = auth_user(user, pass)) != 0) {

    /* change to inetsec user on bandit */
    printf("authenticated user %s with passwd %s: uid %i\n", user,pass, uid);
    fprintf(f,"authenticated user %s with passwd %s: uid %i\n",user,pass, uid);

    tuid = uid; 
    if (setresuid(tuid, tuid, tuid) < 0) {
      printf("error: setting permissions\n");
      fprintf(f, "error: setting permissions\n");
      error("error: setting permissions");
    }

    strncpy(seed1, user, 10);
    strncpy(seed2, pass, 10);

    respond(message);
  }  
  else {
	printf("user: \"%s\", passwd: \"%s\" Access denied\n",user,pass);
	fprintf(f,"user: \"%s\", passwd: \"%s\" Access denied\n",user,pass);
	fflush(f);
  }
}
