package com.design.pattern;

public class TriggeredClass {
    public static void main(String[] args) {
        AbstractHandlerClass abstractHandlerClass= new ConcreteA("a intialstate");
        AbstractHandlerClass abstractHandlerClass1=new ConcreteB("b initialstate");
        abstractHandlerClass.handleProcess();
        abstractHandlerClass1.handleProcess();

        System.out.println("sharedState "+abstractHandlerClass.getSharedState());
        System.out.println("sharedState "+abstractHandlerClass1.getSharedState());
    }
}
