// 假设全校有最多40000名学生和最多2500门课程。现给出每个学生的选课清单，要求输出每门课的选课学生名单。
//
// 输入格式:
//
// 输入的第一行是两个正整数：N（\le≤40000），为全校学生总数；K（\le≤2500），为总课程数。此后N行，每行包括一个学生姓名（3个大写英文字母+1位数字）、一个正整数C（\le≤20）代表该生所选的课程门数、随后是C个课程编号。简单起见，课程从1到K编号。
//
// 输出格式:
//
// 顺序输出课程1到K的选课学生名单。格式为：对每一门课，首先在一行中输出课程编号和选课学生总数（之间用空格分隔），之后在第二行按字典序输出学生名单，每个学生名字占一行。
//
// 输入样例:
//
// 10 5
// ZOE1 2 4 5
// ANN0 3 5 2 1
// BOB5 5 3 4 2 1 5
// JOE4 1 2
// JAY9 4 1 2 5 4
// FRA8 3 4 2 5
// DON2 2 4 5
// AMY7 1 5
// KAT3 3 5 4 2
// LOR6 4 2 4 1 5
// 输出样例:
//
// 1 4
// ANN0
// BOB5
// JAY9
// LOR6
// 2 7
// ANN0
// BOB5
// FRA8
// JAY9
// JOE4
// KAT3
// LOR6
// 3 1
// BOB5
// 4 7
// BOB5
// DON2
// FRA8
// JAY9
// KAT3
// LOR6
// ZOE1
// 5 9
// AMY7
// ANN0
// BOB5
// DON2
// FRA8
// JAY9
// KAT3
// LOR6
// ZOE1
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NAMEL 8
#define LESSIONL 20

typedef struct Node *PtrToNode;
typedef struct Node {
    char        Name[NAMEL];
    int         Lessions[LESSIONL];
    int         L;    // 课程数Lessions 的length
    PtrToNode   Next; /* 指向下一个结点的指针 */
} Node;

typedef PtrToNode Position; /* 定义位置类型 */
typedef PtrToNode List; /* 定义单链表类型 */

PtrToNode newNode(char Name[], int L)
{
    int i;
    PtrToNode n = (PtrToNode)malloc(sizeof(struct Node));
    strcpy(n->Name, Name);
    n->L = L;

    for (i = 0; i < L; i++)
        scanf("%d", &n->Lessions[i]);

    n->Next = NULL;
    return n;
}

List AddStudent(List L, char Name[], int Length)
{
    if (L == NULL)
        return newNode(Name, Length);
    L->Next = AddStudent(L->Next, Name, Length);
    return L;
}

void PrintLessions(List Students, int L)
{
    int i, j;
    List h;

    // 遍历学生
    for (h = Students; h; h = h->Next)
    {
        // 遍历学生的选课
        for (i = 0; i < h->L; i++)
        {

        }

    }
}

int main()
{
    int N, L, l;
    char Name[NAMEL];
    int Lessions[LESSIONL];
    List Students = NULL;

    scanf("%d %d", &N, &L);

    printf("now n = %d, l = %d\n", N, L);

    // 创建student链表
    while (N--)
    {
        scanf("%s", Name);
        getchar();
        scanf("%d", &l);
        Students = AddStudent(Students, Name, l);
    }

    PrintLessions(Students, l);
    return 0;
}
