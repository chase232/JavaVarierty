/*
 * Program:     LabThreeExercise1
 * Developer:   Chase Dickerson
 * Date:        10/31/2018
 * Purpose:     Read in a file and add the sums
 */

package com.oreillyauto.w0503;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class LabThreeExercise1 {

    public static void main(String[] args) throws IOException {
        
        readFile();

    }
    
    private static void readFile() throws IOException{
        
        // Try clause used to read file
        try(BufferedReader br = new BufferedReader(new FileReader(new File("numbers.txt")))) {
            int sum = 0;
            String numbers;
            while((numbers = br.readLine()) != null) {
                
                // Splits up the file into just its contents
                String[] values = numbers.replaceAll("^\"", "").split("\"?(,|$)(?=(([^\"]*\"){2})*[^\"]*$) *\"?");
                for (String string : values) {
                    System.out.println(string);
                    sum += Integer.valueOf(string);
                }
            }
            
            System.out.println("The sum is: " + sum);
        }
    }

}
