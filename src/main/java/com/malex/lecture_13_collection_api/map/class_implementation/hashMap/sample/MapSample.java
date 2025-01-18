package com.malex.lecture_13_collection_api.map.class_implementation.hashMap.sample;

import lombok.extern.java.Log;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The Map<K,V> - an object that maps keys to values.
 * A map cannot contain duplicate keys, each map's key can contain no more than one value.
 */
@Log
public class MapSample implements MapSampleImpl {
    private static MapSampleImpl sample;

    static {
        sample = new MapSampleDecorator(new MapSample());
    }

    public static void main(String[] args) {
        // #1 sample
        sample.useDuplicateKey();

        // #2 sample
        sample.getValuesInVariousWay();

        // #3 sample
        sample.splitKeyAndValues();
    }

    @Override
    public void useDuplicateKey() {
        Map<String, String> mapStr = new HashMap<>();
        String oneKey = "key";
        mapStr.put(oneKey, "asd");
        mapStr.put(oneKey, "ewq");
        log.info("Print map: " + mapStr);
    }

    @Override
    public void getValuesInVariousWay() {
        // fill the map with values
        Map<Integer, String> mapStr = new HashMap<>();
        mapStr.put(1, "asd");
        mapStr.put(2, "ewq");
        mapStr.put(5, "ewq");
        mapStr.put(3, "ewq");
        mapStr.put(4, "ewq");

        // print Map<K,V>
        log.info("Print map >>> " + mapStr);

        // get key sey
        Set<Integer> integerSet = mapStr.keySet();
        log.info(" Set<Integer> integerSet = mapStr.keySet(): " + integerSet);

        // get values from map
        Collection<String> stringCollection = mapStr.values();
        log.info(" Collection<String> stringCollection = mapStr.values(): " + stringCollection);

        // get Map.Entry entrySet
        Set<Map.Entry<Integer, String>> entries = mapStr.entrySet();
        log.info(" Set<Map.Entry<Integer, String>> entries = mapStr.entrySet(): " + entries);
    }

    private static final String LOG_MSG = "[Key: %s | Value: %s ]";

    @Override
    public void splitKeyAndValues() {
        Map<Integer, String> map = IntStream.range(0, 7)
                .boxed()
                .collect(getMapCollector());

        map.forEach((k, v) -> log.info(String.format(LOG_MSG, k, v)));
    }

    private Collector<Integer, ?, Map<Integer, String>> getMapCollector() {
        return Collectors.toMap(Function.identity(), v -> "val");
    }

    @Override
    public void callingDifferentTypesOfMaps() {
        Map<String, String> mapLinkedHash = new LinkedHashMap<>();
        Map<String, String> mapLHash = new HashMap<>();
        Map<String, String> mapTree = new TreeMap<>();

        // #1 case: add `null` to a key of the map
        mapLinkedHash.put(null, "A");
        mapLHash.put(null, "A");
        try {
            mapTree.put(null, "A");
        } catch (NullPointerException ex) {
            //  exception > NullPointerException
        }

        log.info("#1: Set KEY 'null' to Map<K,V>");
        log.info(" 1. LinkedHashMap: " + mapLinkedHash);
        log.info(" 2. HashMap: " + mapLHash);
        log.info(" 3. TreeMap: If set KEY 'null' to Tree map when expect throw new NPE!  " + mapTree + "\n");


        // #2 case: add `null` to a value of the map
        mapLinkedHash.put("A", null);
        mapLHash.put("S", null);
        mapTree.put("D", null);

        log.info(" #2: Set VALUE 'null' to Map<K,V>");
        log.info("1. LinkedHashMap: " + mapLinkedHash);
        log.info("2. HashMap: " + mapLHash);
        log.info("3. TreeMap: " + mapTree);
    }
}
