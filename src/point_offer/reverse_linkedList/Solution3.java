package point_offer.reverse_linkedList;

import java.util.ArrayList;

public class Solution3 {
    // 头插法
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (listNode == null)
            return res;

        ListNode head = new ListNode(0);
        while (listNode != null) {
            ListNode temp = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = temp;
        }

        head = head.next;

        while (head != null) {
            res.add(head.val);
            head = head.next;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        one.next = two;
        two.next = three;

        System.out.println(solution.printListFromTailToHead(one));
    }
}
