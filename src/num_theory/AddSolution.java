package num_theory;

/**
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author xiaojun
 * @version 1.0.0
 * @date 2017年6月14日
 */
public class AddSolution {
	// 非递归
	public int Add1(int num1,int num2) {
        do {
            int temp1 = (num1 & num2) << 1;
            int temp2 = num1 ^ num2; 
            num1 = temp1;
            num2 = temp2;
        } while ((num1 & num2) != 0);
        
    	return num1 | num2;
    }
	
	// 递归
	public int Add2(int num1,int num2) {
		int temp1 = (num1 & num2) << 1;
        int temp2 = num1 ^ num2; 
        
		if ((temp1 & temp2) == 0)
			return temp1 | temp2;
		else
			return Add2(temp1, temp2);
    }
}
