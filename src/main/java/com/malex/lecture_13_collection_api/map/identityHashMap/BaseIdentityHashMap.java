package com.malex.lecture_13_collection_api.map.identityHashMap;

import static org.junit.Assert.*;

import com.malex.utils.AbstractUtils;
import java.util.IdentityHashMap;
import java.util.Map;
import org.junit.Test;

/**
 * This class is designed for use only in the rare cases wherein reference-equality semantics are
 * required.
 *
 * <p>info: https://www.javamadesoeasy.com/2015/04/identityhashmap-in-java.html
 */
public class BaseIdentityHashMap extends AbstractUtils {

  @Test
  public void initialization() {
    IdentityHashMap<String, Integer> map1 = new IdentityHashMap<>();
    IdentityHashMap<String, Integer> map2 = new IdentityHashMap<>(3);
    IdentityHashMap<String, Integer> map3 = new IdentityHashMap<>(Map.of("a", 1));
  }

  /**
   * Comparing keys (and values) performs reference-equality in place of object-equality. In an
   * IdentityHashMap, two keys k1 and k2 are equal if and only if (k1==k2)
   */
  @Test
  public void referenceEqualityDiffReferences() {
    // given
    var map = new IdentityHashMap<String, Integer>();

    /*
    reference-equality >
    new String("a") == new String("a") returns false.

    object-equality >
    new String("a").equals(new String("a")) returns true.
    */
    String firstKey = new String("a");
    String secondKey = new String("a");
    // Asserts that two objects are equal: .equals(...)
    assertEquals(firstKey, secondKey);
    // Asserts that two objects do not refer to the same object: ==
    /*
    Strings are not the same
     */
    assertNotSame(firstKey, secondKey);

    // when
    map.put(firstKey, 1);
    map.put(secondKey, 2);

    // then
    print(map);
    assertEquals(2, map.size());
  }

  /**
   * Comparing keys (and values) performs reference-equality in place of object-equality. In an
   * IdentityHashMap, two keys k1 and k2 are equal if and only if (k1==k2)
   */
  @Test
  public void referenceEquality() {
    // given
    var map = new IdentityHashMap<String, Integer>();

    // and
    String firstKey = "a";
    String secondKey = "a";
    // Asserts that two objects are equal: .equals(...)
    assertEquals(firstKey, secondKey);
    // Asserts that two objects do not refer to the same object: ==
    assertSame(firstKey, secondKey);

    // when
    map.put(firstKey, 1);
    map.put(secondKey, 2);

    // then
    print(map);
    assertEquals(1, map.size());
  }
}
