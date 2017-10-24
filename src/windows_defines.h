#ifndef __WINDOWS_DEFINES_H__
#define __WINDOWS_DEFINES_H__

#if defined(WIN32) || defined(WIN64)
#include <io.h>
#include <direct.h>
#define CR "\r\n"
#define EXISTS(path) (_access(path,0)!=-1)
#define READABLE(path) (_access(path,1)!=-1)
#define WRITABLE(path) (_access(path,2)!=-1)
#define READ_WRITE(path) (_access(path,6)!=-1)
#define MKDIR(path) _mkdir(path)
#define unlink(path) _unlink(path)
#define rmdir(path) _rmdir(path)
//in windows _S_IWRITE = S_IREAD|S_IWRITE
#define FD_WR_BINARY(p) _open(p,_O_WRONLY|_O_BINARY|_O_CREAT|_O_TRUNC,_S_IWRITE)
#define write(a,b,c) _write(a,b,c)
#define PATH_SEPARATOR_CHAR '\\'
#define PATH_SEPARATOR_STRING "\\"
#else
#include <unistd.h>
#include <sys/stat.h>
#define CR "\n"
#define EXISTS(path) (access(path,F_OK)!=-1)
#define READABLE(path) (access(path,R_OK)!=-1)
#define WRITABLE(path) (access(path,W_OK)!=-1)
#define READ_WRITE(path) (access(path,R_OK|W_OK)!=-1)
#define WRITE_BINARY(path) open(path, O_CREAT | O_TRUNC
#define MKDIR(path) mkdir(path,0700)
#define FD_WR_BINARY(p) open(p,O_WRONLY|O_CREAT|O_TRUNC,S_IREAD|S_IWRITE)
#define PATH_SEPARATOR_CHAR '/'
#define PATH_SEPARATOR_STRING "/"
#endif

#endif
