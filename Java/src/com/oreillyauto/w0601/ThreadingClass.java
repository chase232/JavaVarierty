package com.oreillyauto.w0601;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class ThreadingClass extends Thread {

    private File file;

    public ThreadingClass(File file) {
        this.file = file;
    }

    public void run() {
        try {
            // Declarations
            String path = file.getAbsolutePath().replace(".txt", ".sorted.txt");
            File outputfile = new File(path);
            PrintWriter fileOut = new PrintWriter(path);

            try {
                // Read the file
                StringBuilder sb = new StringBuilder();
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + ",");
                    }
                }                
                int[] array = Stream.of(sb.toString().split(",")).mapToInt(Integer::parseInt).toArray();
                FileUtils.writeStringToFile(outputfile, Arrays.toString(counterSort(array)));          
            }
            finally {
                try {
                    fileOut.close();
                }
                catch (Exception e) {/* do nothing*/ }
            }
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }

    public int[] counterSort(int[] array) {

        // setting sortedArray to have the same number of values as the passed array
        int[] sortedArray = new int[array.length];
        int aLength = array.length;

        // finding the smallest and largest number
/*        int minNum = array[0];
        int maxNum = array[0];
        for (int i = 1; i < aLength; i++) {
            if (array[i] < minNum) {
                minNum = array[i];
            } else if (array[i] > maxNum) {
                maxNum = array[i];
            }
        }*/

        // creating an array of the frequencies
        // array count is used to hold the number of frequencies
        int[] count = new int[9999];

        // for loop used to find the frequencies
        for (int i = 0; i < aLength; i++) {
            count[array[i] - 1] = count[array[i] - 1] + 1;
        }
        count[0] = count[0] - 1;

        // looping through count array 
        int cLength = count.length;
        for (int i = 1; i < cLength; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // Sorting the array
        for (int i = aLength - 1; i >= 0; i--) {
            sortedArray[count[array[i] - 1]--] = array[i];
        }
        return sortedArray;
    }
    
}