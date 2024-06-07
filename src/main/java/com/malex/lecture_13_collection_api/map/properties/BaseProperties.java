package com.malex.lecture_13_collection_api.map.properties;

import com.malex.utils.AbstractUtils;
import java.util.*;
import org.junit.Test;

public class BaseProperties extends AbstractUtils {

  @Test
  public void test() {
    Properties properties = new Properties();
    properties.clear();

    Object put = properties.put("1", 1);

    Object setProperty = properties.setProperty("2", "2");

    String property = properties.getProperty("2");

    String propertiesProperty = properties.getProperty("3", "Default");

    Enumeration<Object> enumeration = properties.elements();

    Set<Map.Entry<Object, Object>> entries = properties.entrySet();

    Enumeration<Object> keys = properties.keys();

    Collection<Object> values = properties.values();

    Enumeration<?> propertyNames = properties.propertyNames();

    Set<String> stringSet = properties.stringPropertyNames();

    boolean empty = properties.isEmpty();

  }
}
