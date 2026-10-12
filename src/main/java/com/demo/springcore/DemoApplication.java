package com.demo.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    static {
        System.out.println("MAIN   " + "DemoApplication class loaded (static block)");
    }

    public static void main(String[] args) {
        System.out.println("MAIN   " + "main method started");
        ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        System.out.println("MAIN   " + "SpringApplication.run() returned | bean definitions: " + ctx.getBeanDefinitionCount());
        System.out.println("MAIN   " + "main method finished – app is running");
    }
}
