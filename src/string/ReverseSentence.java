package string;

/**
 * 翻转单词顺序列
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author xiaojun
 * @version 1.0.0
 * @date 2017年7月6日
 */
public class ReverseSentence {
	
	public String reverseSentence(String str) {
		if (str == null || str.trim().equals(""))
			return str;
		
		String[] words = str.split(" ");
		StringBuilder sb = new StringBuilder();
		// 翻转重建
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i]);
			if (i != 0) {
				sb.append(" ");
			}
		}
		
        return sb.toString();
    }
	
	public String reverseSentence1(String str) {
		if (str == null || str.trim().equals(""))
			return str;
		
		String[] words = str.split(" ");
		// 翻转
		for (int i = 0, j = words.length - 1; i < j; i++, j--) {
			String tmpStr = words[i];
			words[i] = words[j];
			words[j] = tmpStr;
		}
		
		StringBuilder sb = new StringBuilder();
		// 重建
		for (int i = 0; i < words.length; i++) {
			sb.append(words[i]);
			if (i != words.length - 1) {
				sb.append(" ");
			}
		}
        return sb.toString();
    }
}
