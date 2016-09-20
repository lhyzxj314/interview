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
		/* ������ȣ�����ͬ���ַ������滻���� */
		if (str1.length == str2.length) {
			for (int i = 0; i < str1.length; i++) {
				if (str1[i] != str2[i]) {
					count++;
				}
			}
			return count;
		}

		/* ���Ȳ���  */
		// 1.�ҳ�������
		if (str1.length > str2.length) {
			char[] tmp = str1;
			str1 = str2;
			str2 = tmp;
		}
		int offset = Math.abs(str1.length - str2.length); // 2���ַ������Ȳ�
		str1 = Arrays.copyOf(str1, str2.length);		  // �����ַ����飬ʹ2������ȳ�

		// 2.���ԶԶ̵�����Ӻ��滻
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

		// 3.���ԶԶ̵����滻�����
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