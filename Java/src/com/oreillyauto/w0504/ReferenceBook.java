package com.oreillyauto.w0504;

public class ReferenceBook extends LibraryBook implements Comparable<LibraryBook>{

    private String collection;
    
    // Constructors
    public ReferenceBook() {
        
    }
    
    public ReferenceBook(String collection) {
        this.collection = collection;
    }
    
    public ReferenceBook(String author, String title, String Isbn, String callNumber, String collection) {
        super(author, title, Isbn, callNumber);
        this.collection = collection;
    }
    
    // Getters and setters
    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }
    
    // compareTo
    @Override
    public int compareTo(LibraryBook book) {
        
        return 0;
    }
    
    // toString
    @Override
    public String toString() {
        return "ReferenceBook => Call Number: " + getCallNumber() + ", Author: " + getAuthor() + ", Title: " + getTitle()
                + ", ISBNL: " + getIsbn();
    }
    
    // Methods
    public void checkOut(String patron, String duedate) {
        System.out.println("Cannot check out a reference book");
    }


    public String circulationStatus() {
        return "";
    }

    public void returned() { 
        System.out.println("Feference book could not have been checked out -- return impossible");
    }
}





