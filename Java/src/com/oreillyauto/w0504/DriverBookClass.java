package com.oreillyauto.w0504;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DriverBookClass {

    public DriverBookClass() {
        
        LinkedList<Book> myBookList = new LinkedList<>();
        myBookList.add(new Book("James", "Scary Book", "1234"));
        myBookList.add(new Book("Samson", "Tall Tales", "4568"));
        myBookList.add(new Book("Harrison", "Parry Hotter", "8633"));
        myBookList.add(new Book("Greg", "Good Story Bro", "0025"));
        myBookList.add(new Book("Lebron", "O'Reilly", "7777"));
        
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
