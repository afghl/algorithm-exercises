// 有了一张自驾旅游路线图，你会知道城市间的高速公路长度、以及该公路要收取的过路费。现在需要你写一个程序，帮助前来咨询的游客找一条出发地和目的地之间的最短路径。如果有若干条路径都是最短的，那么需要输出最便宜的一条路径。
//
// 输入格式:
//
// 输入说明：输入数据的第1行给出4个正整数NN、MM、SS、DD，其中NN（2\le N\le 5002≤N≤500）是城市的个数，顺便假设城市的编号为0~(N-1N−1)；MM是高速公路的条数；SS是出发地的城市编号；DD是目的地的城市编号。随后的MM行中，每行给出一条高速公路的信息，分别是：城市1、城市2、高速公路长度、收费额，中间用空格分开，数字均为整数且不超过500。输入保证解的存在。
//
// 输出格式:
//
// 在一行里输出路径的长度和收费总额，数字间以空格分隔，输出结尾不能有多余空格。
//
// 输入样例:
//
// 4 5 0 3
// 0 1 1 20
// 1 3 2 30
// 0 3 4 10
// 0 2 2 20
// 2 3 1 20
// 输出样例:
//
// 3 40


#include <stdlib.h>
#include <stdio.h>

#define MAXVEX 500
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define INFINITY 65535
typedef int Status;	/* Status是函数的类型,其值是函数结果状态代码，如OK等 */
typedef int VertexType; /* 顶点类型应由用户定义  */
typedef int EdgeType; /* 边上的权值类型应由用户定义 */

typedef struct MG *MGraph;
typedef struct MG {
    VertexType vexs[MAXVEX]; /* 顶点表 */
    EdgeType arc[MAXVEX][MAXVEX];/* 邻接矩阵，可看作边表 */
    EdgeType fee[MAXVEX][MAXVEX];
    int numNodes, numEdges; /* 图中当前的顶点数和边数  */
} MG;

MGraph CreateMGraph(int numNodes, int numEdges)
{
    int i, j;
    MGraph G = (MGraph)malloc(sizeof(struct MG));
    G->numNodes = numNodes;
    G->numEdges = numEdges;

    for (i = 0; i < G->numNodes; i++)
        G->vexs[i] = i;

    for (i = 0; i < G->numNodes; i++)
        for (j = 0; j < G->numNodes; j++)
        {
            if (i == j)
            {
                G->arc[i][j] = 0;
                G->fee[i][j] = 0;
            }

            else
            {
                G->arc[i][j] = INFINITY;
                G->fee[i][j] = INFINITY;
            }
        }
    return G;
}

void SetEdge(MGraph G, VertexType n1, VertexType n2, int p, int fee)
{
    G->arc[n1][n2] = p;
    G->arc[n2][n1] = p;
    G->fee[n1][n2] = fee;
    G->fee[n2][n1] = fee;
}

void Dijkstra(MGraph G, VertexType v0, VertexType vf)
{
    int i;
    int dist[MAXVEX], cost[MAXVEX], path[MAXVEX], collected[MAXVEX];
    for (i = 0; i < G->numNodes; i++)
    {
        dist[i] = INFINITY;
        path[i] = -1;
        collected[i] = 0;
        cost[i] = INFINITY;
    }
//    设置初始数据
    dist[v0] = 0;
    cost[v0] = 0;


    // 进入循环，每次收录一个最小结点
    while (1)
    {
        // 找到最小
        int min = INFINITY;
        EdgeType k;
        for (i = 0; i < G->numNodes; i++)
        {
            if (!collected[i] && dist[i] < min)
            {
                min = dist[i];
                k = i;
            }
        }

        // 找不到，退出while true 循环
        if (min == INFINITY) break;
        // 找到最小，收录
        collected[k] = 1;

        // 若收录u导致未收录的结点 的最短距离变短，则更新
        for (i = 0; i < G->numNodes; i++)
        {
            if (collected[i]) continue;

            if ((min + G->arc[k][i]) < dist[i])
            {
                dist[i] = min + G->arc[k][i];
                path[i] = k;
                cost[i] = cost[k] + G->fee[k][i];
            }
            else if (((min + G->arc[k][i]) == dist[i])
                     && ((cost[k] + G->fee[k][i]) < cost[i]))
            {
                path[i] = k;
                cost[i] = cost[k] + G->fee[k][i];
            }
        }
    }

    printf("%d %d", dist[vf], cost[vf]);
}

int main()
{
    int N, E, i, p, fee;
    VertexType n1, n2, v0, vf;


    scanf("%d %d %d %d", &N, &E, &v0, &vf);
    MGraph G = CreateMGraph(N, E);
    while (E--)
    {
        scanf("%d %d %d %d", &n1, &n2, &p, &fee);
        SetEdge(G, n1, n2, p, fee);
    }

    Dijkstra(G, v0, vf);

    return 0;
}
