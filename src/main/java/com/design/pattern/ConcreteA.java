package com.design.pattern;

import org.springframework.stereotype.Component;

@Component
public class ConcreteA extends AbstractHandlerClass {
    Handler handler;

    public ConcreteA(String initialState) {
        super(initialState);
    }

    @Override
    public void handleProcess() {
        System.out.println("Its Concrete A class");
    }
}
