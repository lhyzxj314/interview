package linked_list.common_node;

public class Solution {

	public static void main(String[] args) {
		ListNode h1 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		h1.next = n1;
		ListNode n2 = new ListNode(3);
		n1.next = n2;
		
		ListNode n3 = new ListNode(6);
		n2.next = n3;
		ListNode n4 = new ListNode(7);
		n3.next = n4;
		
		ListNode h2 = new ListNode(4);
		n1 = new ListNode(5);
		h2.next = n1;
		n1.next = n3;
		
		ListNode l =new Solution().FindFirstCommonNode(h1, h2);
		System.out.println(l.val);
	}
	
	 public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
	        if (pHead1 == null || pHead2 == null) return null;
	        
	 		int len1 = 0;
	        int len2 = 0;
	        ListNode h1 = pHead1;
	        // 统计2个链表的长度
	        while (h1 != null) {
	            h1 = h1.next;
	            len1++;
	        }
	        h1 = pHead2;
	        while (h1 != null) {
	            h1 = h1.next;
	            len2++;
	        }
	        
	        int diff = (len1>=len2) ? (len1-len2) : (len2-len1);
	        h1 = (len1>=len2) ? pHead1 : pHead2;          // 长链表
	        ListNode h2 = (h1==pHead1) ? pHead2 : pHead1; // 短链表
	        // 忽略长链表的多余元素
	        for (; diff > 0; diff--) {
	            h1 = h1.next;
	        }
	        
	        // 查找相同元素
	        while (h1 != h2) {
	            h1 = h1.next;
	            h2 = h2.next;
	        }
	        return h1;
	    }

}
