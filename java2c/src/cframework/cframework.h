#ifndef __CFRAMEWORK_H__
#define __CFRAMEWORK_H__

#include <stdint.h> //uint32_t
#include <stdio.h> //fprintf
#include <stdlib.h> //exit

typedef jvalue generic_t;
#define ZERO_OUT_UNION(res) res.j=0
#define OVERFLOW_CHECK(res,check) res.j&=check

#include "stack.h"
#include "arithmetic.h"
#include "conditionals.h"
#include "invoke.h"
#include "fields.h"
#include "new.h"
#include "casts.h"
#include "arrays.h"
#include "multi_arrays.h"


#endif
