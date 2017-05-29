package fake_closure;

/**
 * 1.使用只包含一个抽象方法的接口，模仿<b>"函数类型(function type)"</b> <br/>
 * 2.使用其包含私有属性的实现类，模仿<b>"闭包(closure)"</b>
 * @author xshrimp
 * 2017年2月17日
 */
public interface Func<A, B> {
   abstract B m(A a);
}
