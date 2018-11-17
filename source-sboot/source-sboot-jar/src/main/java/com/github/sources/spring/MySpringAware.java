package com.github.sources.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
@Configuration
public class MySpringAware implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,BeanPostProcessor,InitializingBean,BeanFactoryPostProcessor {

    @Override
    public void setBeanName(String name) {
        System.out.println(name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        BeanFactory factory = beanFactory;

        System.out.println(factory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContext factory = applicationContext;
        System.out.println(factory);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    ExecutorService service = Executors.newFixedThreadPool(10);

    @Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        ConfigurableListableBeanFactory factory = beanFactory;
        String[] beanNamesArr = beanFactory.getBeanDefinitionNames();
        List<String> beanNames = Arrays.asList(beanNamesArr);
        boolean isContain = beanNames.contains("myAnnotationBean");

        for (final String beanName : beanNames) {
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
            if (!bd.isAbstract() && bd.isSingleton() && !bd.isLazyInit()) {
                if (beanFactory.isFactoryBean(beanName)) {
                    final FactoryBean<?> factory = (FactoryBean<?>) beanFactory.getBean(beanFactory.FACTORY_BEAN_PREFIX + beanName);
                    boolean isEagerInit;
                    if (System.getSecurityManager() != null && factory instanceof SmartFactoryBean) {
                        isEagerInit = AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
                            @Override
                            public Boolean run() {
                                return ((SmartFactoryBean<?>) factory).isEagerInit();
                            }
                        }, beanFactory.getAccessControlContext());
                    }
                    else {
                        isEagerInit = (factory instanceof SmartFactoryBean &&
                                ((SmartFactoryBean<?>) factory).isEagerInit());
                    }
                    if (isEagerInit) {
//                        beanFactory.getBean(beanName);
                        service.submit(new Runnable() {
                            @Override
                            public void run() {
                                beanFactory.getBean(beanName);
                            }
                        });
                    }
                }
                else {
//                    beanFactory.getBean(beanName);
                    service.submit(new Runnable() {
                        @Override
                        public void run() {
                            beanFactory.getBean(beanName);
                        }
                    });
                }
            }




        }

        System.out.println(beanFactory);
    }
}
