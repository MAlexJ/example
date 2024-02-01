package com.malex.lecture_13_collection_api.task_Collections;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Alex on 12.02.2015.
 */
@Log
public class App_10_List_HashSet {

    public static void main(String[] args) {
        // Constructor ->  public ArrayList(Collection<? extends E> c){}
        List<String> list = new ArrayList<>(asList("A", "BB", "A"));
        log.info(list.toString());

        // To make unique items in list
        // Constructor ->  public HashSet(Collection<? extends E> c) {}
        log.info(new HashSet<>(list).toString());
    }
}