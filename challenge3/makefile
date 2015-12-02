CFLAGS=-m32 -fno-stack-protector -z execstack -D_FORTIFY_SOURCE=0

all: server

server: server.c auth.c auth.h
	gcc $(CFLAGS) -c server.c
	gcc $(CFLAGS) -c auth.c
	gcc $(CFLAGS) -o server server.o auth.o

clean:
	rm -f *.o
clean-all:	
	rm -f *.o server
