package linked_list.reserve_part_list;

import java.util.ArrayList;
import java.util.List;

public class Test {
	/*public LNode reverse(LNode head) {
		int len = 0;
		LNode last = null;
		for (LNode h = head; h != null; h = h.next) {
			len++;
			if (h.next == null) {
				last = h;
			}
		}
		
		int m_index = len / 2;
		int index = -1;
		for (LNode h = head; h != null; h = h.next)  {
			index++; 
			if (index == (m_index-1)) {
				index = 
				index = 
			}
		}
		return null;
	}*/
	
	public LNode reverse(LNode head) {
		List<Integer> list = new ArrayList<Integer>();
		for (LNode h = head; h != null; h = h.next) 
			list.add(h.value);
		int len = list.size();
		int m_index = len / 2;
		int l_index = len - 1;
		do {
			int tmp = list.get(m_index);
			list.set(m_index, list.get(l_index));
			list.set(l_index, tmp);
			m_index++;
			l_index--;
			if (Math.abs(m_index - l_index) == 1) break;
		} while(m_index != l_index);
		
		LNode h = null;
		LNode c=  null;
		LNode n = null;
		int count = 0;
		for (Integer i : list) {
			if (count++ == 0) {
				h = new LNode();
				h.value = i;
				c = h;
			} 
			else {
				n = new LNode();
				n.value = i;
				c.next = n;
				c = n;
			}
			
		}
		return h;
	}
	
	public static void main(String[] args) {
		LNode n1 = new LNode();
		n1.value = 1;
		LNode n2 = new LNode();
		n2.value = 2;
		LNode n3 = new LNode();
		n3.value = 3;
		LNode n4 = new LNode();
		n4.value = 4;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		new Test().reverse(n1);
		/*LNode n4 = new LNode();
		n2.value = 2;*/
	}
}
