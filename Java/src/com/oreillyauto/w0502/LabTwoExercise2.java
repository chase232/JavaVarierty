/* Un-comment this class. Correct all mistakes. */

package com.oreillyauto.w0502;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LabTwoExercise2 {

    List<Integer> intList = new ArrayList<>();
    
    public LabTwoExercise2() {
        System.out.println("Starting process..." +  "");
        populateList();
        iterateList();
        logStaticMessage("Message");
        logMessage("Process Complete.");
    }

    private void populateList() {
        
        for(int i = 0; i < 5; i++) {
            intList.add(i);
        }
    }

    private void iterateList() {
        for (Integer integer : intList) {
            System.out.println(integer);
        }
    }

    private static void logMessage(String message) {
        Date newDate = new Date();
        System.out.printf("%s " + (message + "\n"), newDate);
    }
    
    private static void logStaticMessage(String message) {
        Date newDate = new Date();
        System.out.printf("%s " + (message + "\n"), newDate);
    }
    
    public static void main(String[] args) {        
        new LabTwoExercise2();
        System.out.printf("Done", "%s");
    }
    
}


