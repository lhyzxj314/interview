package string_pattern;

public class StringPattern {
  public boolean isPattern(String pattern, String str) {
    if (pattern == null || str == null 
        || pattern.length() != str.length()) 
      return false;
    
    char[] str1 = pattern.toCharArray();
    char[] str2 = str.toCharArray();
    
    return false;
  }
}
