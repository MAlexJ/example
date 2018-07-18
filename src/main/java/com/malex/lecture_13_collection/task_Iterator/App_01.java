package com.malex.lecture_13_collection.task_Iterator;

import org.apache.log4j.Logger;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by Alex on 13.02.2015.
 */
public class App_01 {
    private static final Logger LOG = Logger.getLogger(App_01.class);

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(asList("A", "C", "D", "B", "F"));

        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            LOG.debug(iter.next());
        }

        Set<Integer> set = new HashSet<>(asList(1, 3, 2, 1, 4));

        System.out.println();
        // Set - нет доступа по индексу
        for (Iterator<Integer> iter = set.iterator(); iter.hasNext(); ) {
            LOG.debug(iter.next());
        }
        System.out.println();

        for (Integer iter : set) {
            LOG.debug(iter);
        }
        System.out.println();

        Map<String, String> map = new HashMap<>();
        map.put("A", "*");
        map.put("B", "+");
        map.put("C", "-");
        map.put("D", "~");

        for (Map.Entry<String, String> elem : map.entrySet()) {
            LOG.debug("elem - > " + elem);
            LOG.debug("elem.getKey() -> " + elem.getKey());
            LOG.debug("elem.getValue() -> " + elem.getValue());
        }
        System.out.println();

        int[] arr = {2, 3, 4, 5, 6, 7, 8};

        for (int iter : arr) {
            System.out.println(iter);
        }
    }

}
