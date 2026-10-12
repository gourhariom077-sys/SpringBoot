package com.demo.springcore.di;

import com.demo.springcore.coupling.CarService;
import com.demo.springcore.init.EagerBean;
import com.demo.springcore.scope.SingletonBean;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiTypesDemo {

    private final CarService carService;
    @Autowired
    private EagerBean eagerBean;
    private SingletonBean singletonBean;

    public DiTypesDemo(CarService carService) {
        this.carService = carService;
        System.out.println("DI  " + "Constructor injection done | field injected yet? " + (eagerBean != null));
    }

    @Autowired
    public void setSingletonBean(SingletonBean singletonBean) {
        this.singletonBean = singletonBean;
        System.out.println("DI  " + "Setter injection done | field injected yet? " + (eagerBean != null));
    }

    @PostConstruct
    void allInjected() {
        System.out.println("DI   " + "@PostConstruct -> all 3 dependencies ready");
    }
}
