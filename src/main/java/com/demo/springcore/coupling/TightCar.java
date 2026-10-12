package com.demo.springcore.coupling;

public class TightCar {
    private final PetrolEngineTight engine = new PetrolEngineTight();

    public String drive() {
        return engine.start();
    }
}