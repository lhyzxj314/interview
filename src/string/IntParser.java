package string;

/**
 * 将字符串转换成整数
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * @author xshrimp
 * 2017年7月23日
 */
public class IntParser {
  
  public int StrToInt(String str) {
    str = str.trim();
    if (str == null || str.length() == 0)
      return 0;
    if (str.length() == 1 
        && '0' <= str.charAt(0) && str.charAt(0) <= '9')
      return 0;
      
    // 处理符号位
    int symbol = 1;
    if (str.startsWith("+")) {
      symbol = 1;
      str = str.substring(1);
    } else if (str.startsWith("-")) {
      symbol = -1;
      str = str.substring(1);
    }
    
    // 解析数字字符
    int value = 0;
    for (int i = 0; i < str.length(); i++) {
      if ('0' <= str.charAt(i) && str.charAt(i) <= '9')
        value = value * 10 + (str.charAt(i) - '0');
      else
        return 0;
    }
    return symbol * value;
  }
  
  public static void main(String[] args) {
    IntParser obj = new IntParser();
    int res = obj.StrToInt("+123");
    System.out.println(res);
  }
}
