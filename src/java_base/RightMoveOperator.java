package java_base;

/**
 * Java右移操作符
 * @author xshrimp
 * 2017年5月29日
 */
public class RightMoveOperator {
  public static void main(String[] args) {
    int i = -4;
    System.out.println("--------i = " + i);
    System.out.println("移位前：" + Integer.toBinaryString(i));
    i >>= 1;  // 无符号右移,正数高位步0,负数高位补1
    System.out.println("i >>= 1");
    System.out.println("移位后：" + Integer.toBinaryString(i));
    System.out.println("--------i = " + i + "\n");
    
    i = -4;
    System.out.println("--------i = " + i);
    System.out.println("移位前：" + Integer.toBinaryString(i));
    i >>>= 1;  // 有符号右移,正数负数高位都补0
    System.out.println("i >>>= 1");
    System.out.println("移位后：" + Integer.toBinaryString(i)); 
    System.out.println("--------i = " + i + "\n");
    
    short j = -4;
    System.out.println("--------j = " + j);
    System.out.println("移位前：" + Integer.toBinaryString(j));
    j >>= 1;
    System.out.println("j >>= 1");
    System.out.println("移位后：" + Integer.toBinaryString(j)); 
    System.out.println("--------j = " + j + "\n");
    
    i = 5;
    System.out.println("--------i = " + i);
    System.out.println("移位前：" + Integer.toBinaryString(i));
    i >>= 32;  // 当n>=32时,有i >>= (n%32)
    System.out.println("i >>= 1");
    System.out.println("移位后：" + Integer.toBinaryString(i));
    System.out.println("--------i = " + i + "\n");
  }
}
