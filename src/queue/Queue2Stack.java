package queue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Queue2Stack {
	
	Queue<Integer> q1 = new LinkedBlockingQueue<Integer>();
	Queue<Integer> q2 = new LinkedBlockingQueue<Integer>();
	
	boolean flag = true;   // false <-> q2; true <-> q1
	
	public void push(int elem) {
		Queue<Integer> nonEmptyQueue = q2.isEmpty() ? q1 : q2; 
		nonEmptyQueue.add(elem);
	}
	
	public Integer pop() {
		if (q1.isEmpty() && q2.isEmpty()) 
			return null;
		
		Queue<Integer> nonEmptyQueue = q2.isEmpty() ? q1 : q2;  		// �ǿն���
		Queue<Integer> emptyQueue = nonEmptyQueue == q1 ? q2 : q1;      // �ն���
		
		Integer tmp = null;
		/* �ǿն�������Ԫ�س����� */
		while ((tmp = nonEmptyQueue.poll()) != null) {     
			if (nonEmptyQueue.isEmpty())       // �������һ��Ԫ��
				return tmp;
			emptyQueue.add(tmp);	           // ���һ��Ԫ�ؼ���ն���
		}
		return null;
	}

	public static void main(String[] args) {
		Queue2Stack obj = new Queue2Stack();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		obj.push(4);
		obj.push(5);
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
	}
}
