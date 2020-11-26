/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
// medium
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
  var result = new ListNode(-1);
  var p = result;
  var prep = null;
  var needDeleteLast = false;

  var node = head;
  while (node != null) {

    if (p.val != node.val) {
      if (needDeleteLast) {
        // delete last
        p = prep;
        needDeleteLast = false;
      }
      p.next = new ListNode(node.val);
      prep = p;
      p = p.next;


    } else {
      needDeleteLast = true;
    }

    node = node.next;
  }

  return result.next;
};
