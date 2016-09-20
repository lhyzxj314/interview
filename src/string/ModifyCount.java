package string;

import java.util.Arrays;
import java.util.Scanner;

public class ModifyCount {

	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			int res = new ModifyCount().modifyCount(input);
			System.out.println(res);
		}
	}

	public int modifyCount(String input) {
		if (input == null || "".equals(input))
			return 0;

		String strs[] = input.split(" ");

		char[] str1 = strs[0].toCharArray();
		char[] str2 = strs[1].toCharArray();
		int count = 0;
		/* 长度相等，将不同的字符进行替换即可 */
		if (str1.length == str2.length) {
			for (int i = 0; i < str1.length; i++) {
				if (str1[i] != str2[i]) {
					count++;
				}
			}
			return count;
		}

		/* 长度不等  */
		// 1.找出短数组
		if (str1.length > str2.length) {
			char[] tmp = str1;
			str1 = str2;
			str2 = tmp;
		}
		int offset = Math.abs(str1.length - str2.length); // 2个字符串长度差
		str1 = Arrays.copyOf(str1, str2.length);		  // 填充短字符数组，使2个数组等长

		// 2.尝试对短的先添加后替换
		int count1 = 0;
		for (int i = 0, j = 0; j < str2.length;) {
			if (j - i < offset) {
				if (str1[i] == str2[j]) {
					i++;
					j++;
				} else {
					j++;
					count1++;
				}
			} else {
				if (str1[i] != str2[j]) {
					count1++;
				}
				i++;
				j++;
			}
		}

		// 3.尝试对短的先替换后添加
		int count2 = 0;
		for (int i = 0; i < str1.length; i++) {
			if (str1[i] != str2[i]) {
				count2++;
			}
		}
		count2 += offset;

		return Math.min(count1, count2);
	}
}