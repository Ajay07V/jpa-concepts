package com.design.pattern;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public abstract class AbstractHandlerClass /*implements Handler*/ {
    protected Handler nextHandler;
    /*@Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
     }

    @Override
    public void handleProcess(String request) {
        if (nextHandler != null) {
            nextHandler.handleProcess(request);
        }
    }*/

    protected String sharedState;

    AbstractHandlerClass(String initialState) {
        this.sharedState = initialState;
    }
    public abstract void handleProcess();
}
