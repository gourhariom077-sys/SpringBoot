package com.demo.springcore.init;

import org.springframework.stereotype.Component;

@Component
public class EagerBean {
    public EagerBean() {
        System.out.println("EAGER   " + "EagerBean created at startup");
    }
}