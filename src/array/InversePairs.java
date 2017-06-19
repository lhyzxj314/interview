package array;

public class InversePairs {
	private long count = 0;
	private int[] aux;
	
	public int inversePairs(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        aux = new int[array.length];
        
        inversePairs(array, 0, array.length - 1);
        return (int) (count % 1000000007);
    }
	
	private void inversePairs(int[] array, int start, int end) {
		if (start >= end)
			return;
		
		int mid = start + (end - start) / 2;
		inversePairs(array, start, mid);
		inversePairs(array, mid + 1, end);
		
		// merge
		for (int i = start; i <= end; i++)
			aux[i] = array[i];
		
		int i = start, j = mid + 1;
		int k = start;
		while (k <= end) {
			if (i > mid) 			   array[k++] = aux[j++];
			else if (j > end)          array[k++] = aux[i++];
			else if (aux[i] <= aux[j]) array[k++] = aux[i++];
			else {
				array[k++] = aux[j++];
				count += (mid - i + 1);
			}
		}
	}
	
	// 暴力解法
	public int inversePairs2(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        
        int count = 0;
        for (int i = 1; i < array.length; i++)
        	for (int j = i; j > 0; j--) {
        		if (array[j - 1] > array[i])
        			count++;
        	}
        
        return count;
    }
	
	public static void main(String[] args) {
		InversePairs obj = new InversePairs();
		int[] array = new int[] {4,2,1,6,7,8,0};
		//int[] array = new int[] {3,1,2,0};
		obj.inversePairs(array);
		System.out.println(obj.count);
		
		array = new int[] {4,2,1,6,7,8,0};
		//array = new int[] {3,1,2,0};
		System.out.println(obj.inversePairs2(array));
	}
}
