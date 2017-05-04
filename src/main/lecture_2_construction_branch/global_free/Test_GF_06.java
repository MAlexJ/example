package global_free;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author malex
 */
public class Test_GF_06 {

    /**
     * TreeSet produces sorted by default in natural order
     */
    public static void main(String[] args) {

        TreeSet map = new TreeSet();
        map.add("one");
        map.add("two");
        map.add("three");
        map.add("four");
        map.add("one");

        Iterator iterator = map.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        // OutPut: four one three two

    }

}
