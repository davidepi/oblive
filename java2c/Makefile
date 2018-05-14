.PHONY: clean
CC=gcc
CFLAGS=-fpic -Wall -Wno-unused-variable
SRCDIR=
OUTDIR=
SRCNAME=
LIBNAME=
USER_INCLUDES=
LIB=lib
INCLUDE= -I${JAVA_HOME}/include
FRAMEWORK= -Isrc/cframework
UNAME_S := $(shell uname -s)
ifeq ($(UNAME_S),Darwin)
INCLUDE += -I${JAVA_HOME}/include/darwin/
LIBEXT=.dylib
else
INCLUDE += -I${JAVA_HOME}/include/linux/
LIBEXT=.so
endif
all: $(OUTDIR)/lib$(LIBNAME)$(LIBEXT)

$(OUTDIR)/lib$(LIBNAME)$(LIBEXT): $(OUTDIR)/$(SRCNAME).o
		$(CC) $^ -shared -o $@

$(OUTDIR)/$(SRCNAME).o: $(SRCDIR)/$(SRCNAME).c
		mkdir -p $(OUTDIR)
		$(CC) $(USER_INCLUDES) -c $(CFLAGS) $(FRAMEWORK) $(INCLUDE) $^ -o $@

