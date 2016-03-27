# include <stdio.h>
# include <stdlib.h>

# define FALSE 0
# define TRUE 1

typedef char ElementType;


// avl

typedef struct TreeNode {
  ElementType element;
  struct TreeNode * left;
  struct TreeNode * right;
}TreeNode;
typedef TreeNode *TreePtr;

// 二维数组， 第一个为左儿子， 第二个为右儿子。
TreePtr createTree(ElementType element[], int (* nodeIndex)[2], int index){

	TreePtr tree = (TreePtr)malloc(sizeof(struct TreeNode));

	int leftChildIndex = nodeIndex[index][0];
	int rightChildIndex = nodeIndex[index][1];
	tree->element = element[index];
	if(leftChildIndex > -1) {
		tree->left = createTree(element, nodeIndex, leftChildIndex);
	} else {
		tree->left = NULL;
	}
	if(rightChildIndex > -1) {
		tree->right = createTree(element, nodeIndex, rightChildIndex);
	} else {
		tree->right = NULL;
	}
	return tree;
}

void preOrderTraversal(TreePtr tree) {
	if(tree) {
		printf("%c ", tree->element);
		preOrderTraversal(tree->left);
		preOrderTraversal(tree->right);
	}
}

void inOrderTraversal(TreePtr tree) {
	if(tree) {
		inOrderTraversal(tree->left);
		printf("%c ", tree->element);
		inOrderTraversal(tree->right);
	}
}

void postOrderTraversal(TreePtr tree) {
	if(tree) {
		postOrderTraversal(tree->left);
		postOrderTraversal(tree->right);
		printf("%c ", tree->element);
	}
}

int isomorphic(TreePtr tree1, TreePtr tree2) {
	if(tree1 == NULL && tree2 == NULL) return TRUE;
	if((tree1 == NULL && tree2 != NULL) || (tree1 != NULL && tree2 == NULL)) return FALSE;

	if(tree1->element != tree2->element) return FALSE;
	if(tree1->left != NULL && tree2->left != NULL && tree1->left->element == tree2->left->element)
		return isomorphic(tree1->right, tree2->right) && isomorphic(tree1->left, tree2->left);
	else
		return isomorphic(tree1->right, tree2->left) && isomorphic(tree1->left, tree2->right);
}

void find(TreePtr tree, ElementType ele) {
	if (tree) {
		if(tree->element==ele)
			printf("tree->element: %c", tree->element);
		find(tree->left, ele);
		find(tree->right, ele);

	}
}

int main(){
	int tmp;
	int array[8][2] = {{1, 2}, {3, 4}, {5, -1}, {-1, -1}, {6, -1}, {7, -1}, {-1, -1}, {-1, -1}};
	int array2[8][2] = {{-1, 4}, {7, 6}, {-1, -1}, {5, 1}, {-1, -1}, {0, -1}, {-1, -1}, {2, -1}};
	ElementType eles[] = {'A', 'B', 'C', 'D', 'E', 'G', 'F', 'H'};
	ElementType eles2[] = {'G', 'B', 'F', 'A', 'H', 'C', 'D', 'E'};
	TreePtr tree1 = createTree(eles, array, 0);
	TreePtr tree2 = createTree(eles2, array2, 3);
	preOrderTraversal(tree1);
	printf("\n--------------------\n");
	inOrderTraversal(tree1);
	printf("\n--------------------\n");
	postOrderTraversal(tree1);
	printf("\n--------------------\n");
	tmp = isomorphic(tree1, tree2);
	printf("%d", tmp);
	printf("\n--------------------\n");
	find(tree1, 'H');

	printf("\n--------------------\n");
	return 0;
}
