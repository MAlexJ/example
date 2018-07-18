package com.malex.lecture_13_collection.map.hashMap.mapJava8_putIfAbsent;

import java.util.HashMap;
import java.util.Map;

public class PutIfAbsent
{
    public static void main(String[] args)
    {
        // case 1: old style
        Map<String, String> map = new HashMap<>();
        map.put("num", "one");
        if (map.get("name") == null)
        {
            map.put("name", "Gus");
        }

        System.out.println("Old style: " + map);

        // case 2: java8
        map.putIfAbsent("gender", "male");
        map.putIfAbsent("gender", "female"); // not added

        System.out.println("Java8 style: " + map);

        map.put("phone", null);
        map.putIfAbsent("phone", "555-555");

        map.putIfAbsent("name", "NEW NAME");

        System.out.println("Java8 style: " + map);
    }
}
