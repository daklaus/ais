CC=gcc
CFLAGS=-g -Wall -Werror

.PHONY: all build clean clean-dist prepare run

all: build
	
build: easyvirus
	
clean: clean-dist
	rm -f easyvirus *~ 

clean-dist:
	rm -fr run

prepare: clean-dist build
	mkdir -p run
	cp examples/* run/
	cp easyvirus run/

run: prepare
	(cd run; ./easyvirus)
	
easyvirus: easyvirus.c