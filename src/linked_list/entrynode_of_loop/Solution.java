package linked_list.entrynode_of_loop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

		ListNode l = new Solution().EntryNodeOfLoop(h1);
		System.out.println(l.val);
	}

	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        Map<ListNode, Object> st = new HashMap<ListNode, Object>();
        while (pHead != null) {
            if ( !st.containsKey(pHead) )
            	st.put(pHead, null);
            else
                return pHead;
            pHead = pHead.next;
        }
        return null;
    }
	
	public ListNode EntryNodeOfLoop1(ListNode pHead)
    {
        Set<ListNode> set = new HashSet<ListNode>();
        while (pHead != null) {
        	if (set.add(pHead)) 
        		pHead = pHead.next;
        	else 
        		return pHead;
        }
        return null;
    }
	
}
