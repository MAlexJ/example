package com.malex.lecture_13_collection_api.task_Collection;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Alex on 04.02.2015.
 * <p>
 * STRUCTURE:
 * <p>
 * interface Collection -----> interface List ----> class ArrayList
 */
@Log
public class App_00_ArrayList {


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

        log.info("************");
        Collection<String> list = new ArrayList<>();

        log.info("list.size() ->" + list.size());
        log.info("list.isEmpty() ->" + list.isEmpty());
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        log.info("list.contains(\"x\") ->" + list.contains("x"));
        log.info("list.contains(\"a\") ->" + list.contains("a"));
        log.info(list.toString());
    }


    /**
     * Simple CRUD operations over ArrayList
     */
    private static void crudOperations() {

        log.info("************");
        List<String> list = new ArrayList<>();

        log.info("list.size() ->" + list.size());
        log.info("list.isEmpty() ->" + list.isEmpty());

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

        log.info("list.contains(\"x\") ->" + list.contains("x"));
        log.info("list.contains(\"a\") ->" + list.contains("a"));
        log.info("list.get(3) -> " + list.get(3));

        log.info(list.toString());

        //remove for index
        log.info("list.remove(3) -> " + list.remove(3));

        //remove for Object
        log.info("list.remove(\"a\") ->" + list.remove("a"));

        log.info(list.toString());
    }


    /**
     * Add null
     */
    private static void addNullToArrayList() {
        ArrayList<String> list = new ArrayList<>();

        log.info("***************");

        log.info("size: " + list.size());

        for (int i = 0; i < 20; i++) {
            list.add(null);
        }

        log.info("size: " + list.size());
    }
}
