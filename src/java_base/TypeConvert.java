package java_base;

public class TypeConvert {
	
	public static void main(String[] args) {
	  // 用final修饰后，不会做自动向上转换
	  final short s0 = 1;
	  short s1 = s0 + 1;
	  System.out.println(s1);
	  
	  // 隐私自动向上做类型转换，short -> int
		/*short s2 = 1;
		short s3 = s2 + 1;*/
	}
}
