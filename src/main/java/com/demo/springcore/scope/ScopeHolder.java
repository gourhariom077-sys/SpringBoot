package com.demo.springcore.scope;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
public class ScopeHolder {
    private final PrototypeBean injectedOnce;
    private final ObjectProvider<PrototypeBean> provider;

    public ScopeHolder(PrototypeBean injectedOnce, ObjectProvider<PrototypeBean> provider) {
        this.injectedOnce = injectedOnce;
        this.provider = provider;
    }

    public String compare() {
        return "Injected prototype: @" + injectedOnce.id() + " (same every call) | "
                + "Provider prototype: @" + provider.getObject().id() + " (new every call)";
    }
}
