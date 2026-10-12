package com.demo.springcore.lifecycle;

import com.demo.springcore.init.EagerBean;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LifecycleBean implements BeanNameAware, ApplicationContextAware,
        InitializingBean, DisposableBean {

    public LifecycleBean() {
        System.out.println("LIFECYCLE   " + "2) Constructor – object created");
    }

    @Autowired
    public void setDependency(EagerBean eagerBean) {
        System.out.println("LIFECYCLE   " + "3) Dependency injected (setter)");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("LIFECYCLE   " + "4) BeanNameAware -> my name is '" + name + "'");
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) {
        System.out.println("LIFECYCLE   " + "5) ApplicationContextAware -> got the container");
    }


    @PostConstruct
    public void postConstruct() {
        System.out.println("LIFECYCLE   " + "7) @PostConstruct");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("LIFECYCLE   " + "8) InitializingBean.afterPropertiesSet()");
    }

    public void customInit() {
        System.out.println("LIFECYCLE   " + "9) @Bean(initMethod) customInit()");
    }


    @PreDestroy
    public void preDestroy() {
        System.out.println("DESTROY   " + "D1) @PreDestroy");
    }

    @Override
    public void destroy() {
        System.out.println("DESTROY   " + "D2) DisposableBean.destroy()");
    }

    public void customDestroy() {
        System.out.println("DESTROY   " + "D3) @Bean(destroyMethod) customDestroy()");
    }
}