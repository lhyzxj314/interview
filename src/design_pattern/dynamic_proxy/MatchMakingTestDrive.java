package design_pattern.dynamic_proxy;

import java.lang.reflect.Proxy;

public class MatchMakingTestDrive {
	public static void main(String[] args) {
		drive();
	}
	
	// 测试方法 
	public static void drive() {
		PersonBean yjx = new PersonBeanImpl();
		yjx.setName("yjx");
		yjx.setGender("man");
		yjx.setInterests("CF");
		
		PersonBean ownerProxy = getOwnerProxy(yjx);
		ownerProxy.setInterests("LOL");
		System.out.println("Interests set from owner proxy");
		try {
			ownerProxy.setHotOrNotRating(10);
		} catch (Exception e) {
			System.out.println("Can't set rating from owner proxy");
		}
		
		PersonBean nonOwnerProxy = getNonOwnerProxy(yjx);
		try {
			nonOwnerProxy.setInterests("LOL");
		} catch (Exception e) {
			System.out.println("Can't set interets from non owner proxy");
		}
		nonOwnerProxy.setHotOrNotRating(5);
		System.out.println("Rating set from non owner proxy");
		System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
	}
	
	/**
	 * 创建动态代理类
	 * */
	public static PersonBean getOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(
				person.getClass().getClassLoader(), 
				person.getClass().getInterfaces(), 
				new OwnerInvocationHandler(person));
	}
	
	public static PersonBean getNonOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(
				person.getClass().getClassLoader(), 
				person.getClass().getInterfaces(), 
				new NonOwnerInvocationHandler(person));
	}
	
}
