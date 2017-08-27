package point_offer.replace_space;

public class Test {
	public String replaceSpace(StringBuffer str) {
		if (str == null || str.length() == 0)
			return str.toString();

		int spaceNum = 0;
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == ' ')
				spaceNum++;

		int oldLen = str.length();
		int newLen = str.length() + spaceNum * 2;
		str.setLength(newLen);

		for (int i = oldLen - 1, j = newLen - 1; i < j; i--, j--) {
			if (str.charAt(i) != ' ') {
				str.setCharAt(j, str.charAt(i));
				str.setCharAt(i, ' ');
			} else {
				str.setCharAt(j--, '0');
				str.setCharAt(j--, '2');
				str.setCharAt(j, '%');
			}
		}
		return str.toString();
	}

	public static void main(String[] args) {
		Test t = new Test();
		StringBuffer str = new StringBuffer("hello world");
		System.out.println(t.replaceSpace(str));
	}
}
