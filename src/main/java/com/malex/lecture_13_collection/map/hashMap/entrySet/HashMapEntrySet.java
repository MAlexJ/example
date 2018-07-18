package com.malex.lecture_13_collection.map.hashMap.entrySet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEntrySet
{
    public static void main(String[] args)
    {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");
        map.put(4,"D");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();


    }
}
