// 已知两个非降序链表序列S1与S2，设计函数构造出S1与S2的并集新非降序链表S3。
//
// 输入格式:
//
// 输入分两行，分别在每行给出由若干个正整数构成的非降序序列，用-1−1表示序列的结尾（-1−1不属于这个序列）。数字用空格间隔。
//
// 输出格式:
//
// 在一行中输出合并后新的非降序链表，数字间用空格分开，结尾不能有多余空格；若新链表为空，输出NULL。
//
// 输入样例:
//
// 1 3 5 -1
// 2 4 6 8 10 -1
// 输出样例:
//
// 1 2 3 4 5 6 8 10

#include <stdio.h>
#include <stdlib.h>

typedef int ElementType;

typedef struct Node *PtrToNode;
typedef struct Node {
    ElementType Data; /* 存储结点数据 */
    PtrToNode   Next; /* 指向下一个结点的指针 */
} Node;
typedef PtrToNode Position; /* 定义位置类型 */
typedef PtrToNode List; /* 定义单链表类型 */

void printList(List l)
{
    l = l->Next;
    for(; l; l = l->Next)
    {
        if (!l->Next)
        {
            printf("%d", l->Data);
        }
        else
        {
            printf("%d ", l->Data);
        }
    }
    printf("\n");
}

List createList()
{
    List l = NULL;
    List h;
    int x;
    PtrToNode tmp;

    scanf("%d", &x);

    while (x > -1)
    {
        tmp = (PtrToNode)malloc(sizeof(struct Node));
        tmp->Data = x;
        tmp->Next = NULL;

        if (l == NULL)
        {
            l = tmp;
            h = l;
        }
        else
        {
            h->Next = tmp;
            h = h->Next;
        }

        scanf("%d", &x);
    }
    return l;
}

List unionList(List l1, List l2)
{
    List u = (List)malloc(sizeof(struct Node));
    u->Next = NULL;
    List tmp = u;
    int m;

    while (l1 != NULL && l2 != NULL)
    {
        if (l1->Data > l2->Data)
        {
            tmp->Next = l2;
            l2 = l2->Next;
        }
        else
        {
            tmp->Next = l1;
            l1 = l1->Next;
        }
        tmp = tmp->Next;
    }

    if (l1 != NULL)
        tmp->Next = l1;
    else tmp->Next = l2;

    return u;
}

int main()
{
    List l1, l2, u;
    l1 = createList();
    l2 = createList();
    u = unionList(l1, l2);
    if (u == NULL)
        printf("NULL");
    else
        printList(u);
}
