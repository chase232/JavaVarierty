package com.oreillyauto.w0601;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

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
            FileOutputStream out = new FileOutputStream(outputfile);

            try {
                // Read the file
                //List<String> lineList = new ArrayList<String>();
                StringBuilder sb = new StringBuilder();

                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                }

                // Sort the Data
                String values = sb.toString();
                Collections.sort(Arrays.asList(values));

                // Create test data (remove this code)
                //List<String> data = new ArrayList<String>();
                
                //String sortedValues = String.join(sb);
                String sortedValues = sb.toString();
                
                System.out.println("Writing to path: " + path);
                //FileUtils.writeStringToFile(new File(path), sortedValues);
                //FileUtils.writeByteArrayToFile(outputfile, sortedValues.getBytes());
                FileUtils.writeStringToFile(new File(path), sortedValues);
                
                // Write to file
/*                for (String str : data) {
                    out.write(str.getBytes());
                }*/
            }
            finally {
                try {
                    fileOut.close();
                }
                catch (Exception e) {/* do nothing */}
            }
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}
