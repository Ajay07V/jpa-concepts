package com.design.pattern;

import org.springframework.stereotype.Component;

@Component
public class ConcreteB extends AbstractHandlerClass {
    Handler handler;

    public ConcreteB(String initialState) {
        super(initialState);
    }

    @Override
    public void handleProcess() {
        System.out.println("Its Concrete B class");
    }
}
