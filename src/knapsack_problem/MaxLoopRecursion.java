package knapsack_problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 求输入字符串的最大回文自序列长度
 * 
 * @author xshrimp
 * 2017年4月3日
 */
public class MaxLoopRecursion {

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
    
    // 所有区段
    Set<Character> set = map.keySet();
    List<Interval> intervals = new CopyOnWriteArrayList<Interval>();
    for (Character c : set) {
      Interval interval = new Interval(c, map.get(c));
      intervals.add(interval);
    }
    
    // 去处被包含区段
    for (int i = 0; i < intervals.size(); i++) {
      for (int j = i + 1; j < intervals.size(); j++) {
        if (intervals.get(i).contains(intervals.get(j))) {
          intervals.remove(intervals.get(j));
        }
      }
    }
    
    // 尝试计算字符串str可能包含的回文
    for (Interval interval : intervals) {
      StringBuilder tempRes = new StringBuilder();
      int indexMin = interval.indexMin;
      int indexMax = interval.indexMax;
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
  
  static class Interval {
    private static int count = 0;
    private final int id = count++;
    final char c;
    final int indexMax;
    final int indexMin;
    
    Interval(char c, Set<Integer> indexSet) {
      List<Integer> indexs = new ArrayList<Integer>(indexSet); // 字符c所有出现位置
      Collections.sort(indexs);
      this.c = c;
      this.indexMin = indexs.get(0);
      this.indexMax = indexs.get(indexs.size() - 1);
    }
    
    public boolean contains(Interval other) {
      if (other.indexMax <= this.indexMax
          && other.indexMin >= this.indexMin) {
        return true;
      }
      return false;
    }
    

    @Override
    public String toString() {
      return "id=" + id + ", c=" + c;
    }

    @Override
    public int hashCode() {
      return id;
    }

    @Override
    public boolean equals(Object obj) {
      Interval that = (Interval) obj;
      if (this.id == that.id) return true;
      else return false;
    }
  }
}
