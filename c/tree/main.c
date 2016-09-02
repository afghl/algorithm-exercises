#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include "tree.h"

#define MAX 9
int main()
{
    BinTree t = NULL;
    char ca[MAX] = { 'e', 'd', 'f', 'a', 's', 'p', 'o', 'c', 'b' };
    int i;
    for (i = 0; i < MAX; i++)
        t = Insert(t, ca[i]);

    PreorderTraversal(t);

    printf("\nheight: %d\n", GetHeight(t));

    PreorderPrintLeaves(t);
    return 0;
}
