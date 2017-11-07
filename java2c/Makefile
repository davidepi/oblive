.PHONY: clean
CC=gcc
CFLAGS=
SRC=$(shell find ../libsrc/ -name '*.c')
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
OUTDIR=../libsrc
EXE=libobf.o


all: $(SRC)
	echo $(INCLUDE)
	mkdir -p $(OUTDIR)
	$(CC) -c $(CFLAGS) $(FRAMEWORK) $(INCLUDE) $(SRC) -o $(OUTDIR)/$(EXE)
	$(CC) $(OUTDIR)/libobf.o -shared -o $(OUTDIR)/$(LIB)$(LIBEXT)

clean:
	rm $(OUTDIR)/$(EXE) $(OUTDIR)/$(LIB)
