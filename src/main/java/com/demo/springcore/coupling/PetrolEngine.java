package com.demo.springcore.coupling;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.engine", havingValue = "petrol", matchIfMissing = true)
public class PetrolEngine implements Engine {

    public PetrolEngine() {
        System.out.println("IOC   " + "Spring created PetrolEngine ");
    }

    public String start() {
        return "Petrol engine started (LOOSE – injected by Spring)";
    }
}
