package com.malex.lecture_13_collection_api.task_Iterator;

import lombok.extern.java.Log;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by Alex on 13.02.2015.
 */
@Log
public class App_01 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(asList("A", "C", "D", "B", "F"));

        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            log.info(iter.next());
        }

        Set<Integer> set = new HashSet<>(asList(1, 3, 2, 1, 4));

        System.out.println();
        // Set - нет доступа по индексу
        for (Iterator<Integer> iter = set.iterator(); iter.hasNext(); ) {
            log.info(iter.next().toString());
        }
        System.out.println();

        for (Integer iter : set) {
            log.info(iter.toString());
        }
        System.out.println();

        Map<String, String> map = new HashMap<>();
        map.put("A", "*");
        map.put("B", "+");
        map.put("C", "-");
        map.put("D", "~");

        for (Map.Entry<String, String> elem : map.entrySet()) {
            log.info("elem - > " + elem);
            log.info("elem.getKey() -> " + elem.getKey());
            log.info("elem.getValue() -> " + elem.getValue());
        }
        System.out.println();

        int[] arr = {2, 3, 4, 5, 6, 7, 8};

        for (int iter : arr) {
            System.out.println(iter);
        }
    }
}