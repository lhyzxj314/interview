package fake_closure;

class List<T> {
  T hd;
  List<T> tl;
  public List(T hd, List<T> tl) {
    this.hd = hd;
    this.tl = tl;
  }
  
  <B> List<B> map(Func<T, B> f) {
    List<B> res = map_helper(f, this);
    return res;
  }
  
  /**
   * 递归实现遍历，虽然使用Java运行效率稍低(无函数式编程语言的尾递归优化)，但是实现更简洁
   * @param f
   * @param list
   * @return
   */
  private <B> List<B> map_helper(Func<T, B> f, final List<T> list) {
    if (list == null) 
      return null;
    return new List<B>(f.m(list.hd), map_helper(f, list.tl));
  }
  
  @Override
  public String toString() {
    String hdString = hd == null ? "" : hd.toString() + " ";
    String tlString = tl == null ? "" : tl.toString() + " ";
   
    StringBuffer str = new StringBuffer(hdString);
    str.append(tlString);
    return str.toString();
  }
}
