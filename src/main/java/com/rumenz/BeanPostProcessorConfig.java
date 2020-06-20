package com.rumenz;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class BeanPostProcessorConfig  implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Field[] arr=bean.getClass().getDeclaredFields();
        for(Field f:arr){
             Rumenz a=f.getAnnotation(Rumenz.class);
             if(null==a){
                 continue;
             }
            f.setAccessible(true);
            try {
                f.set(bean,a.value());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }


        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
