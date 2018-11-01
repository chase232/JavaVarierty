package com.oreillyauto.w0504;

import java.io.Serializable;

public abstract class LibraryBook extends Book implements Comparable<LibraryBook>, Serializable{

    private static final long serialVersionUID = 1377536755410232506L;
    
    private String callNumber;
    
    public LibraryBook() {
        
    }
    public LibraryBook(String callNumber) {
        this.callNumber =  callNumber;
    }
    
    public LibraryBook(String author, String title, String Isbn, String callNumber) {
        super(author, title, Isbn);
        this.callNumber =  callNumber;
    }
    public String getCallNumber() {
        return callNumber;
    }
    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }
    
    // Methods
    public void addBook(LibraryBook book) {
        
    }
    
    public void checkout(String patron, String duedate, String callNum) {
        
    }
    
    public void returned(String callNum) {
        
    }
    
    public void sortLibrary() {
        //sort books in the library by call number
    }
    
    public LibraryBook findBook(LibraryBook book) {
        return null;
    }
}











