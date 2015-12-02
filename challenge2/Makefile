CC=gcc
CFLAGS=-m32 -g
SRCDIR=src

all: serial

serial: $(SRCDIR)/serial.c
	$(CC) -o $@ $^ $(CFLAGS)

.PHONY: clean

clean:
	rm -rf serial
