package com.demo.springcore.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleConfig {

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public LifecycleBean lifecycleBean() {
        System.out.println("LIFECYCLE   " + "1) @Bean method lifecycleBean() called");
        return new LifecycleBean();
    }
}
