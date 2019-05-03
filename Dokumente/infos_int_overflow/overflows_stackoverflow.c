//https://stackoverflow.com/questions/199333/how-do-i-detect-unsigned-integer-multiply-overflow

// for addition
#include <limits.h>
int a = <something>;
int x = <something>;
if ((x > 0) && (a > INT_MAX - x)) /* `a + x` would overflow */;
if ((x < 0) && (a < INT_MIN - x)) /* `a + x` would underflow */;

// for subtraction
#include <limits.h>
int a = <something>;
int x = <something>;
if ((x < 0) && (a > INT_MAX + x)) /* `a - x` would overflow */;
if ((x > 0) && (a < INT_MIN + x)) /* `a - x` would underflow */;

// for multiplication
#include <limits.h>
int a = <something>;
int x = <something>;
if (a > INT_MAX / x) /* `a * x` would overflow */;
if ((a < INT_MIN / x)) /* `a * x` would underflow */;
// there may be need to check for -1 for two's complement machines
if ((a == -1) && (x == INT_MIN)) /* `a * x` can overflow */
if ((x == -1) && (a == INT_MIN)) /* `a * x` (or `a / x`) can overflow */




//https://stackoverflow.com/questions/8534107/detecting-multiplication-of-uint64-t-integers-overflow-with-c

uint64_t mult_with_overflow_check(uint64_t a, uint64_t b) {
  if (a > b) return mult_with_overflow_check(b, a);
  if (a > UINT32_MAX) overflow();
  uint32_t c = b >> 32;
  uint32_t d = UINT32_MAX & b;
  uint64_t r = a * c;
  uint64_t s = a * d;
  if (r > UINT32_MAX) overflow();
  r <<= 32;
  return addition_with_overflow_check(s, r);
}