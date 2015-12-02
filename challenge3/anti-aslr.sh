#!/bin/bash

#setarch `uname -m` -R $SHELL
echo 0 | sudo tee /proc/sys/kernel/randomize_va_space
