package linked_list;

/**
 * 删除链表中重复的节点
 * 
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * @author xshrimp 2017年6月5日
 */
public class DeleteDuplication {
  /**
   * 递归实现
   * @param pHead
   * @return
   */
  public ListNode deleteDuplication1(ListNode pHead) {
    if (pHead == null)
      return null;
    if (pHead.next == null)
      return pHead;

    if (pHead.val == pHead.next.val) {
      while (pHead.next != null && pHead.val == pHead.next.val)
        pHead = pHead.next;
      pHead = pHead.next;
      pHead = deleteDuplication1(pHead);
    } else
      pHead.next = deleteDuplication1(pHead.next);

    return pHead;
  }

  /**
   * 迭代实现
   * @param pHead
   * @return
   */
  public ListNode deleteDuplication2(ListNode pHead) {
    ListNode first = new ListNode(-1);
    ListNode last = first;
    first.next = pHead;
    
    ListNode p = pHead;
    while (p != null && p.next != null) {
      if (p.val == p.next.val) {
        int val = p.val;
        while (p != null && p.val == val)
          p = p.next;
        last.next = p;
      } else {
        last = p;
        p = p.next;
      }
    }
    return first.next;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    ListNode n1 = new ListNode(2);
    head.next = n1;
    ListNode n2 = new ListNode(3);
    n1.next = n2;
    ListNode n3 = new ListNode(3);
    n2.next = n3;
    ListNode n4 = new ListNode(4);
    n3.next = n4;
    ListNode n5 = new ListNode(4);
    n4.next = n5;
    ListNode n6 = new ListNode(5);
    n5.next = n6;

    DeleteDuplication obj = new DeleteDuplication();
    head = obj.deleteDuplication2(head);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
