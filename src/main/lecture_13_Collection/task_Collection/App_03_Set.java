package task_Collection;

import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Alex on 04.02.2015.
 */
public class App_03_Set {
    private final static Logger LOG = Logger.getLogger(App_03_Set.class);

    public static void main(String[] args) {
        LOG.debug("main");
        Set<String> listSet = new HashSet<>();
        LOG.debug("listSet.add(\"b\") -> " + listSet.add("b"));
        LOG.debug("listSet.add(\"e\") -> " + listSet.add("e"));
        LOG.debug("listSet.add(\"d\") -> " + listSet.add("d"));
        LOG.debug("listSet.add(\"c\") -> " + listSet.add("c"));
        LOG.debug("listSet.add(\"c\") -> " + listSet.add("c"));
        LOG.debug("listSet.add(\"c\") -> " + listSet.add("c"));
        LOG.debug("listSet.add(\"a\") -> " + listSet.add("a"));

        LOG.debug(listSet);

        Set<String> listSet1 = new TreeSet<>();
        LOG.debug("listSet.add(\"s\") -> " + listSet1.add("s"));
        LOG.debug("listSet.add(\"d\") -> " + listSet1.add("d"));
        LOG.debug("listSet.add(\"a\") -> " + listSet1.add("a"));
        LOG.debug("listSet.add(\"b\") -> " + listSet1.add("b"));
        LOG.debug("listSet.add(\"a\") -> " + listSet1.add("a"));
        LOG.debug("listSet.add(\"c\") -> " + listSet1.add("c"));
        LOG.debug("listSet.add(\"c\") -> " + listSet1.add("c"));

        LOG.debug(listSet1);


    }
}
