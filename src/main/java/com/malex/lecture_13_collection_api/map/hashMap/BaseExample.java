package com.malex.lecture_13_collection_api.map.hashMap;

import com.malex.lecture_13_collection_api.map.AbstractMapBaseUtils;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class BaseExample extends AbstractMapBaseUtils {

  private static Map<String, Integer> map;

  private static final String CILKA = "Килька";
  private static final String SAR_DINA = "Сардина";

  static {
    map = new HashMap<>();
  }

  @Test
  public void run() {
    print("Start size of the map: " + map.size());
    print("Check the map is empty ot not: " + map.isEmpty());

    /*
     * The method put(k,v) - return the previous value associated with key, or null if there was no mapping for key.
     * A null return can also indicate that the map  previously associated null with key,
     * if the implementation supports null values.
     */
    print("map.put(`Килька`, 25) -> " + map.put(CILKA, 25));
    print("map.put(`Килька`, 31) -> " + map.put(CILKA, 31));
    print("map.put(`Силька`, 10) -> " + map.put(SAR_DINA, 10));

    // containsKey(K)
    print("map.containsKey(`Килька`) -> " + map.containsKey(CILKA));

    // containsValue(V)
    print("map.containsValue(25) -> " + map.containsValue(25));

    // size()
    print("map.size() -> " + map.size());

    // remove(K)
    /* return the previous value associated with key, or null if there was no mapping for key*/
    print(" map.remove(`Килька`) -> " + map.remove(CILKA));

    // remove(K, V)
    print(" map.remove(`Сардина`, 10) -> " + map.remove(SAR_DINA, 10));

    // size()
    print("map.size() -> " + map.size());

    // map.put(null,12)
    print("first > map.put(null,12) -> " + map.put(null, 12));
    print("second > map.put(null,12) -> " + map.put(null, 12));

    // size()
    print("Check size: " + map.size());

    // map.put("null",12)
    print("Put: map.put(null,12) -> " + map.put("null", null));

    // size()
    print("Print size: " + map.size());
  }
}
