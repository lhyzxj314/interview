package array;

import java.util.ArrayList;

/**
 * 和为S的2个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @author xiaojun
 * @version 1.0.0
 * @date 2017年7月11日
 */
public class FindNumbersWithSum {
	public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		if (array == null || array.length == 0)
			return list;
		
		for (int i = 0; i < array.length; i++) {
			int otherNum = sum - array[i];
			int index = binarySearch(array, i + 1, array.length - 1, otherNum);
			if (index != -1) {
				if (!list.isEmpty()) {
					int multi = list.get(0) * list.get(1);
					if (multi > array[i] * array[index]) {
						list.clear();
						list.add(array[i]);
						list.add(array[index]);
					}
				} else {
					list.add(array[i]);
					list.add(array[index]);
				}
			}
		}
		return list;
	}
	
	private int binarySearch(int[] arr, int lo, int hi, int key) {
		int mid = lo + (hi - lo) / 2;
		
		while (lo <= hi) {
			if (arr[mid] == key) 
				return mid;
			else if (arr[mid] < key) {
				lo = mid + 1;
			} else if (arr[mid] > key) {
				hi = mid - 1;
			}
			mid = lo + (hi - lo) / 2;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		FindNumbersWithSum obj = new FindNumbersWithSum();
		int[] arr = new int[] { 1, 2, 3 , 4, 5, 6};
		int res = obj.binarySearch(arr, 0, arr.length - 1, 7);
		System.out.println(res);
	}
}
