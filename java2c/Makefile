.PHONY: clean
CC=gcc
CFLAGS=
PARENTDIR=.
SRC=$(PARENTDIR)/libsrc/libobf.c
INCLUDE= -I${JAVA_HOME}/include
FRAMEWORK= -Isrc/
LIB=libobf
UNAME_S := $(shell uname -s)
ifeq ($(UNAME_S),Darwin)
	INCLUDE += -I${JAVA_HOME}/include/darwin/
	LIBEXT=.dylib
else
	INCLUDE += -I${JAVA_HOME}/include/linux/
	LIBEXT=.so
endif
OUTDIR=$(PARENTDIR)/libsrc
EXE=libobf.o


all: $(SRC)
	mkdir -p $(OUTDIR)
	$(CC) -c $(CFLAGS) $(FRAMEWORK) $(INCLUDE) $(SRC) -o $(OUTDIR)/$(EXE)
	$(CC) $(OUTDIR)/libobf.o -shared -o $(OUTDIR)/$(LIB)$(LIBEXT)
	rm $(OUTDIR)/libobf.o

clean:
	rm $(OUTDIR)/$(EXE) $(OUTDIR)/$(LIB)
