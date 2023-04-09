package com.ratattack.game;

public class DataHolderClass {

    String someValue;

    public DataHolderClass()
    {

    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }

    public String getSomeValue() {
        return someValue;
    }

    public void PrintSomeValue()
    {
        System.out.println("from printSomeValue i DataHolderClass: "+ someValue);
    }
}
