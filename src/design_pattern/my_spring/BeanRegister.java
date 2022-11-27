package design_pattern.my_spring;

import java.util.HashMap;
import java.util.Map;

public class BeanRegister {
    private Map<String, Object> singletonMap = new HashMap<String, Object>();

    public void registerSingletonBean(String beanName, Object bean) {
        if (this.singletonMap.containsKey(beanName)) {
            return;
        }
        this.singletonMap.put(beanName, bean);
    }

    public Object getSingletonBean(String beanName) {
        return this.singletonMap.get(beanName);
    }
}
