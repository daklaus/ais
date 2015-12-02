CFLAGS=-g -fno-stack-protector -z execstack -D_FORTIFY_SOURCE=0
TARGET_ARCH=-m32
LDFLAGS=$(CFLAGS)
CC=gcc

all: server

server: auth.o canary.o server.o

auth.o: auth.c auth.h

canary.o: canary.c canary.h

clean:
	rm -f *.o
clean-all:	
	rm -f *.o server
