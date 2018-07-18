package com.malex.lecture_13_collection.task_Collections;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

//Vararg -> ...

public class App_09_List_Arrays {
    private final static Logger LOG = Logger.getLogger(App_09_List_Arrays.class);

    public static void main(String[] args) {

        // import static java.util.Arrays.asList;
        // Constructor ->  public ArrayList(Collection<? extends E> c){}
        //  ArrayList<>()  ->  asList("A", "BB", "A")
        List<String> list = new ArrayList<>(asList("A", "BB", "A"));
        LOG.debug(list);


        // import java.util.Arrays;
        // Constructor ->  public ArrayList(Collection<? extends E> c){}
        //  ArrayList<>()  ->  Arrays.asList("A1", "BB1", "A1")
        List<String> list1 = new ArrayList<>(Arrays.asList("A1", "BB1", "A1"));
        LOG.debug(list1);

    }


}
