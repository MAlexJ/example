package com.malex.lecture_13_collection.map.hashMap;

import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.Map;

@Log
public class SimpleExample {
    private static Map<String, Integer> map;

    private static final String CILKA = "Килька";
    private static final String SAR_DINA = "Сардина";

    static {
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        log.info("Start size of the map: " + map.size());
        log.info("Check the map is empty ot not: " + map.isEmpty());

        /*
         * The method put(k,v) - return the previous value associated with key, or null if there was no mapping for key.
         * A null return can also indicate that the map  previously associated null with key,
         * if the implementation supports null values.
         */
        log.info("map.put(`Килька`, 25) -> " + map.put(CILKA, 25));
        log.info("map.put(`Килька`, 31) -> " + map.put(CILKA, 31));
        log.info("map.put(`Силька`, 10) -> " + map.put(SAR_DINA, 10));

        // containsKey(K)
        log.info("map.containsKey(`Килька`) -> " + map.containsKey(CILKA));

        // containsValue(V)
        log.info("map.containsValue(25) -> " + map.containsValue(25));

        // size()
        log.info("map.size() -> " + map.size());

        // remove(K)
        /* return the previous value associated with key, or null if there was no mapping for key*/
        log.info(" map.remove(`Килька`) -> " + map.remove(CILKA));

        // remove(K, V)
        log.info(" map.remove(`Сардина`, 10) -> " + map.remove(SAR_DINA, 10));

        // size()
        log.info("map.size() -> " + map.size());

        // map.put(null,12)
        log.info("first > map.put(null,12) -> " + map.put(null, 12));
        log.info("second > map.put(null,12) -> " + map.put(null, 12));

        // size()
        log.info("Check size: " + map.size());

        // map.put("null",12)
        log.info("Put: map.put(null,12) -> " + map.put("null", null));

        // size()
        log.info("Print size: " + map.size());
    }
}
