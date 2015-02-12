package task_Collections;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Alex on 12.02.2015.
 */
public class App_10_List_HashSet {
    private final static Logger LOG = Logger.getLogger(App_10_List_HashSet.class);

    public static void main(String[] args) {

        // Constructor ->  public ArrayList(Collection<? extends E> c){}
        List<String> list = new ArrayList<>(asList("A", "BB", "A"));
        LOG.debug(list);

        // To make unique items in list
        // Constructor ->  public HashSet(Collection<? extends E> c) {}
        LOG.debug(new HashSet<>(list));


    }

}
