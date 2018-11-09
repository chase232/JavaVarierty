package com.oreillyauto.w0604;

public class Geometry implements Triangle, Square{

    public double area(int base, int height) {
        return .5 * base * height;
    }
    
    public int area(int length) {
        return length * length;
    }
}
