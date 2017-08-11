package string;

/**
 * 实现正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @author xshrimp
 * 2017年8月10日
 */
public class Match {
  public boolean match(char[] str, char[] pattern) {
    if (str == null || pattern == null)
      return false;

    int strIndex = 0;
    int patIndex = 0;
    return matchAux(str, strIndex, pattern, patIndex);
  }
  
  private boolean matchAux(char[] str, int strIndex, char[] pattern, int patIndex) {
    if (strIndex == str.length && patIndex == pattern.length)
      return true;
    if (strIndex < str.length && patIndex >= pattern.length)
      return false;
    
    if (patIndex + 1 < pattern.length && pattern[patIndex + 1] == '*') {
      if ((strIndex < str.length && str[strIndex] == pattern[patIndex]) 
       || (strIndex < str.length && pattern[patIndex] == '.')) {
        
        return matchAux(str, strIndex, pattern, patIndex + 2)
            || matchAux(str, strIndex + 1, pattern, patIndex)
            || matchAux(str, strIndex + 1, pattern, patIndex + 2);
      } else {
        return matchAux(str, strIndex, pattern, patIndex + 2);
      }
    }
    
    if ((strIndex < str.length && str[strIndex] == pattern[patIndex]) 
       || (patIndex < pattern.length && pattern[patIndex] == '.')) {
      return matchAux(str, strIndex + 1, pattern, patIndex + 1);
    }
    
    return false;
      
  }
  
  public boolean match1(char[] str, char[] pattern) {
    if (str == null || pattern == null 
        || str.length == 0 || pattern.length == 0)
      return false;
    
    String target = new String(str);
    String pat = new String(pattern);
    return target.matches(pat);
  }
  
  public static void main(String[] args) {
    Match obj = new Match();
    char[] str = "".toCharArray();
    char[] pattern = ".*".toCharArray();
    boolean res = obj.match(str, pattern);
    System.out.println(res);
  }
}
