package reverse_link;

public class Solution {
  public ListNode ReverseList(ListNode head) {
      if (head == null) 
        return head;
      ListNode cur  = head;  // 当前指向节点
      ListNode pre = null;   // cur节点的前个一节点 
      ListNode tmp = null;   // 辅助引用
      while (cur != null) {
          tmp = cur.next;
          cur.next = pre;    // 反转引用
          /* 将pre、cur前移一个节点 */
          pre = cur;         
          cur = tmp;
      }
      return pre;
  }
}
