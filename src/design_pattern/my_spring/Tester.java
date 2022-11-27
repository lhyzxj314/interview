package design_pattern.my_spring;

import java.util.Map;

public class Tester {
    public static void main(String[] args) {
        BeanFactory factory = new BeanFactory();
        UserDao uDao1 = (UserDao) factory.getBean("userDao");
        uDao1.queryUserInfo();

        UserDao uDao2 = (UserDao) factory.getBean("userDao");
        uDao2.queryUserInfo();
    }
}
