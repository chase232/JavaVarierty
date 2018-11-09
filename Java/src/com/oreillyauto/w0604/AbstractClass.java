package com.oreillyauto.w0604;

public abstract class AbstractClass {
    
    private int one;
    private int two;
    
    public AbstractClass() {
        
    }
    
    public AbstractClass(int one, int two) {
        this.one = one;
        this.two = two;
    }

    
    public int getOne() {
        return one;
    }
    
    public int getTwo() {
        return two;
    }
    
    public void setOne(int one) {
        this.one = one;
    }
    
    public void setTwo(int two) {
        this.two = two;
    }
    
    public void myAbstractMethod(String foo) {
        System.out.println("Printed" + foo);
    }
}



