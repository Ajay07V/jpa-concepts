package com.design.pattern;

public interface Handler {
    void  setNextHandler(Handler handler);
    void handleProcess(String request);
}
