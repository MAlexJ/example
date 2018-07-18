package com.malex.lecture_13_collection.task_Collection;

import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex on 04.02.2015.
 */
public class App_02_Set {
    private final static Logger LOG = Logger.getLogger(App_02_Set.class);

    public static void main(String[] args) {
        LOG.debug("main");
        Set<String> listSet = new HashSet<>();

        // Error run time ->
        //listSet.add(2);

        listSet.add("a");
        listSet.add("b");
        listSet.add("c");

        // remove() for Object.
        // this arg: 2 -> auto box int to Integer.
        listSet.remove(2);




        LOG.debug(listSet);

    }
}
