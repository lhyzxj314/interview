package design_pattern.my_spring;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class ResourceLoader {

    public static Map<String, BeanDefinition> getResource() {
        Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();
        Properties properties = new Properties();
        try {
            InputStream is = ResourceLoader.class.getResourceAsStream("./bean.properties");
            properties.load(is);
            Iterator<String> it =  properties.stringPropertyNames().iterator();
            while (it.hasNext()) {
                String key = it.next();
                String className = properties.getProperty(key);
                BeanDefinition bd = new BeanDefinition();
                bd.setBeanName(key);
                bd.setBeanClass(Class.forName(className));
                beanDefinitionMap.put(key, bd);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beanDefinitionMap;
    }


}
