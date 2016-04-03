# include <stdio.h>
# include <stdlib.h>

# define HASHSIZE 12
# define NULLKEY -32768

typedef int Status;
int m = 0;

typedef struct HashTable {
  int *elements;
  int count;
} HashTable;

void initHashTable(HashTable *h) {
  int i;
  m = HASHSIZE;
  h->count = m;
  h->elements = (int *)malloc(m * sizeof(int));
  for(i = 0; i < m; i++) {
    h->elements[i] = NULLKEY;
  }
}

int hash(int key) { return key % m; }

Status searchHash(HashTable *h, int key, int *p) {
  *p = hash(key);
  int i = 0;
  while( h->elements[*p] != key ) {
    i = i + 1;
    *p = hash(key + i);
    if (i == m || h->elements[*p] == NULLKEY) {
      return 0;
    }
  }
  return 1;
}

void insertHash(HashTable *h, int key) {
  int addr = hash(key);
  int i = 0;
  while (h->elements[addr] != NULLKEY || i == m) {
    i++;
    addr = hash(key + i);
  }
  h->elements[addr] = key;
}

int main() {
  int key, p;
  HashTable h;
  initHashTable(&h);
  insertHash(&h, 12);
  insertHash(&h, 14);
  insertHash(&h, 15);
  insertHash(&h, 16);
  insertHash(&h, 24);

  p = 0;
  key = 24;
  searchHash(&h, key, &p);
	printf("查找 %d 的地址为：%d \n", key, p);

  return 0;
}
