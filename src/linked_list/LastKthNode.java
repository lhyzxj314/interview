package linked_list;

/**
 * 链表中倒数第k个结点:
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author xshrimp
 * 2017年5月23日
 */
public class LastKthNode {
  private int count = 0;
  
  /**
   * 解法一： 利用递归执行顺序计数
   * @param head
   * @param k
   * @return
   */
  public ListNode FindKthToTail(ListNode head, int k) {
    if (head == null)
      return head;
    
    ListNode node = FindKthToTail(head.next, k);
    count++;
    if (count == k)
      return head;
    else
      return node;
  }
  
  /**
   * 解法二：利用双指针
   * @param head
   * @param k
   * @return
   */
  public ListNode FindKthToTail1(ListNode head, int k) {
    if (head == null || k == 0)
      return null;
    
    // 双指针
    ListNode prePt = head;
    ListNode postPt = head;
    // 将后指针向后移动k-1个位置(失败则说明链表过短)
    for (int i = 0; i < k - 1; i++) {
      if (postPt.next != null)
        postPt = postPt.next;
      else
        return null;
    }
    
    // 两指针同时后移，直到后指针指向末尾节点
    while (postPt.next != null) {
      prePt = prePt.next;
      postPt = postPt.next;
    }
    
    return prePt;
  }
  
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode n1   = new ListNode(2);
    ListNode n2   = new ListNode(3);
    
    head.next = n1;
    n1.next   = n2;
    LastKthNode t = new LastKthNode();
    System.out.println(t.FindKthToTail1(head, 3).val);
  }
}
