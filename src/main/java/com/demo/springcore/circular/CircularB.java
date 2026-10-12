package com.demo.springcore.circular;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("circular")
public class CircularB {
    public CircularB(CircularA a) {
        System.out.println("CIRCULAR  " + "CircularB created");
    }
}
