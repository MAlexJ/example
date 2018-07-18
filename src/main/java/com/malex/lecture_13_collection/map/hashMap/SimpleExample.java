package com.malex.lecture_13_collection.map.hashMap;

import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 12.02.2015.
 */
@Log4j
public class SimpleExample
{
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args)
    {
        if (log.isDebugEnabled())
        {
            log.debug("map.size() -> " + map.size());
            log.debug("map.isEmpty() -> " + map.isEmpty());

            /*    put(K,V);
             * return the previous value associated with key, or  null if there was no mapping for key.
             * A null return can also indicate that the map  previously associated null with key,  if the implementation supports null values.)
             * */
            log.debug(" map.put(\"Килька\", 25) -> " + map.put("Килька", 25));
            log.debug(" map.put(\"Килька\", 31) -> " + map.put("Килька", 31));
            log.debug(" map.put(\"Силька\", 10) -> " + map.put("Сардина", 10));

            // containsKey(K)
            log.debug(" map.containsKey(\"Килька\") -> " + map.containsKey("Килька"));

            // containsValue(V)
            log.debug("  map.containsValue(25) -> " + map.containsValue(25));

            //size()
            log.debug("map.size() -> " + map.size());

            //remove(K)
            /* return the previous value associated with key, or null if there was no mapping for key*/
            log.debug(" map.remove(\"Килька\") -> " + map.remove("Килька"));

            //remove(K, V);
            log.debug(" map.remove(\"Сардина\", 10) -> " + map.remove("Сардина", 10));

            //size()
            log.debug("map.size() -> " + map.size());

            //map.put(null,12)
            log.debug("map.put(null,12) -> " + map.put(null, 12));
            log.debug("map.put(null,12) -> " + map.put(null, 12));

            //size()
            log.debug("map.size() -> " + map.size());

            //map.put("null",12)
            log.debug("map.put(null,12) -> " + map.put("null", null));

            //size()
            log.debug("map.size() -> " + map.size());
        }
    }
}
