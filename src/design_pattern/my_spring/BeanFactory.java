package design_pattern.my_spring;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();
    private BeanRegister beanRegister;

    public BeanFactory() {
        this.beanRegister = new BeanRegister();
        this.beanDefinitionMap = ResourceLoader.getResource();
    }

    private Object createBean(BeanDefinition bd) {
        try {
            Object bean = bd.getBeanClass().newInstance();
            beanRegister.registerSingletonBean(bd.getBeanName(), bean);
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getBean(String beanName) {
        Object bean = beanRegister.getSingletonBean(beanName);
        if (bean != null) {
            return bean;
        }
        bean = createBean(beanDefinitionMap.get(beanName));
        return bean;
    }

}
