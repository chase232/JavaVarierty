package com.oreillyauto.w0504;

import java.io.Serializable;

public class Book implements Serializable{

    private static final long serialVersionUID = 6575516399358728938L;
    
    private String author;
    private String title;
    private String Isbn;
    
    public Book() {
        
    }
    
    public Book(String author, String title, String Isbn) {
        this.author = author;
        this.title = title;
        this.Isbn = Isbn;
    }

    @Override
    public String toString() {
        return "Book:\t Author = " + author + ", Title = " + title + ", Isbn = " + Isbn + "";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

}
