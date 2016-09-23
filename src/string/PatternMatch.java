package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入:pattern:abba str:cat cat fish fish
 * 返回:false
 * 
 * 输入：pattern:abba str:cat fish fish cat
 * 返回：true 
 * */
public class PatternMatch {
	
	public boolean isPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		if (pattern == null || str == null
			|| pattern.length() != strs.length) 
			return false;
		
		Map<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < strs.length; i++) {
			if (!map.containsKey(pattern.charAt(i)) && !map.containsValue(strs[i]))
					map.put(pattern.charAt(i), strs[i]);
			else {
				if (strs[i].equals( map.get(pattern.charAt(i) ))) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
	// for test
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			String pattern = sc.nextLine();
			String str = sc.nextLine();
			if ("exit".equals(pattern) || "exit".equals(str)) {
				break;
			}
			boolean isPattern = new PatternMatch().isPattern(pattern, str);
			System.out.println(isPattern);
		}
	}
}
