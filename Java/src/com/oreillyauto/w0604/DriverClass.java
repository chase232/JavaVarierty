/**
 * This class is used to test all of the following other classes 
 *      to practice for the milestone 
 * */

package com.oreillyauto.w0604;

import java.util.HashMap;
import java.util.Map;

public class DriverClass {

    public DriverClass() {
        
       
        //This is used to test an abstract class implementation 
        ExtendsClass ec = new ExtendsClass(3, 4);        
        ec.myAbstractMethod("foo");
        ec.myAbstractMethod("Hello");
        
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
            
/*        String[] stringArray = {"1", "2", "3"};
        int [] intArray = new int[3];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i]= Integer.parseInt(stringArray[i]);
            System.out.println(intArray[i]);
        }*/
        
        // String to numbers
/*        String marvel = "Marvel Rocks";
        char[] ch  = marvel.toCharArray();
        for (char c : ch) {
            if (c == ' ') {
                System.out.print("#");
            }
            int temp = (int) c;
            if (temp <= 122 && temp >= 97) {
                System.out.print(temp - 96 + ".");
            } else if (temp<=90 && temp>=65){
                System.out.print(temp-64 + ".");
            }
        } */   
        
        // Map example
        int[] intArray = {1, 2, 3, 4};
        String[] stringArray = {"1", "2", "3", "4"};
        Map<Integer, String> myMap = new HashMap<>();
        int j = 0;
        int k = 1;
        for(int i = 0; i < intArray.length; i++) {
            myMap.put(i + 1, stringArray[i]);
        }
        System.out.println(myMap.toString());
        
    }
    
    public static void main(String[] args) {
        new DriverClass();
    }
}














