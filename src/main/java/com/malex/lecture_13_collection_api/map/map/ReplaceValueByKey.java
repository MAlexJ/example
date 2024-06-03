package com.malex.lecture_13_collection_api.map.map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import org.junit.Test;

public class ReplaceValueByKey extends AbstractUtils {
  @Test
  public void replaceByKey() {
    var map = new HashMap<String, Integer>();
    map.put("first", 11);

    Integer first = map.replace("first", 22);
    assertEquals(Integer.valueOf(11), first);
  }

  @Test
  public void replaceByNullKey() {
    var map = new HashMap<String, Integer>();
    map.put("first", 11);

    Integer first = map.replace(null, 22);
    assertNull(first);
    println("map:", map);
  }

  @Test
  public void replaceByNullValue() {
    var map = new HashMap<String, Integer>();
    map.put("first", 11);

    Integer first = map.replace("first", null);
    assertEquals(Integer.valueOf(11), first);
    println("map:", map);
  }
}
