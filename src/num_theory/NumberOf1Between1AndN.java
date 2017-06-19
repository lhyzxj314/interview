package num_theory;

/**
 * 整数中1出现的次数
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * @author xiaojun
 * @version 1.0.0
 * @date 2017年6月19日
 */
public class NumberOf1Between1AndN {
	
	
	public int NumberOf1Between1AndN_Solution(int n) {
		if (n < 1)
			return 0;

		int count = 0;
		
		int weight = 1;
		int round = n;
		int former = 0;
		while (round > 0) {
			int base = round % 10;
			round = round / 10;
			
			if (base > 1) {
				count += weight * (round + 1);
			} else if (base < 1) {
				count += weight * round;
			} else if (base == 1) {
				count += (weight * round + former + 1);
			}
			
			former += weight * base;
			weight = 10 * weight;
		}
	    return count;
    }
	
	public static void main(String[] args) {
		NumberOf1Between1AndN obj = new NumberOf1Between1AndN();
		int res = obj.NumberOf1Between1AndN_Solution(203);
		System.out.println(res);
		
		System.out.println(203 % 100);
	}
}
