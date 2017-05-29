package java_base;

public class StringIntern {
  public static void main(String[] args) {
    String str1 = new String("nihao");
    String str2 = new String("nihao");
    
    System.out.println(str1 == str2.intern());
    System.out.println(str1.intern() == str1);
    
    System.out.println(str2 == str2.intern());
    System.out.println(str1 == str2);
    System.out.println("abc" == str1.intern());
    System.out.println(str2.intern() == str1.intern());
  }
  
  /*public static void main(String[] args) {
    String str1 = new String("abc");
    String str2 = new String("abc");
    
    System.out.println(str1 == str2.intern());
    System.out.println(str1.intern() == str1);
    System.out.println(str2 == str2.intern());
    System.out.println(str1 == str2);
    System.out.println("abc" == str1.intern());
    System.out.println(str2.intern() == str1.intern());
  }*/
  
  /* char[] value = new char[] {'a', 'b', 'c'};
  String str1 = new String(value);
  String str2 = new String(value);*/
}
