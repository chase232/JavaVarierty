/**
 * This class is used to test all of the following other classes 
 *      to practice for the milestone 
 * */

package com.oreillyauto.w0604;

public class DriverClass {

    public DriverClass() {
        
        /*
         * This is used to test an abstract class implementation 
        ExtendsClass ec = new ExtendsClass(3, 4);        
        ec.myAbstractMethod("foo");
        */
        
        /*
         * This is used to test interfaces and geometry      
        Geometry square = new Geometry();
        Geometry triangle = new Geometry();
        System.out.println("The area of the square is " + square.area(10));
        System.out.println("The area of the triangle is " + triangle.area(10, 10));
        */ 
        
        /*
         * This section is used to create two lists and merge them together
        List<Integer> firstList = new ArrayList<Integer>();
        List<Integer> secondList = new ArrayList<Integer>();
        List<Integer> mergedList = new ArrayList<Integer>();
        
        for(int i = 0; i < 10; i++) {
            firstList.add(i);
        }
        
        for(int i = 10; i < 20; i++) {
            secondList.add(i);
        }
        
        for (Integer integer : firstList) {
            mergedList.add(integer);
        }
        
        for (Integer integer : secondList) {
            mergedList.add(integer);
        }
        System.out.println("MergedList = " + mergedList.toString());
        */
            
        String[] stringArray = {"1", "2", "3"};
        int [] intArray = new int[3];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i]= Integer.parseInt(stringArray[i]);
            System.out.println(intArray[i]);
        }
        
    }
    
    public static void main(String[] args) {
        new DriverClass();
    }
}














