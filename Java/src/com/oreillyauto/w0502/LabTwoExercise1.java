/*
 * Program:     LabTwoExercise1
 * Developer:   Chase Dickerson
 * Date:        10/30/2018
 * Purpose:     Complete functions given
 */

package com.oreillyauto.w0502;

import java.awt.Point;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class LabTwoExercise1 {

    public LabTwoExercise1() {
        System.out.println("Largest int: " + greatest(new int[] { 1, 2, 3, 4, 5 }));

        System.out.println("Calculating 5.0 plus 2.0: " + calculator(5.0, "+", 2.0));

        System.out.print("Counting to 'n' (5): " + countTo(5));
        System.out.println("");

        System.out.println("Checking if 101 is even: " + isEven(101));

        System.out.println("Replacing all n's with t's in the word banana: " + 
                                                   replaceCharacters("banana", 'n', 't'));
        
        System.out.println("37 Degrees Fahrenheit to Celsius: " +fahrenheitToCelcius(new BigDecimal(37)));
        
        System.out.println("1000 inches to meters: " + inchesToMeters(1000));
        
        System.out.println("Sum of digits (12345): " + sumOfDigits(12345));
        
        System.out.println("\nChess Board:\n" + generateFirstRow() + buildChessBoard());
    }

    /**
     * Using Objects and loops/iterations, build a chessboard in the console that looks like the one below.
     * I have created a ChessPiece class if you want to use that to get you started. Do not simply print the
     * chessboard to the console manually.
     * @return
     */
    //    0  1  2  3  4  5  6  7
    // 0 BR BN BB BK BQ BB BN BR 
    // 1 BP BP BP BP BP BP BP BP 
    // 2 -- -- -- -- -- -- -- -- 
    // 3 -- -- -- -- -- -- -- -- 
    // 4 -- -- -- -- -- -- -- -- 
    // 5 -- -- -- -- -- -- -- -- 
    // 6 WP WP WP WP WP WP WP WP 
    // 7 WR WN WB WK WQ WB WN WR
    private String buildChessBoard() {
        StringBuilder sb = new StringBuilder();
        
        // Creating a map and adding to it
        Map<Point, ChessPiece> chessMap = new HashMap<Point, ChessPiece>();
        chessMap.put(new Point(0,0), new ChessPiece(ChessPiece.TYPE_ROOK, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(0,1), new ChessPiece(ChessPiece.TYPE_KNIGHT, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(0,2), new ChessPiece(ChessPiece.TYPE_BISHOP, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(0,3), new ChessPiece(ChessPiece.TYPE_KING, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(0,4), new ChessPiece(ChessPiece.TYPE_QUEEN, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(0,5), new ChessPiece(ChessPiece.TYPE_BISHOP, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(0,6), new ChessPiece(ChessPiece.TYPE_KNIGHT, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(0,7), new ChessPiece(ChessPiece.TYPE_ROOK, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(1,0), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(1,1), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(1,2), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(1,3), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(1,4), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(1,5), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(1,6), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_BLACK));
        chessMap.put(new Point(1,7), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_BLACK));
        
        chessMap.put(new Point(7,0), new ChessPiece(ChessPiece.TYPE_ROOK, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(7,1), new ChessPiece(ChessPiece.TYPE_KNIGHT, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(7,2), new ChessPiece(ChessPiece.TYPE_BISHOP, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(7,3), new ChessPiece(ChessPiece.TYPE_KING, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(7,4), new ChessPiece(ChessPiece.TYPE_QUEEN, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(7,5), new ChessPiece(ChessPiece.TYPE_BISHOP, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(7,6), new ChessPiece(ChessPiece.TYPE_KNIGHT, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(7,7), new ChessPiece(ChessPiece.TYPE_ROOK, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(6,0), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(6,1), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(6,2), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(6,3), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(6,4), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(6,5), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(6,6), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_WHITE));
        chessMap.put(new Point(6,7), new ChessPiece(ChessPiece.TYPE_PAWN, ChessPiece.COLOR_WHITE));
        
        // Creates the chess board using a nested loop
        for(int k = 0; k < 8; k++) { 
            sb.append("\n");
            sb.append(k + " ");
            for(int i = 0; i < 8; i++) {
                ChessPiece piece = chessMap.get(new Point(k, i));
                if (piece != null) {
                    sb.append(" " + piece);
                } else {
                    sb.append(" --");
                }
            }
        }
        return sb.toString();
    }
    
    // This is used to generate the first row for the chess board
    private String generateFirstRow() {
        StringBuilder sb = new StringBuilder();
        
        // Used to create the first row of numbers
        for (int i = -1; i < 8; i++) {
            if (i == -1) {
                sb.append("    ");
            } else {
                sb.append(i + "  ");
            } 
        }
        
        return sb.toString();
    }

    /**
     * sumOfDigits
     * @param i
     * @return
     */
    private int sumOfDigits(int i) {
        int sumOfDigits = 0;
        
        char[] chars = ("" + i).toCharArray();
        
        for(int j = 0; j < chars.length; j++) {
           
            sumOfDigits = sumOfDigits + Character.getNumericValue(chars[j]);
        }
        
        return sumOfDigits;
    }

    /**
     * inchesToMeters
     * @param i
     * @return
     */
    private BigDecimal inchesToMeters(int inches) {
        
        double inchesConversion = (inches * 0.0254);
        MathContext m = new MathContext(4);
        BigDecimal meters = new BigDecimal("0");
        BigDecimal conversion = new BigDecimal(inchesConversion);
        
        meters = meters.add(conversion).round(m);
        return meters;
    }

    /**
     * fahrenheitToCelcius
     * Write a Java program to convert temperature from Fahrenheit to Celsius
     * 212.0 degree Fahrenheit is equal to 100.0 in Celsius
     * @param fahrenheit
     * @return
     */
    private String fahrenheitToCelcius(BigDecimal fahrenheit) {
        String celsius = "";
        BigDecimal newValue = new BigDecimal(0);
        MathContext m = new MathContext(4);
        BigDecimal divisor = new BigDecimal(.556);
        BigDecimal subtract = new BigDecimal(32);
        newValue = fahrenheit.subtract(subtract).multiply(divisor).round(m);
        celsius = newValue.toString();
        return celsius;
    }

    /**
     * greatest
     * @param ints
     * @return
     */
    public static int greatest(int[] ints) {
        
        int a  = ints[0];
        for(int i = 0; i < ints.length; i++) {
            if (a < ints[i]) {
                int temp = ints[i];
                a = temp;
            }
        }
        return a;
    }
    
    /**
     * calculator
     * @param x
     * @param operator
     * @param y
     * @return
     */
    public static double calculator(double x, String operator, double y) {
        
        double value = 0;
        switch (operator) {
            
            case "+":
                value = x + y;
                break;
            case "-":
                value = x - y;
                break;
            case "*":
                value = x * y;
                break;
            case "/":
                value = x * y;
                break;
            default:
                break;
                
        }
        return value;
    }
    
    /**
     * countTo
     * Count to "n" without any new line characters. 
     * Append your iterations to the StringBuilder Object
     * Make sure there is a space after each number
     * @param n
     * @return
     */
    public static String countTo(int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= n; i++) {
            sb.append(i);
        }
        return sb.toString();
    }
    
    /**
     * isEven
     * @param i
     * @return
     */
    private String isEven(int i) {
        
        if ((i % 2) == 0) {
            return "Even";
        } else {
            return "Odd";
        }
        
    }
    
    /**
     * replaceCharacters
     * @param str
     * @param old
     * @param newChr
     * @return
     */
    public static String replaceCharacters(String str, char old, char newChr) {
        
        String newString = str.replace(old, newChr);
        
        return newString;
    }

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        new LabTwoExercise1();
    }   
}

