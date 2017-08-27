package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 和为S的连续整数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * @author xiaojun
 * @version 1.0.0
 * @date 2017年7月11日
 */
public class FindContinuousSequence {
	
	/**
	 * 解二元一次方程
	 * @author xiaojun
	 * @version 1.0.0
	 * @param sum
	 * @return
	 * @date 2017年7月11日
	 */
	public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (sum <= 0)
			throw new IllegalArgumentException("非法入参!");
		if (sum < 3)
			return res;
		
		int endNum = (int) Math.sqrt(2 * sum);
		for (int l = endNum; l >= 2; l--) {
			if (2*sum % l == 0) {
				int k = 2*sum / l;
				if (k%2 == 0 && l%2 != 0 || k%2 != 0 && l%2 == 0) {
					int a1 = (k - l + 1) / 2;
					int an = (k + l - 1) / 2;
					ArrayList<Integer> list = new ArrayList<Integer>();
					for (int i = a1; i <= an; i++)
						list.add(i);
					res.add(list);
				}
			}
		}
		
		return res;
	}
	
	/**
	 *  暴力解法
	 * @author xiaojun
	 * @version 1.0.0
	 * @param sum
	 * @return
	 * @date 2017年7月11日
	 */
	public ArrayList<ArrayList<Integer>> findContinuousSequence2(int sum) {
		if (sum <= 0)
			throw new IllegalArgumentException("非法入参!");
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		int endNum = sum / 2 + 1;
		int tempSum = 0;
		for (int i = 1; i <= endNum; i++, tempSum = 0) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = i; j <= endNum; j++) {
				tempSum += j;
				list.add(j);
				if (tempSum == sum && j != i) {
					res.add(list);
					break;
				}
			}
		}
		
		return res;
	}
	
	/**
	 * 使用队列，减少运算次数,时间复杂度O(n)
	 * @author xiaojun
	 * @version 1.0.0
	 * @param sum
	 * @return
	 * @date 2017年7月11日
	 */
	public ArrayList<ArrayList<Integer>> findContinuousSequence1(int sum) {
		if (sum <= 0)
			throw new IllegalArgumentException("非法入参!");
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		int endNum = sum / 2 + 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		int tempSum = 0;
		for (int i = 1; i <= endNum; i++) {
			tempSum += i;
			queue.offer(i);
			
			while (tempSum > sum && !queue.isEmpty())
				tempSum -= queue.poll();
			
			if (tempSum == sum && queue.size() > 1) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (Integer n : queue) list.add(n);
				res.add(list);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		FindContinuousSequence client = new FindContinuousSequence();
		ArrayList<ArrayList<Integer>> res = client.findContinuousSequence(10000);
		for (ArrayList<Integer> list : res) {
			for (Integer n : list)
				System.out.print(n + " ");
			System.out.println();
		}
	}
	
}
