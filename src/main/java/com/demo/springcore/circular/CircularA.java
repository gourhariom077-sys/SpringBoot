package com.demo.springcore.circular;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("circular")
public class CircularA {
    public CircularA(CircularB b) {
        System.out.println("CIRCULAR  " + "CircularA created");
    }
}
