package com.demo.springcore.runner;

import com.demo.springcore.coupling.CarService;
import com.demo.springcore.coupling.TightCar;
import com.demo.springcore.scope.PrototypeBean;
import com.demo.springcore.scope.ScopeHolder;
import com.demo.springcore.scope.SingletonBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final CarService carService;
    private final ScopeHolder scopeHolder;
    private final ApplicationContext ctx;

    public StartupRunner(CarService carService, ScopeHolder scopeHolder, ApplicationContext ctx) {
        this.carService = carService;
        this.scopeHolder = scopeHolder;
        this.ctx = ctx;
    }

    @Override
    public void run(String... args) {
        System.out.println("RUNNER   " + "CommandLineRunner.run() – all beans ready, app almost up");

        System.out.println("COUPLING   " + new TightCar().drive());
        System.out.println("COUPLING   " + carService.drive());

        SingletonBean s1 = ctx.getBean(SingletonBean.class);
        SingletonBean s2 = ctx.getBean(SingletonBean.class);
        System.out.println("SCOPE   " + "Singleton: same object? " + (s1 == s2));

        PrototypeBean p1 = ctx.getBean(PrototypeBean.class);
        PrototypeBean p2 = ctx.getBean(PrototypeBean.class);
        System.out.println("SCOPE   " + "Prototype: same object? " + (p1 == p2));

        System.out.println("SCOPE   " + scopeHolder.compare());
        System.out.println("SCOPE   " + scopeHolder.compare());
    }
}