#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define MIN -2147483648
#define MAX 2147483647

/*
+, -, * kann zu wraparounds führen
/ dürfte nie dazu führen
jedoch ist die Überprüfung für jeden Fall einzeln durchzuführen
*/

int
test1()
{
    int a, b, c;
    a = MAX - 2;
    b = 5;
    c = a + b;
    printf("c = %d\n", c);
    if (MAX - a < b)
    {
        printf("test1: int wrap\n");
    }
    return c;
}

int
test2()
{
    int a, b, c;
    a = MIN + 2;
    b = 5;
    c = a - b;
    printf("c = %d\n", c);
    if (MAX - abs(a) < abs(b) - 1) //-1 weil abs(MAX) = abs(MIN) - 1
    {
        printf("test2: int wrap\n");
    }
    return c;
}

int
test3()
{
    int a, b, c;
    a = MAX / 2 + 5;
    b = 2;
    c = a * b;
    printf("c = %d\n", c);
    if (MAX - abs(a) < abs(b)) //-1 weil abs(MAX) = abs(MIN) - 1
    {
        printf("test3: int wrap\n");
    }
    return c;
}

int
main(int argc, char **argv)
{
    int min, max;
    printf("sizeof(int)=%dbit\n", sizeof(int)*8);
    
    max = (int) pow(2, 32);
    min = - (int) pow(2, 32);
    min--;
    printf("min=%d, max=%d\n", min, max);
    
    printf("\ntest1\n");
    test1();
    
    printf("\ntest2\n");
    test2();
    
    printf("\ntest3\n");
    test3();
    
    return 0;
}