#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include "tree.h"

#define MAX 3
int main()
{
    BinTree t = NULL;
    char ca[MAX] = { 'e', 'd', 'f' };
    int i;
    for (i = 0; i < MAX; i++)
        t = Insert(t, ca[i]);
    
    PreorderTraversal(t);

    printf("height: %d\n", GetHeight(t));
    return 0;
}
