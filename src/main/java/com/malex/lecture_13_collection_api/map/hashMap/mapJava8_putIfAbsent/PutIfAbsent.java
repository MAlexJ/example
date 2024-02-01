package com.malex.lecture_13_collection_api.map.hashMap.mapJava8_putIfAbsent;

import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Log
public class PutIfAbsent {

    public static void main(String[] args) {
        // case 1: old style
        Map<String, String> map = new HashMap<>();
        map.put("num", "one");
        if (Objects.isNull(map.get("name"))) {
            map.put("name", "Gus");
        }

        log.info("Old style: " + map);

        // case 2: java8
        map.putIfAbsent("gender", "male");
        map.putIfAbsent("gender", "female"); // not added

        log.info("Java8 style: " + map);

        map.put("phone", null);
        map.putIfAbsent("phone", "555-555");

        map.putIfAbsent("name", "NEW NAME");

        log.info("Java8 style: " + map);
    }
}
