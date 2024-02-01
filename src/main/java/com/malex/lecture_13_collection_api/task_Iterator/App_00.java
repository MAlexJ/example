package com.malex.lecture_13_collection_api.task_Iterator;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Alex on 12.02.2015.
 */
@Log
public class App_00 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(asList("B", "A", "C", "F", "D"));

        for (int i = 0; i < list.size(); i++) {
            log.info(list.get(i));
        }

        // ArrayList<> implements RandomAccess
        // interface RandomAccess -> Marker interface used by List implementations to indicate that they support fast (generally constant time) random access.
        /*
        * public static <T>
            int binarySearch(List<? extends Comparable<? super T>> list, T key) {
                if (list instanceof RandomAccess || list.size()<BINARYSEARCH_THRESHOLD)
                    return Collections.indexedBinarySearch(list, key);
                 else
                    return Collections.iteratorBinarySearch(list, key);
            }
        */

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        for (String iter1 : list) {
            System.out.println(iter1);
        }

    }

}
