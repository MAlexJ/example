package com.malex.lecture_13_collection_api.task_Collections;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

//Vararg -> ...
@Log
public class App_09_List_Arrays {
    public static void main(String[] args) {

        // import static java.util.Arrays.asList;
        // Constructor ->  public ArrayList(Collection<? extends E> c){}
        //  ArrayList<>()  ->  asList("A", "BB", "A")
        List<String> list = new ArrayList<>(asList("A", "BB", "A"));
        log.info(list.toString());


        // import java.util.Arrays;
        // Constructor ->  public ArrayList(Collection<? extends E> c){}
        //  ArrayList<>()  ->  Arrays.asList("A1", "BB1", "A1")
        List<String> list1 = new ArrayList<>(Arrays.asList("A1", "BB1", "A1"));
        log.info(list1.toString());
    }
}