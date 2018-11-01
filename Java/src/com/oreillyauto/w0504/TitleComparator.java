package com.oreillyauto.w0504;

import java.util.Comparator;

public class TitleComparator implements Comparator<Object>{

    public TitleComparator() {
        
    }

    @Override
    public int compare(Object one, Object two) {
        
        Book book1 = (Book)one;
        Book book2 = (Book)two;
        
        return book1.getTitle().compareTo(book2.getTitle());
    }

}
