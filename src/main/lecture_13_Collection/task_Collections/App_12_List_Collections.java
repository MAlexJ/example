package task_Collections;

import org.apache.log4j.Logger;

import static java.util.Arrays.asList;

import java.util.List;

/**
 * Created by Alex on 12.02.2015.
 */
public class App_12_List_Collections {
    private final static Logger LOG = Logger.getLogger(App_12_List_Collections.class);

    public static void main(String[] args) {

        // asList("A","D","A","BB") -> Returns a fixed-size list backed by the specified array.
        // asList("A","D","A","BB") -> Returns not mutating  list
        List<String> list = asList("A", "D", "A", "BB");
        LOG.debug(list);

        // remove(0)  -> UnsupportedOperationException
        list.remove(0);
        LOG.debug(list);

    }
}
