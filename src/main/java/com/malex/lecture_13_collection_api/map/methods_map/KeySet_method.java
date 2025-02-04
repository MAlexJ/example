package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

/*
 * Returns a Set view of the keys contained in this map.
 *
 * The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.
 * If the map is modified while an iteration over the set is in progress (except through the iterator's own remove operation),
 * the results of the iteration are undefined.
 *
 * The set supports element removal, which removes the corresponding mapping from the map, via the Iterator. remove,
 * Set. remove, removeAll, retainAll, and clear operations.
 *
 * It does not support the add or addAll operations.
 *
 * Returns: a set view of the keys contained in this map
 */
public class KeySet_method extends AbstractUtils {

  @Test
  public void keySet() {
    // given
    Map<Integer, String> map = new HashMap<>(Map.of(1, "one", 2, "two", 3, "three"));

    // when
    Set<Integer> keySet = map.keySet();
    println("keySet", keySet);

    boolean remove = keySet.remove(1);
    assertTrue(remove);

    assertEquals(2, keySet.size());
    println("keySet", keySet);

    assertEquals(2, map.size());
    println("map", map);
  }
}
