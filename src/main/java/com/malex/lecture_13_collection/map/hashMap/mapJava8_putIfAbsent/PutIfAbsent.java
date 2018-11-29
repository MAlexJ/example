package com.malex.lecture_13_collection.map.hashMap.mapJava8_putIfAbsent;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PutIfAbsent
{
    private static final Logger LOG = Logger.getLogger(PutIfAbsent.class);

    public static void main(String[] args)
    {
        // case 1: old style
        Map<String, String> map = new HashMap<>();
        map.put("num", "one");
        if (Objects.isNull(map.get("name")))
        {
            map.put("name", "Gus");
        }

        LOG.debug("Old style: " + map);

        // case 2: java8
        map.putIfAbsent("gender", "male");
        map.putIfAbsent("gender", "female"); // not added

        LOG.debug("Java8 style: " + map);

        map.put("phone", null);
        map.putIfAbsent("phone", "555-555");

        map.putIfAbsent("name", "NEW NAME");

        LOG.debug("Java8 style: " + map);
    }
}
