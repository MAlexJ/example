package com.malex.lecture_13_collection.issue;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

@Log
public class RemoveElementFromList {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("AA");
        arrayList.add("AAA");
        arrayList.add("Bars");

        try {
            for (String item : arrayList) {
                if (item.length() > 2) {
                    arrayList.remove(item);
                }
                log.info("Item = " + item);
            }
        } catch (ConcurrentModificationException ex) {
            log.info("ConcurrentModificationException ex!");
        }

        Iterator<String> i = arrayList.iterator();
        while (i.hasNext()) {
            String item = i.next();
            if (item.length() == 2) {
                i.remove();
            }
            log.info(item);
        }
    }
}
