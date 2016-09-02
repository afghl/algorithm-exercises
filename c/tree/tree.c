#include <stdlib.h>
#include <stdio.h>
#include "tree.h"

void PreorderTraversal( BinTree BT ) {
	if(BT) {
		printf("%c ", BT->Data);
		PreorderTraversal(BT->Left);
		PreorderTraversal(BT->Right);
	}
}

void PreorderPrintLeaves( BinTree BT )
{
    if (!BT) return;

    if (BT->Left == NULL && BT->Right == NULL)
    {
        printf(" %c", BT->Data);
        return;
    }
    PreorderPrintLeaves(BT->Left);
    PreorderPrintLeaves(BT->Right);
}



BinTree newNode(ElementType E)
{
    BinTree t = (BinTree)malloc(sizeof(struct TNode));
    t->Data = E;
    t->Left = t->Right = NULL;
    return t;
}

BinTree Insert(BinTree T, ElementType X)
{
    if(!T)
        return newNode(X);

    if (X < T->Data)
        T->Left = Insert(T->Left, X);
    else
        T->Right = Insert(T->Right, X);
    return T;
}

// 给定二叉树的高度。
int GetHeight(BinTree BT)
{
    if (!BT)
        return 0;

    int l = GetHeight(BT->Left);
    int r = GetHeight(BT->Right);

    int m = l > r ? l : r;
    return m + 1;
}
