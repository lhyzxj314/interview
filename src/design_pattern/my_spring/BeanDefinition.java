package design_pattern.my_spring;

public class BeanDefinition {
    private String beanName;

    private Class beanClass;

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return this.beanClass;
    }
}
