package com.malex.lecture_13_collection_api.map.class_implementation.identityHashMap;

import static org.junit.Assert.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.IdentityHashMap;
import org.junit.Test;

/**
 * Comparing keys (and values) performs reference-equality in place of object-equality. In an
 * IdentityHashMap, two keys k1 and k2 are equal if and only if (k1==k2)
 */
public class PutObjectIdentityHashMap extends AbstractUtils {
  @Test
  public void referenceEquality() {
    // given
    var map = new IdentityHashMap<Emp, Integer>();

    Emp audi = new Emp("Audi");
    map.put(audi, 1);
    map.put(new Emp("Audi"), 2);
    print(map);
    assertEquals(2, map.size());

    map.put(audi, 3);
    map.put(audi, 4);
    map.put(audi, 5);
    assertEquals(2, map.size());
    assertEquals(Integer.valueOf(5), map.get(audi));
  }

  private record Emp(String name) {}
}
