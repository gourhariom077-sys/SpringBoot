package com.demo.springcore.scope;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    public SingletonBean() {
        System.out.println("SCOPE   " + "SingletonBean created");
    }

    @PreDestroy
    void bye() {
        System.out.println("DESTROY   " + "SingletonBean @PreDestroy");
    }
}
