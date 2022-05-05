package com.malex.lecture_13_collection.task_Collections;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Alex on 12.02.2015.
 */
@Log
public class App_11_List_HashSet {
    public static void main(String[] args) {
        // Constructor ->  public ArrayList(Collection<? extends E> c){}
        List<String> list = new ArrayList<>(asList("D", "A", "BB", "A", "C"));
        log.info(list.toString());

        // Constructor ->  public ArrayList(Collection<? extends E> c){}
        List<String> list2 = new ArrayList<>(new HashSet<>(list));
        // This class consists exclusively of static methods that operate on or return collections.
        // void sort(List<T> list){}
        // Sorts the specified list into ascending order, according to the Comparable natural ordering of its elements.
        Collections.sort(list2);
        log.info(list2.toString());
    }
}
