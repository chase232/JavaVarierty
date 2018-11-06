package com.oreillyauto.w0601;

import java.io.File;

public class FastSort {

    File file1 = new File("file1.txt");
    File file2 = new File("file2.txt");
    File file3 = new File("file3.txt");
    File sorted1 = new File("file1.sorted.txt");
    File sorted2 = new File("file2.sorted.txt");
    File sorted3 = new File("file3.sorted.txt");
    
    public FastSort() {
        try {
            System.out.println("Process started.");
            cleanup(new File[]{sorted1, sorted2, sorted3});
            long start = System.currentTimeMillis();
            processFiles();
            long end = System.currentTimeMillis();
            System.out.println("Process Time: " + (end - start) + " milliseconds");
            System.out.println("Done.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Done (with error).");
        }
    }

    private void cleanup(File[] fileArray) {
        for (File file : fileArray) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private void processFiles() throws Exception {
        
        Thread thread1 = new ThreadingClass(file1);
        thread1.start();
        thread1.join();
        
        Thread thread2 = new ThreadingClass(file2);
        thread2.start();
        thread2.join();
        
        Thread thread3 = new ThreadingClass(file3);
        thread3.start();
        thread3.join();
        
        
    } 
    
    public static void main(String[] args) {
        new FastSort();
    }
}

