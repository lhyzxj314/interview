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
	
	public int findGreatestSumOfSubArray2(int[] array) {
    if (array == null || array.length == 0)
      return 0;
    
    int[] max = new int[array.length];
    max[0] = array[0];
    for (int i = 1; i < array.length; i++) {
      if (max[i - 1] > 0)
        max[i] = max[i - 1] + array[i];
      else
        max[i] = array[i];
    }
    
    int res = Integer.MIN_VALUE;
    for (Integer m : max)
      res = Math.max(res, m);
    return res;
  }
	
	public static void main(String[] args) {
	  GreatestSumOfSubArray obj = new GreatestSumOfSubArray();
    int[] array = new int[] {-2,-8,-1,-5,-9};
    int res1 = obj.findGreatestSumOfSubArray1(array);
    System.out.println(res1);
    int res2 = obj.findGreatestSumOfSubArray2(array);
    System.out.println(res2);
  }
}
