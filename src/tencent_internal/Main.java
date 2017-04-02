package tencent_internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String input = sc.nextLine();
      
      Map<StringBuilder, StringBuilder> cache = new HashMap<StringBuilder, StringBuilder>();
      cache.put(new StringBuilder(input), new StringBuilder());
      StringBuilder res = longestLoopStr(new StringBuilder(input), cache);
      
      System.out.println(res);
      System.out.println(input.length() - res.length());
    }
  }

  static StringBuilder longestLoopStr(StringBuilder str, Map<StringBuilder, StringBuilder> cache) {
    
    // 记录每个字符出现的位置
    Map<Character, Set<Integer>> map = new HashMap<Character, Set<Integer>>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (map.get(c) == null) {
        Set<Integer> set = new TreeSet<Integer>();
        set.add(i);
        map.put(c, set);
      } else {
        map.get(c).add(i);
      }
    }

    //StringBuilder res = new StringBuilder();
    Set<Character> set = map.keySet();
    // 尝试计算字符串str可能包含的回文
    for (Character c : set) {
      List<Integer> indexs = new ArrayList<Integer>(map.get(c)); // 字符c所有出现位置
      Collections.sort(indexs);
      int indexMax = indexs.get(indexs.size() - 1); // 字符c最大索引
      int indexMin = indexs.get(0); // 字符c最小索引
    
      StringBuilder tempRes = new StringBuilder();
      if (cache.get(str) != null && 
          cache.get(str).length() >= (indexMax - indexMin + 1)) {
        tempRes = cache.get(str);
      } else if (indexMin == indexMax) {
        tempRes = new StringBuilder(str.charAt(indexMin) + "");
      } else if (indexMax == indexMin + 1) {
        tempRes = new StringBuilder(str.charAt(indexMin) + "" + str.charAt(indexMin));
      } else if (indexMax > indexMin + 1) {
        String input = str.substring(indexMin + 1, indexMax);
        cache.put(new StringBuilder(input), new StringBuilder());
        tempRes = longestLoopStr(new StringBuilder(input), cache);
        tempRes = new StringBuilder(str.charAt(indexMin) + "").append(tempRes)
            .append(str.charAt(indexMax));
      }
      
      // 缓存str中最长的回文
      cache.put(str, tempRes);
      /*// 选最长的回文
      if (tempRes.length() > res.length())
        res = tempRes;*/
    }
    return cache.get(str);
  }

}
