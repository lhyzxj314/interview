package point_offer.reverse_linkedList;

import java.util.ArrayList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值
 * @author xiaojun
 * @version 1.0.0
 * @date 2017年5月19日
 */
public class Solution2 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (listNode == null)
			return res;

		if (listNode != null) {
			res = printListFromTailToHead(listNode.next);
			res.add(listNode.val);
		}
		return res;
	}
}
