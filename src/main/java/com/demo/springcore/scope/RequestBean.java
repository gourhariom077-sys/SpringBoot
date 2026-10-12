package com.demo.springcore.scope;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestBean {
    public RequestBean() {
        System.out.println("SCOPE   " + "RequestBean created for this HTTP request");
    }

    public String info() {
        return "RequestBean@" + Integer.toHexString(System.identityHashCode(this));
    }

    @PreDestroy
    void end() {
        System.out.println("DESTROY   " + "RequestBean destroyed – request finished");
    }
}
