#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

#define EMPTY -1
#define OCCUPY 1
#define IDMAX 18
#define TABLESIZEMAX 26 * 26 * 26 * 10


typedef struct Student {
    char Name[4];
    int Lessions[40000];
    int Count;
} Student;

typedef int Position;
typedef char *KeyType;
typedef Student *ValueType;

typedef struct Cell *PtrToCell;
typedef struct Cell {
    int Info;
    KeyType Key;
    ValueType Value;
} Cell;

typedef struct HashTbl *HashTable;
typedef struct HashTbl {
    int TableSize;
    Cell *TheCells;
} HashTbl;

int Hash(KeyType key, int TableSize)
{
    return (key[0] - 'A') * (key[1] - 'A') * (key[2] - 'A') * (key[3] - '0');
}

HashTable initHashTable(int TableSize)
{
    int i;
    HashTable H = (HashTable)malloc(sizeof(struct HashTbl));

    H->TableSize = TableSize;
    H->TheCells = (Cell *)malloc(sizeof(struct Cell) * H->TableSize);

    for (i = 0; i < H->TableSize; i++)
        H->TheCells[i].Info = EMPTY;

    return H;
}

Position Find(HashTable H, KeyType Key)
{
    Position CurrentPos, NewPos;
    int CNum = 0;
    NewPos = CurrentPos = Hash(Key, H->TableSize);
    // 最终会找到一个Info为EMPTY 或 Key 相同的位置。
    while (H->TheCells[NewPos].Info != EMPTY && strcmp(H->TheCells[NewPos].Key, Key) != 0)
    {
        if (++CNum % 2)
        {
            NewPos = CurrentPos + (CNum + 1) / 2 * (CNum + 1) / 2;
            // 加多了减回来
            while (NewPos >= H->TableSize)
                NewPos -= H->TableSize;
        }
        else
        {
            NewPos = CurrentPos - CNum / 2 * CNum / 2;
            while (NewPos < 0)
                NewPos += H->TableSize;
        }
    }

    return NewPos;
}

int InsertValue(HashTable H, KeyType Key, ValueType Value)
{
    Position Pos = Find(H, Key);
    PtrToCell c = &H->TheCells[Pos];
    if (c->Info == EMPTY)
    {
        c->Info = OCCUPY;
        c->Key = (KeyType)malloc(sizeof(char) * IDMAX);
        strcpy(c->Key, Key);
        c->Value = Value;
    }
    else
        c->Value += Value;
    return Pos;
}

void PrintValue(HashTable H, KeyType K)
{
    Position Pos = Find(H, K);
    if (H->TheCells[Pos].Info == OCCUPY)
        printf("%d\n", H->TheCells[Pos].Value);
    else
        printf("No Info\n");
}

int main()
{
    int N, MinMile, Mile;
    char key[IDMAX];
    scanf("%d %d", &N, &MinMile);
    getchar();
    HashTable H = initHashTable(TABLESIZEMAX);

    while (N--)
    {
        scanf("%s %d", key, &Mile);
        InsertValue(H, key, (Mile < MinMile ? MinMile : Mile));
    }

    scanf("%d", &N);
    while (N--)
    {
        scanf("%s", key);
        PrintValue(H, key);
    }

    return 0;
}
