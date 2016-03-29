# include <stdio.h>
# include <stdlib.h>

# define FALSE 0
# define TRUE 1

typedef int ElementType;

// avl

typedef struct TreeNode {
  ElementType element;
  int bf; // 平衡因子
  struct TreeNode * left;
  struct TreeNode * right;
}TreeNode;
typedef TreeNode *TreePtr;

TreePtr createTree(ElementType element){
	TreePtr tree = (TreePtr)malloc(sizeof(struct TreeNode));
  tree->element = element;
  tree->left = NULL;
  tree->right = NULL;
	return tree;
}

void appendNode(TreePtr tree, ElementType element) {
  if(tree->element == element) {
    printf("existed\n");
    return;
  }
  if(element < tree->element && tree->left != NULL) {
    return appendNode(tree->left, element);
  }
  if(element > tree->element && tree->right != NULL) {
    return appendNode(tree->right, element);
  }

  TreePtr node = (TreePtr)malloc(sizeof(struct TreeNode));
  node->element = element;
  node->left = NULL;
  node->right = NULL;
  if(element < tree->element) {
    tree->left = node;
  }
  if(element > tree->element) {
    tree->right = node;
  }
}

TreePtr find(TreePtr tree, ElementType element) {
  if(!tree) return NULL;
  if(tree->element == element) return tree;
  if(tree->element < element) return find(tree->right, element);
  if(tree->element > element) return find(tree->left, element);
}

void inOrderTraversal(TreePtr tree) {
	if(tree) {
		inOrderTraversal(tree->left);
		printf("%d ", tree->element);
		inOrderTraversal(tree->right);
	}
}

int main(){
  TreePtr tree = createTree(5);
  TreePtr node;
  appendNode(tree, 4);
  appendNode(tree, 7);
  appendNode(tree, 6);
  appendNode(tree, 1);
  appendNode(tree, 2);
  appendNode(tree, 3);

  inOrderTraversal(tree);
  printf("\n-------------------\n");
  node = find(tree, 6);
  printf("%d ", node->element);
  printf("\n-------------------\n");
}
