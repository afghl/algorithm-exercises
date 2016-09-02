typedef char ElementType;
typedef struct TNode *Position;
typedef Position BinTree;
struct TNode{
    ElementType Data;
    BinTree Left;
    BinTree Right;
};

// 打印树
void InorderTraversal( BinTree BT );
void PreorderTraversal( BinTree BT );
void PostorderTraversal( BinTree BT );
void LevelorderTraversal( BinTree BT );


// 函数Insert将X插入二叉搜索树BST并返回结果树的根结点指针；
BinTree Insert(BinTree BST, ElementType X);

// 给定二叉树的高度。
int GetHeight(BinTree BT);

// 按照先序遍历的顺序输出给定二叉树BT的叶结点，格式为一个空格跟着一个字符。
void PreorderPrintLeaves( BinTree BT );
