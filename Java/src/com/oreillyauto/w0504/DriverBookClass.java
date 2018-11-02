package com.oreillyauto.w0504;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DriverBookClass {

    public DriverBookClass() {
        
        LinkedList<LibraryBook> myBookList = new LinkedList<>();
        
        System.out.println("Printing Library");
        myBookList.add(new ReferenceBook("James", "Scary Book", "1234AEG", "94", "Collection"));
        myBookList.add(new ReferenceBook("Sameson", "Tall Tales", "4568GYW", "28", "Collection"));
        myBookList.add(new ReferenceBook("Harrison", "Wise Tales", "7488XIK", "189", "Collection"));
        myBookList.add(new CirculatingBook("Rowling", "Harry Potter", "8541UHT", "7"));
        myBookList.add(new CirculatingBook("Johnson", "Ocho Cinco", "9856OCH", "87"));
        
        for (Book book : myBookList) {
            System.out.println(book.toString());
        }
        
        System.out.println("\nSorted by title");
        Collections.sort(myBookList, new TitleComparator());
        for (Book book : myBookList) {
            System.out.println(book.toString());
        }
        
        System.out.println("\nSorted by Call Number");
        Collections.sort(myBookList, new CallNumberComparator());
        for (Book book : myBookList) {
            System.out.println(book.toString());
        }
    }

    public static void main(String[] args) {
        new DriverBookClass();

    }

}
