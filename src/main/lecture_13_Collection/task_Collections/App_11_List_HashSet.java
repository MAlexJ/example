package task_Collections;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Alex on 12.02.2015.
 */
public class App_11_List_HashSet {
    private final static Logger LOG = Logger.getLogger(App_11_List_HashSet.class);

    public static void main(String[] args) {
        // Constructor ->  public ArrayList(Collection<? extends E> c){}
        List<String> list = new ArrayList<>(asList("D","A", "BB", "A","C"));
        LOG.debug(list);

        // Constructor ->  public ArrayList(Collection<? extends E> c){}
        List<String> list2 = new ArrayList<>(new HashSet<>(list));
        // This class consists exclusively of static methods that operate on or return collections.
        // void sort(List<T> list){}
        // Sorts the specified list into ascending order, according to the Comparable natural ordering of its elements.
        Collections.sort(list2);
        LOG.debug(list2);
    }
}
