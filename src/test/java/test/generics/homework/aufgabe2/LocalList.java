
package test.generics.homework.aufgabe2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        int size = LocalList.size();
        return size();
    }

    public boolean isEmpty() {
    boolean ans = LocalList.isEmpty();
    if (ans == true){
        return true;
    }else
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
        if (!LocalList.contains(o)) {
            return false;
        }
        return true;
    }

    public boolean containsAll(LocalList<A> ll) {
        if (LocalList.containsAll(LocalList)){
            return true;
        }
            return false;
    }

    public boolean addAll(LocalList<A> ll){
       if (LocalList.addAll(LocalList)){
           return true;
       }
       return false;
    }

    public boolean addAll(int index, LocalList<A> ll){
        if (LocalList.addAll(index, LocalList)){
            return true;
        }
        return false;
    }

    public boolean removeAll(LocalList<A> ll){
       if (LocalList.removeAll(LocalList)) {
           return true;
       }
       return false;
    }

    public void clear(){
        LocalList.clear();
    }

    public A get(int index){
        A element = LocalList.get(index);
        return element;
    }

    public A remove(int index){
        A element = LocalList.get(index);
        LocalList.remove(index);
        return element;
    }

    public LocalList<A> subList(int a, int b){

        List<A> LocalList2 =  LocalList.subList(a,b);

        return (test.generics.homework.aufgabe2.LocalList<A>) LocalList2;
    }



}

