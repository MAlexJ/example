package task_Collection;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Alex on 04.02.2015.
 */
public class App_01_List {
    private final static Logger LOG = Logger.getLogger(App_01_List.class);

    public static void main(String[] args) {
        LOG.debug("main");
        List<String> list = new ArrayList<>();
        LOG.debug("list.size() ->" + list.size());
        LOG.debug("list.isEmpty() ->" + list.isEmpty());

        // list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");

        // list.add(0, "first_1"); ----> insert
        list.add(0, "first_1");
        list.add(0, "first_2");

        LOG.debug("list.contains(\"x\") ->" + list.contains("x"));
        LOG.debug("list.contains(\"a\") ->" + list.contains("a"));
        LOG.debug("list.get(3) -> " + list.get(3));

        LOG.debug(list);

        //remove for index
        LOG.debug("list.remove(3) -> " + list.remove(3));

        //remove for Object
        LOG.debug("list.remove(\"a\") ->" + list.remove("a"));

        LOG.debug(list);

    }

}
