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
		
		Queue<Integer> nonEmptyQueue = q2.isEmpty() ? q1 : q2;  		// 非空队列
		Queue<Integer> emptyQueue = nonEmptyQueue == q1 ? q2 : q1;      // 空队列
		
		Integer tmp = null;
		/* 非空队列所有元素出队列 */
		while ((tmp = nonEmptyQueue.poll()) != null) {     
			if (nonEmptyQueue.isEmpty())       // 返回最后一个元素
				return tmp;
			emptyQueue.add(tmp);	           // 最后一个元素加入空队列
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
