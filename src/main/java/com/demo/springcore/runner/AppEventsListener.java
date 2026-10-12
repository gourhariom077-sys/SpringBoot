package com.demo.springcore.runner;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppEventsListener {

    @EventListener(ContextRefreshedEvent.class)
    public void refreshed() {
        System.out.println("EVENT   " + "ContextRefreshedEvent – all singleton beans created");
    }

    @EventListener(ApplicationStartedEvent.class)
    public void started() {
        System.out.println("EVENT   " + "ApplicationStartedEvent – runners will run next");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ready() {
        System.out.println("EVENT   " + "ApplicationReadyEvent – ready to serve requests");
    }

    @EventListener(ContextClosedEvent.class)
    public void closed() {
        System.out.println("EVENT   " + "ContextClosedEvent – shutdown begins");
    }
}
