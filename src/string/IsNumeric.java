package string;

/**
 * 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author xshrimp
 * 2017年8月8日
 */
public class IsNumeric {
  public boolean isNumeric(char[] str) {
    if (str == null || str.length == 0)
      return false;
    
    String str1 = new String(str);
    String regex = 
        "^(\\+|-?)([1-9][0-9]*|0?)((\\.[0-9]*)?)(((E|e)((\\+|-?)[1-9][0-9]*))?)";
    return str1.matches(regex);
  }
  
  public static void main(String[] args) {
    IsNumeric obj = new IsNumeric();
    char[] str = "-9e+1".toCharArray();
    char[] str1 = "-.101".toCharArray();
    boolean res1 = obj.isNumeric(str);
    System.out.println(res1);
    boolean res2 = obj.isNumeric(str1);
    System.out.println(res2);
  }
}
