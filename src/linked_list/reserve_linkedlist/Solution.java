package linked_list.reserve_linkedlist;


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

		ListNode l = new Solution().ReverseList3(h1);
		System.out.println(l.val);
	}

	/** ��������ͷ��β����޸����÷��� */
	public ListNode ReverseList1(ListNode head) {
		if (head == null)
			return head;
		
		ListNode pre = null;
		ListNode cur = head;
		ListNode tmp = null; // ��������
		while (cur != null) {
			tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}

	/** �ݹ飬��β��ͷ����޸����÷��� */
	public ListNode ReverseList2(ListNode head) {
		if (head == null) 	   // ������
			return null;

		if (head.next == null) // �ݹ���ֹ����
			return head;
		else {
			ListNode ptr = head;
			head = ReverseList2(head.next);
			ptr.next.next = ptr;
			ptr.next = null;
		}
		return head;
	}
	
	/** ������������������Ļ�������������ڵ㡢ɾ���ڵ�*/
	public ListNode ReverseList3(ListNode head) {
		if (head == null) 	   // ������
			return null;
		
		ListNode oldHead = head;
		while (oldHead.next != null) {
			// ɾ��ԭͷ������һ���ڵ�
			ListNode tmp = oldHead.next;
			oldHead.next = oldHead.next.next;
			
			// ����ɾ���ڵ�ŵ�����ͷ��
			tmp.next = head;
			head = tmp;
		}
		return head;
	}
	
}
