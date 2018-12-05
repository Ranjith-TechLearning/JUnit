package com.learning.junit;

public class Calculator {

    public String display(String name){
        return name;
    }

    public void throwException(){
        throw new ArrayIndexOutOfBoundsException("I am Exception");
    }


}
