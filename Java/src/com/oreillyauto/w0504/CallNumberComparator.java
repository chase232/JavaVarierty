package com.oreillyauto.w0504;

import java.util.Comparator;

public class CallNumberComparator implements Comparator<Object>{

    public CallNumberComparator() {
        
    }
    
    public int compare(Object one, Object two) {
        Book book1 = (Book)one;
        Book book2 = (Book)two;
        
        return book1.getIsbn().compareTo(book2.getIsbn());
    }
}
