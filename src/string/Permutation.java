package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 
 * @author xiaojun
 * @version 1.0.0
 * @date 2017年6月15日
 */
public class Permutation {
	public ArrayList<String> permutation(String str) {
		if (str == null || str.equals(""))
			return new ArrayList<String>();
		
		StringBuffer sb = new StringBuffer(str);
		ArrayList<String> res = new ArrayList<String>();
		Set<String> temp = new HashSet<String>();
		for (int i = 0; i < sb.length(); i++) {
			StringBuffer tempStr = new StringBuffer(str);
			StringBuffer head = new StringBuffer(tempStr.substring(i, i + 1));
			StringBuffer tail = new StringBuffer(tempStr.deleteCharAt(i));
			ArrayList<StringBuffer> strsBuffer = permution(head, tail);
			for (StringBuffer s : strsBuffer)
				temp.add(s.toString());
		}
		res.addAll(temp);      // 去重
		Collections.sort(res); // 按字典序排列
		return res;
	}
	
	public ArrayList<StringBuffer> permution(StringBuffer head, StringBuffer tail) {
		ArrayList<StringBuffer> res = new ArrayList<StringBuffer>();
		if (tail.length() == 0) {
			res.add(head);
			return res;
		}
		
		for (int i = 0; i < tail.length(); i++) {
			StringBuffer tempStr = new StringBuffer(tail);
			StringBuffer tTead = new StringBuffer(tempStr.substring(i, i + 1));
			StringBuffer tTail = new StringBuffer(tempStr.deleteCharAt(i));
			ArrayList<StringBuffer> tails = permution(tTead, tTail);
			for (StringBuffer t : tails) {
				StringBuffer h = new StringBuffer(head);
				res.add(h.append(t));
			}
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		Permutation obj = new Permutation();
		ArrayList<String> strs = obj.permutation("abc");
		for (String s : strs)
			System.out.println(s);
	}
}
