package com.malex.lecture_13_collection_api.map.class_implementation.weakHashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.WeakHashMap;
import org.junit.Test;

/*
 * Hash table based implementation of the Map interface, with weak keys.
 *
 * An entry in a WeakHashMap will automatically be removed when its key is no longer in ordinary use.
 *
 * More precisely, the presence of a mapping for a given key will not prevent the key from being
 * discarded by the garbage collector, that is, made finalizable, finalized, and then reclaimed.
 *
 * When a key has been discarded its entry is effectively removed from the map, so this class behaves
 * somewhat differently from other Map implementations.
 */
public class BaseSample extends AbstractUtils {

  private record UserWr(String name) {}

  @Test
  public void initialization() {
    UserWr stefan = new UserWr("Stefan");
    UserWr dog = new UserWr("hot dog");

    var map = new WeakHashMap<UserWr, Integer>();
    map.put(stefan, 0);
    map.put(dog, -1);

    assertEquals(2, map.size());

    stefan = null;
    dog = null;

    assertEquals(2, map.size());

    // run garbage collector
    System.gc();

    println(map.values());
    println(map.keySet());

    assertTrue(map.isEmpty());
  }
}
