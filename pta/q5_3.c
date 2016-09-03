#include <stdlib.h>
#include <stdio.h>

#define MaxTree 10

typedef enum {false, true} bool;
typedef char ElementType;
typedef int Tree;

// 用数组实现树。
typedef struct TreeNode {
    ElementType Data;
    Tree  Left;
    Tree  Right;
} TreeNode;
typedef struct TreeNode *PtrToTNode;

TreeNode T1[MaxTree], T2[MaxTree];

int TransChar(char c)
{
    if(c == '-')
        return -1;
    return c - '0';
}

void checkRoot(int checks[], int i)
{
    if (i < 0)
        return;
    checks[i] = 1;
    return;
}

Tree CreateTree(TreeNode T[])
{
    int N, i = 0;
    char D, L, R;
    int checks[MaxTree] = {0};
    PtrToTNode Node;

    scanf("%d", &N);
    while (i < N)
    {
        scanf("\n%c %c %c", &D, &L, &R);
        Node = (PtrToTNode)malloc(sizeof(struct TreeNode));

        Node->Data = D;
        Node->Left = TransChar(L);
        Node->Right = TransChar(R);

        T[i] = *Node;
        checkRoot(checks, Node->Right);
        checkRoot(checks, Node->Left);
        i++;
    }

    for (i = 0; i < N; i++)
        if (checks[i] == 0)
            return i;
    return -1;
}

bool Isomorphic(Tree R1, Tree R2)
{
    if (R1 == -1 && R2 == -1)
        return true;
    if ((R1 == -1 && R2 != -1) || (R1 != -1 && R2 == -1))
        return false;
    // 现在R1, R2都不可能为空
    char D1 = T1[R1].Data;
    char D2 = T2[R2].Data;
    if (D1 != D2)
        return false;

    if (((T1[R1].Left != -1) && (T2[R2].Left != -1))
            && ((T1[T1[R1].Left].Data) == (T2[T2[R2].Left].Data)))
            return (Isomorphic(T1[R1].Left, T2[R2].Left) && Isomorphic(T1[R1].Right, T2[R2].Right));
        else
            return (Isomorphic(T1[R1].Left, T2[R2].Right) && Isomorphic(T1[R1].Right, T2[R2].Left));
}
int main()
{
    Tree R1 = CreateTree(T1);
    Tree R2 = CreateTree(T2);

    if (Isomorphic(R1, R2))
        printf("Yes\n");
    else
        printf("No\n");
    return 0;
}
