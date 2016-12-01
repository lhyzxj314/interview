package thinking_in_java.try_catch;

public class ExceptionSilencer {
	public static void main(String[] args) {
		try {
			// 由于finally的作用，此异常被丢失了
			throw new RuntimeException();       
		} finally {
			System.out.println(1);
			return;
		}
	}
}
