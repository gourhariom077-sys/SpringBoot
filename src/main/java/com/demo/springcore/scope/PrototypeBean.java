package com.demo.springcore.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {
    public PrototypeBean() {
        System.out.println("SCOPE   " + "PrototypeBean NEW object @" + id());
    }

    @PostConstruct
    void init() {
        System.out.println("SCOPE   " + "PrototypeBean @PostConstruct @" + id());
    }

    @PreDestroy
    void bye() {
        System.out.println("DESTROY   " + "PrototypeBean @PreDestroy ");
    }

    public String id() {
        return Integer.toHexString(System.identityHashCode(this));
    }
}
