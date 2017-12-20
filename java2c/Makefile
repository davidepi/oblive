.PHONY: clean
CC=gcc-7
INCLUDE= -I${JAVA_HOME}/include
FRAMEWORK= -Isrc/
CFLAGS=
PARENTDIR=.
LIBNAME=obf
SRC=$(PARENTDIR)/libsrc/$(LIBNAME).o
UNAME_S := $(shell uname -s)
ifeq ($(UNAME_S),Darwin)
	INCLUDE += -I${JAVA_HOME}/include/darwin/
	LIBEXT=.dylib
else
	INCLUDE += -I${JAVA_HOME}/include/linux/
	LIBEXT=.so
endif
OUTDIR=$(PARENTDIR)/libsrc
EXE=$(LIBNAME).o

all: $(OUTDIR)/$(EXE)
	mkdir -p $(OUTDIR)
	$(CC) -c $(CFLAGS) $(FRAMEWORK) $(INCLUDE) $(SRC) -o $(OUTDIR)/$(EXE)
	$(CC) $(OUTDIR)/$(LIBNAME) -shared -o $(OUTDIR)/$(LIBNAME)$(LIBEXT)
	rm $(OUTDIR)/$(LIBNAME)

clean:
	rm $(OUTDIR)/$(EXE) $(OUTDIR)/$(LIB)
