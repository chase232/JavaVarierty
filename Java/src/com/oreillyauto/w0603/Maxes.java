// Program:     Maxes
// Developer:   Chase Dickerson
// Date:        11/12/2018


package com.oreillyauto.w0603;

import java.util.Arrays;

public class Maxes {

    public Maxes() {
        // Simple Queries problem
        testSimpleQueries();
    }

    private void testSimpleQueries() {
        int[] nums = getHugeArray();
        int[] maxes = getHugeArray();
        
        //int[] nums = {1, 2, 3};
        // int[] maxes = {2, 4};
        int[] result = counts(nums, maxes);
        //printArray(result); // dont do this with large sets!
    }

    private int[] counts(int[] nums, int[] maxes) {
        
        long start = System.currentTimeMillis();
        
        int[] elements = new int[maxes.length];
        
        //maxes = counterSort(maxes);
        //Arrays.sort(maxes);
        //Arrays.sort(nums);
        nums = counterSort(nums);
        
        for(int i = 0; i < elements.length; i++) {
            
            int value = search(nums, maxes[i]);
            if (value == -1) {
                continue;
            }else {
                elements[i] = value;
            } 
        }
        
        long stop = System.currentTimeMillis();
        long time = (stop - start);
        System.out.println("Time: " + time + " milliseconds.");
        
        if (time <= 30) {
            System.out.println("You are a genius!");
        } else if (time > 30 && time < 50) {
            System.out.println("1st Place! You are a super star!");
        } else if (time >= 50 && time < 100) {
            System.out.println("2st Place! Great!");
        } else if (time >= 100 && time < 150) {
            System.out.println("3rd Place! Good!");
        } else {
            System.out.println("Seriously? " + time + " milliseconds? ZZZzzzz");
        }
        
        return elements;
    }
    
    private void printArray(int[] result) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for (int i = 0; i < result.length; i++) {
            if (sb.toString().length() > 1) {
                sb.append(",");
            }

            sb.append(result[i]);
        }
        
        sb.append("]");
        System.out.println(sb.toString());
    }
    
    public int[] getHugeArray() {
        int[] array = new int[100000];
        
        for (int i = 0; i < 100000; i++) {
            array[i] = (int) (Math.random()*100)+1;
        }
        
        return array;
    }
    
    public static void main(String[] args) {
        new Maxes();
    }
    
    // This method Finds the index of the largest value in the sorted array
        // and returns the index
    public int search(int array[], int num) { 
        
        int index = Arrays.binarySearch(array, num);
        
        // USED if num is not in array[]
        while(index < 0) {
            
            if(array[array.length - 1] <= num) {
                return array.length;
            } else {
                num = num - 1;
                index = Arrays.binarySearch(array, num);
            }
        }
        
        for(int i = index; i < array.length; i++) {
            if(array[i] == array[num]) {
                continue;
            }else {
                return i + 1;
            }
        }
        return -1;
        
        
        // First method used but very slow
/*        for(int i = array.length - 1; i > 0; i--) {
            if(array[i] <= num) {
                return i + 1;
            }
        }
        return -1;*/
        
        
    } 
    
    public int[] counterSort(int[] array) {

        // setting sortedArray to have the same number of values as the passed array
        int[] sortedArray = new int[array.length];
        int aLength = array.length;

        // finding the smallest and largest number
        int minNum = array[0];
        int maxNum = array[0];
        for (int i = 1; i < aLength; i++) {
            if (array[i] < minNum) {
                minNum = array[i];
            } else if (array[i] > maxNum) {
                maxNum = array[i];
            }
        }

        // creating an array of the frequencies
        // array count is used to hold the number of frequencies
        int[] count = new int[maxNum - minNum + 1];

        // for loop used to find the frequencies
        for (int i = 0; i < aLength; i++) {
            count[array[i] - minNum] = count[array[i] - minNum] + 1;
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

