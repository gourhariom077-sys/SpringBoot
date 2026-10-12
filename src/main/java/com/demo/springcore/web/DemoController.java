package com.demo.springcore.web;

import com.demo.springcore.init.LazyBean;
import com.demo.springcore.scope.RequestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final LazyBean lazyBean;
    private final RequestBean requestBean;
    private final ApplicationContext ctx;

    public DemoController(@Lazy LazyBean lazyBean,
                          RequestBean requestBean,
                          ApplicationContext ctx) {
        this.lazyBean = lazyBean;
        this.requestBean = requestBean;
        this.ctx = ctx;
    }

    @GetMapping("/lazy")
    public String lazy() {
        return lazyBean.hello();
    }

    @GetMapping("/request-scope")
    public String requestScope() {
        return requestBean.info();
    }

    @GetMapping("/shutdown")
    public String shutdown() {
        new Thread(() -> {
            try { Thread.sleep(500); } catch (InterruptedException ignored) { }
            ((ConfigurableApplicationContext) ctx).close();
        }).start();
        return "Shutting down… check console for @PreDestroy order";
    }
}