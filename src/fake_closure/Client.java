package fake_closure;

/**
 * 测试Java仿闭包
 * @author xshrimp
 * 2017年2月17日
 */
public class Client {
  static List<String> intToString(List<Integer> intList) {
    List<String> newList = intList.map(new Func<Integer, String>() {
      
      //TODO 此处可增加私有属性，模仿变量绑定的效果(variable binding)
      
      @Override
      public String m(Integer a) {
        return Integer.toHexString(a);
      }
      
    });
    return newList;
  }

  public static void main(String[] args) {
    List<Integer> oldList = new List<Integer>(1, new List<Integer>(2, new List<Integer>(3, null)));
    List<String> newList = intToString(oldList);
    System.out.println(oldList);
    System.out.println(newList);
  }
}
