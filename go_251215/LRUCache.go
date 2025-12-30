package main

type LRUCache struct {
	head *node
	tail *node
	cap  int
	size int
	data map[int]*node
}

type node struct {
	val  int
	key  int
	prev *node
	next *node
}

func Constructor(capacity int) LRUCache {
	if capacity <= 0 {
		panic("cap must > 0")
	}
	head, tail := &node{}, &node{}
	head.next = tail
	tail.prev = head

	return LRUCache{cap: capacity, head: head, tail: tail, data: map[int]*node{}}
}

func (c *LRUCache) Get(key int) int {
	n, ok := c.data[key]
	if !ok {
		return -1
	}
	c.moveTo(n, c.head)
	return n.val
}

func (c *LRUCache) moveTo(n *node, newPrev *node) {
	if n.prev != nil {
		n.prev.next = n.next
	}
	if n.next != nil {
		n.next.prev = n.prev
	}

	beforeTop := newPrev.next
	newPrev.next = n
	n.next = beforeTop
	n.prev = newPrev
	if beforeTop != nil {
		beforeTop.prev = n
	}
}

func (c *LRUCache) remove(n *node) {
	n.prev.next = n.next
	n.next.prev = n.prev
	n.prev = nil
	n.next = nil
}

func (c *LRUCache) Put(key int, value int) {
	// 1) key 已存在：更新 + 提到头部
	if n, ok := c.data[key]; ok {
		n.val = value
		c.moveTo(n, c.head)
		return
	}

	// 2) 新 key：创建 + 插入
	n := &node{val: value, key: key}
	c.moveTo(n, c.head)
	c.data[key] = n
	c.size++

	// 3) 超容量：淘汰尾部
	if c.size > c.cap {
		last := c.tail.prev
		delete(c.data, last.key)
		c.remove(last)
		c.size--
	}
}
