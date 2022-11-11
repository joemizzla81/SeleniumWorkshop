package iterables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterablesBasics {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(23);
        intList.add(23);
        intList.add(2333);
        intList.add(123);
        intList.add(9923);
        Iterator<Integer> iterator = intList.iterator();
        Iterator<Integer> iterator2 = intList.iterator();

        while (iterator.hasNext()){
            System.out.println("Next element: " + iterator.next());
        }

        while (iterator2.hasNext()){
            System.out.println("Next element: " + iterator2.next());
        }
    }


}
