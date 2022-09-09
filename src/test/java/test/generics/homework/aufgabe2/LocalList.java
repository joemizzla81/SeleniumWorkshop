/*
package test.generics.homework.aufgabe2;

import java.util.ArrayList;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;
import static java.util.Collections.EMPTY_LIST;


public class LocalList<A> {

    private final A[] speicher;

    public LocalList(A[] speicher) {
        this.speicher = speicher;
    }

    ArrayList<A> LocalList = new ArrayList<A>();

    public java.util.List LocalList(){

        return EMPTY_LIST;

    }

    public int size() {
        return length();
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean contains(Object o) {
        LocalList<A> l = this;
        while (l.tail != null) {
            if (x == null) {
                if (l.head == null) return true;
            } else {
                if (l.head.equals(x)) return true;
            }
            l = l.tail;
        }
        return false;
    }

    public boolean add(A a) {
        if(a != null){
            LocalList.add(a);
            return true;
        }else
            return false;
    }

    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        }
        return true;
    }




}
*/
