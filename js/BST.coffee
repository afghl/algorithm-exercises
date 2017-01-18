# 遍历二叉树

class Node
  constructor: (v) ->
    @value = v

class BST
  batchInsert: (arr) ->
    for v in arr
      @insert v

  insert: (v) ->
    unless @head?
      @head = new Node v
    else
      @createNode v, @head

  createNode: (v, node) ->
    unless node?
      newNode = new Node v
    else if node.value > v
      node.left = @createNode v, node.left
    else if node.value <= v
      node.right = @createNode v, node.right

    newNode || node

  traversal: (opt) ->
    if opt is 'inorder'
      @inorderTraversal(@head)

  inorderTraversal: (node) ->
    console.log node.value
    @inorderTraversal(node.left) if node.left?
    @inorderTraversal(node.right) if node.right?

createTree = ->
  b = new BST
  b.batchInsert [6, 4, 8, 3, 9, 10, 1]
  b

travel = (tree, order) ->
  tree.traversal order

t = createTree()
travel t, 'inorder'
