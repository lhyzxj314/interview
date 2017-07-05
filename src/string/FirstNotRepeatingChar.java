package string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstNotRepeatingChar {
	
	private LinkedHashMap<Character, Integer> table = new LinkedHashMap<Character, Integer>();
	
	 //Insert one char from stringstream
    public void Insert(char ch)
    {
       if (table.containsKey(ch))
    	   table.put(ch, table.get(ch) + 1);
       else
    	   table.put(ch, 1);
    }
    
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	for (Character ch : table.keySet()) {
    		if (table.get(ch) == 1)
    			return ch;
    	}
    	return '#';
    }
	
	public int firstNotRepeatingChar(String str) {
		if (str == null || str.length() == 0)
			return -1;
		
		Map<Character, Integer> table = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);
			if (table.get(letter) == null)
				table.put(letter, i);
			else if (table.get(letter) < Integer.MAX_VALUE)
				table.put(letter, Integer.MAX_VALUE);
		}
		
		Set<Character> keys = table.keySet();
		int minIndex = Integer.MAX_VALUE;
		for (Character c : keys) {
			int index = table.get(c);
			if (index != Integer.MAX_VALUE && minIndex > index)
				minIndex = index; 
		}
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
	
	public int firstNotRepeeatingChar1(String str) {
		if (str == null || str.length() == 0)
			return -1;
		
		LinkedHashMap<Character, Integer> table = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);
			if (table.containsKey(letter)) {
				table.put(letter, -1);
			} else
				table.put(letter, i);
		}
		
		int index = -1;
		for (Character key : table.keySet()) {
			if (table.get(key) != -1) {
				index = table.get(key);
				break;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		FirstNotRepeatingChar obj = new FirstNotRepeatingChar();
		int res1 = obj.firstNotRepeatingChar("google");
		System.out.println(res1);
		int res2 = obj.firstNotRepeatingChar("google");
		System.out.println(res2);
		
	}
}
