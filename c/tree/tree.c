#include <stdlib.h>
#include <stdio.h>
#include "tree.h"

void PreorderTraversal( BinTree BT )
{
	if (BT)
	{
		printf(" %c", BT->Data);
		PreorderTraversal(BT->Left);
		PreorderTraversal(BT->Right);
	}
}

void InorderTraversal(BinTree BT)
{
    if (BT)
	{
        InorderTraversal(BT->Left);
        printf(" %c", BT->Data);
        InorderTraversal(BT->Right);
    }
}

void PostorderTraversal( BinTree BT )
{
	if (BT)
	{
		PostorderTraversal(BT->Left);
		PostorderTraversal(BT->Right);
		printf(" %c", BT->Data);
	}
}

void LevelorderTraversal( BinTree BT ) {
    BinTree nodes[100];
    int rear = 0, front = -1;
    BinTree T;

    if(!BT)
        return;

    nodes[rear] = BT;
    while (rear != front)
	{
        T = nodes[++front];
        printf(" %c", T->Data);

        if(T->Left)
            nodes[++rear] = T->Left;
        if(T->Right)
            nodes[++rear] = T->Right;
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
    BinTree t = (BinTree)malloc(sizeof(nodesuct TNode));
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
