package com.oreillyauto.w0504;

import java.util.Comparator;

public class CallNumberComparator implements Comparator<LibraryBook>{

    public CallNumberComparator() {
        
    }
    
    public int compare(LibraryBook one, LibraryBook two) {
        
        int book1 = Integer.parseInt(one.getCallNumber());
        int book2 = Integer.parseInt(two.getCallNumber());
        
        if (book1 == book2)
            return 0;
        else if (book1 > book2)
            return 1;
        else
            return -1;
    }
}
