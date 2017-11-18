#ifndef __DEX2JAR_H__
#define __DEX2JAR_H__
#include "utility_macros.h"
#include <string.h>
#include <stdio.h>

void dex2jar(const char* argv1, const char* dexfile, const char* outputfile);
void jar2dex(const char* argv1, const char* jarfile, const char* outputfile);

#endif