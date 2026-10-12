package com.demo.springcore.coupling;

import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final Engine engine;

    public CarService(Engine engine) {
        this.engine = engine;
        System.out.println("DI  " + "CarService got engine = " + engine.getClass().getSimpleName());
    }

    public String drive() {
        return engine.start();
    }
}