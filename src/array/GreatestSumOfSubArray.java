package array;

public class GreatestSumOfSubArray {

	public int findGreatestSumOfSubArray1(int[] array) {
		if (array == null || array.length == 0)
			return 0;

		int maxSum = Integer.MIN_VALUE;
		int tempSum = 0;
		for (int i = 0; i < array.length; i++) {
			if (tempSum < 0)
				tempSum = array[i];
			else
				tempSum += array[i];

			if (tempSum > maxSum)
				maxSum = tempSum;
		}
		return maxSum;
	}
}
