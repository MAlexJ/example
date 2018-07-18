package com.malex.lecture_13_collection.task_Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Created by Alex on 04.02.2015.
 *
 * STRUCTURE:
 *
 * interface Collection -----> interface List ----> class ArrayList
 *
 */
public class App_00_ArrayList {

    // logger
    private final static Logger LOG = Logger.getLogger(App_00_ArrayList.class);

    public static void main(String[] args) {
        // addition elements
        simpleAdditionOfElements();

        // add null
        addNullToArrayList();

        // crud operation
        crudOperations();
    }


    /**
     * Simple addition of elements into ArrayList
     */
    private static void simpleAdditionOfElements() {

        LOG.debug("************");
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


    /**
     * Simple CRUD operations over ArrayList
     */
    private static void crudOperations(){

        LOG.debug("************");
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


    /**
     * Add null
     */
    private static void addNullToArrayList() {
        ArrayList<String> list = new ArrayList<>();

        LOG.debug("***************");

        LOG.debug(list.size());

        for (int i = 0; i < 20; i++) {
            list.add(null);
        }

        LOG.debug(list.size());
    }
}
