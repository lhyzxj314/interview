package linked_list;

/**
 * 合并两个排序的链表
 * 
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * @author xshrimp 2017年5月29日
 */
public class Merge {
  // 迭代实现
  public ListNode merge1(ListNode list1, ListNode list2) {
    if (list1 == null)
      return list2;
    if (list2 == null)
      return list1;

    ListNode head = null;
    ListNode current = null;
    while (list1 != null && list2 != null) {
      ListNode selectedNode = null;
      if (list1.val <= list2.val) {
        selectedNode = list1;
        list1 = list1.next;
      } else {
        selectedNode = list2;
        list2 = list2.next;
      }

      if (head == null) {
        head = selectedNode;
        current = head;
      } else {
        current.next = selectedNode;
        current = current.next;
      }

    }
    current.next = list1 == null ? list2 : list1;
    return head;
  }

  // 递归实现
  public ListNode merge2(ListNode list1, ListNode list2) {
    if (list1 == null)
      return list2;
    if (list2 == null)
      return list1;

    ListNode head = null;
    if (list1.val <= list2.val) {
      head = list1;
      head.next = merge2(list1.next, list2);
    } else {
      head = list2;
      head.next = merge2(list1, list2.next);
    }
    return head;
  }
}
