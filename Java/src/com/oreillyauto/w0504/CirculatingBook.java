package com.oreillyauto.w0504;

public class CirculatingBook extends LibraryBook implements Comparable<LibraryBook>{

    private String currentHolder;
    private String dueDate;
    
    public CirculatingBook() {
        
    }

    public CirculatingBook(String currentHolder, String dueDate) {
        this.currentHolder = currentHolder;
        this.dueDate = dueDate;
    }
    
    public CirculatingBook(String author, String title, String Isbn, String callNumber) {    
        super(author, title, Isbn, callNumber);
        currentHolder = null;
        dueDate = null;
    }
    
    
    public String getCurrentHolder() {
        return currentHolder;
    }

    public void setCurrentHolder(String currentHolder) {
        this.currentHolder = currentHolder;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public int compareTo(LibraryBook o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        return "CirculatingBook [getCallNumber()=" + getCallNumber() + ", getAuthor()=" + getAuthor() + ", getTitle()=" + getTitle()
                + ", getIsbn()=" + getIsbn() + "]";
    }

    public void checkout(String patron, String dueDate) {
        
    }
    
    public String circulationStatus() {
        return "";
    }


}




