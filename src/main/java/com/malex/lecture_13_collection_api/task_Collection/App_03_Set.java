package com.malex.lecture_13_collection_api.task_Collection;


import lombok.extern.java.Log;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Log
public class App_03_Set {


    public static void main(String[] args) {
        log.info("main");
        Set<String> listSet = new HashSet<>();
        log.info("listSet.add(\"bb\") -> " + listSet.add("bb"));
        log.info("listSet.add(\"e\") -> " + listSet.add("e"));
        log.info("listSet.add(\"d\") -> " + listSet.add("d"));
        log.info("listSet.add(\"c\") -> " + listSet.add("c"));
        log.info("listSet.add(\"b\") -> " + listSet.add("b"));
        log.info("listSet.add(\"c\") -> " + listSet.add("c"));
        log.info("listSet.add(\"a\") -> " + listSet.add("a"));

        log.info(listSet.toString());

        Set<String> listSet1 = new TreeSet<>();
        log.info("listSet.add(\"s\") -> " + listSet1.add("s"));
        log.info("listSet.add(\"d\") -> " + listSet1.add("d"));
        log.info("listSet.add(\"a\") -> " + listSet1.add("a"));
        log.info("listSet.add(\"b\") -> " + listSet1.add("b"));
        log.info("listSet.add(\"a\") -> " + listSet1.add("a"));
        log.info("listSet.add(\"c\") -> " + listSet1.add("c"));
        log.info("listSet.add(\"bb\") -> " + listSet1.add("bb"));

        log.info(listSet1.toString());
    }
}
