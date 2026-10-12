package com.demo.springcore.coupling;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.engine", havingValue = "electric")
public class ElectricEngine implements Engine {

    public ElectricEngine() {

        System.out.println("IOC  " + "Spring created ElectricEngine ");
    }

    public String start() {
        return "Electric engine started (LOOSE – injected by Spring)";
    }
}
