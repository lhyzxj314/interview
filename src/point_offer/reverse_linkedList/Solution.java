package point_offer.reverse_linkedList;

import java.util.ArrayList;
import java.util.LinkedList;

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}
/**
 * 输入一个链表，从尾到头打印链表每个节点的值
 * @author xiaojun
 * @version 1.0.0
 * @date 2017年5月19日
 */
public class Solution {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode == null)
			return new ArrayList<Integer>();

		LinkedList<Integer> stack = new LinkedList<Integer>();
		while (listNode != null) {
			stack.addFirst(listNode.val);
			listNode = listNode.next;
		}

		ArrayList<Integer> res = new ArrayList<Integer>(stack);
		return res;
	}
}
