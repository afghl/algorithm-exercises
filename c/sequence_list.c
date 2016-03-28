# include <stdio.h>

// 用数组实现线性表

#define BOOL int
#define TRUE  1
#define FALSE 0
# define MAXLENGTH 20

struct SequenceList {
  int data[MAXLENGTH];
  int length;
};

void printList(struct SequenceList *list) {
  int i;

  for (i = 0; i < list->length; i++) {
    printf("%d  ", list->data[i]);
  }

  return;
}

struct SequenceList createList(int * a, int length) {
  int * p, temp[length], i = 0, j;

  for (p = a; p < a + length; p++) {
    temp[i] = * p;
    i = i + 1;
  }

  struct SequenceList list = {* temp, length}; //不能直接把数组赋值？
  return list;
}

BOOL empty(struct SequenceList *list) {
  int length = list->length;
  if(length == 0) {
    return TRUE;
  } else {
    return FALSE;
  }
}

int getElement(struct SequenceList *list, int index) {
  if(index > list->length) {
    return FALSE;
  }

  int target, i;
  for(i = 0; i < list->length; i++) {
    if(i == index) {
      target = list->data[i];
    }
  }
  return target;
}

void insert(struct SequenceList *list, int ele, int index) {
  if(index > list->length || index < 0) {
    return;
  }
  int i;
  for(i = list->length; i > index; i--) {
    list->data[i] = list->data[i-1];
  }
  list->data[index] = ele;
  list->length++;
  return;
}

void delete(struct SequenceList *list, int index) {
  int length = list->length;
  if(index > length || index < 0) {
    return;
  }

  int i;
  for(i = length - 1; i < index; i--) {
    list->data[i] = list->data[i-1];
  }
  return;
}

int main() {
  // struct SequenceList list = createList(array, 7);
  struct SequenceList list = {{3,4,6,7,8,2,9}, 7};
  struct SequenceList emptyList = {{}, 0};
  printf("test: %d\n", list.data[0]);

  // empty
  printf("----empty-----\n");
  printf("%d\n", empty(&emptyList));
  printf("%d\n", empty(&list));

  printf("----getElement-----\n");
  int ele = getElement(&list, 7);
  printf("index=7,element=%d\n", ele);

  printf("----insert-----\n");
  insert(&list, 12, 3);
  printList(&list);

  printf("----delete-----\n");
  delete(&list, 3);
  printList(&list);
  return 0;
}
