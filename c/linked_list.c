# include <stdio.h>

#define TRUE  1
#define FALSE 0
typedef int ElementType;


// 用链表实现线性表

typedef struct Node {
  ElementType element;
  struct Node * next;
}Node;

typedef Node List;

int isEmpty(List * l) {
  return l->next == NULL;
}

// void insert(List * l, ElementType x, int index) {
//
// }

void printList(List * l) {
  Node * n = l;
  while(n != NULL) {
    printf("%d ", n->element);
    n = n->next;
  }
}

int main() {
  Node list = {};
  Node secondEle = {2};
  Node firstEle = {3, &secondEle};
  list.next = &firstEle;

  // printf("%d\n", list.next->element);
  printList(&list);

  return 0;
}
