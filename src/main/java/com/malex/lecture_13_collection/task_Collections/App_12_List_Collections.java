package com.malex.lecture_13_collection.task_Collections;

import lombok.extern.java.Log;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Alex on 12.02.2015.
 */
@Log
public class App_12_List_Collections {

    public static void main(String[] args) {
        // asList("A","D","A","BB") -> Returns a fixed-size list backed by the specified array.
        // asList("A","D","A","BB") -> Returns not mutating  list
        List<String> list = asList("A", "D", "A", "BB");
        log.info(list.toString());

        // remove(0)  -> UnsupportedOperationException
        list.remove(0);
        log.info(list.toString());
    }
}
