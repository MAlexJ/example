import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

/**
 * Created by Alex on 04.02.2015.
 */
public class App_00_List {
    private final static Logger LOG = Logger.getLogger(App_00_List.class);

    public static void main(String[] args) {
        LOG.debug("main");
        Collection<String> list = new ArrayList<>();
        LOG.debug("list.size() ->" + list.size());
        LOG.debug("list.isEmpty() ->" + list.isEmpty());
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        LOG.debug("list.contains(\"x\") ->" + list.contains("x"));
        LOG.debug("list.contains(\"a\") ->" + list.contains("a"));


        LOG.debug(list);
    }
}
