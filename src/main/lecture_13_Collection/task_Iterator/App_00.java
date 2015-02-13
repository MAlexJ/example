package task_Iterator;

import org.apache.log4j.Logger;

import java.util.*;

import static java.util.Arrays.*;

/**
 * Created by Alex on 12.02.2015.
 */
public class App_00 {
    private final static Logger LOG = Logger.getLogger(App_00.class);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(asList("B", "A", "C", "F", "D"));

        for (int i = 0; i < list.size(); i++) {
            LOG.debug(list.get(i));
        }

        // ArrayList<> implements RandomAccess
        // interface RandomAccess -> Marker interface used by List implementations to indicate that they support fast (generally constant time) random access.
        /*
        * public static <T>
            int binarySearch(List<? extends Comparable<? super T>> list, T key) {
                if (list instanceof RandomAccess || list.size()<BINARYSEARCH_THRESHOLD)
                    return Collections.indexedBinarySearch(list, key);
                 else
                    return Collections.iteratorBinarySearch(list, key);
            }
        */

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }

}
