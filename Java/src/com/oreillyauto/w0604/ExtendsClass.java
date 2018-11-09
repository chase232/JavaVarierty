package com.oreillyauto.w0604;

public class ExtendsClass extends AbstractClass{

    private int three;
    private int four;
    
    public ExtendsClass(int three, int four) {
        this.three = three;
        this.four = four;
    }
    public ExtendsClass(int one, int two, int three, int four) {
        super(one, two);
        this.three = three;
        this.four = four;
    }
    
    public int getThree() {
        return three;
    }
    
    public int getFour() {
        return four;
    }
    
    public void setThree(int three) {
        this.three = three;
    }
    
    public void setFour(int four) {
        this.four = four;
    }
}
