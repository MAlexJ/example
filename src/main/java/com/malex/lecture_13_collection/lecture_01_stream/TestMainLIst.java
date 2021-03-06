package com.malex.lecture_13_collection.lecture_01_stream;

import org.apache.log4j.Logger;

import java.util.LinkedList;

public class TestMainLIst {

    private static final Logger LOG = Logger.getLogger(TestMainLIst.class);

    public static void main(String[] args) {
        LinkedList<String> arrayList = new LinkedList<>();
        arrayList.add("str1");
        arrayList.add("str2");
        arrayList.add("str3");
        arrayList.add("str4");
        arrayList.addFirst("First");
        arrayList.removeFirst();
        arrayList.removeFirst();
        arrayList.removeFirst();
        arrayList.removeFirst();
        LOG.debug(arrayList);
    }
}