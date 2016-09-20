package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsContinuous {
	
	public boolean isContinuous(int[] numbers) {
	    if (numbers.length == 0)
	      return false;

	    Arrays.sort(numbers);
	    int offset = 0;
	    int zeroCount = 0;
	    for (int i = 0; i < numbers.length - 1; i++) {
	      if (numbers[i] == 0)
	        zeroCount++;
	      else if (numbers[i + 1] == numbers[i])
	        return false;
	      else if (numbers[i + 1] - numbers[i] > 1) {
	        offset += (numbers[i + 1] - numbers[i] - 1);
	      }
	    }

	    return (zeroCount >= offset);
	  }

	  public boolean isContinuous1(int[] numbers) {
	    if (numbers.length == 0)
	      return false; // 长度为0，不是顺子
	    
	    Map<Integer, Boolean> st = new HashMap<Integer, Boolean>(); // 散列表
	    int zeroCount = 0;
	    int max = Integer.MIN_VALUE;
	    int min = Integer.MAX_VALUE;
	    for (int i = 0; i < numbers.length; i++) {
	      if (numbers[i] == 0)
	        zeroCount++; // 大小王个数
	      else if (st.containsKey(numbers[i]))
	        return false; // 存在重复点数,不是顺子
	      else {
	        st.put(numbers[i], true);
	        /* 获取最大点数、最小点数 */
	        if (max < numbers[i])
	          max = numbers[i];
	        if (min > numbers[i])
	          min = numbers[i];
	      }
	    }

	    int len = st.keySet().size();
	    int offset = max - min + 1;
	    /* 下判断 */
	    if (len == offset)
	      return true;
	    else if (len < offset) {
	      int blankNum = offset - len;
	      return zeroCount >= blankNum;
	    }

	    return false;
	  }
}
