package com.malex.lecture_13_collection_api.map.properties;

import com.malex.utils.AbstractUtils;
import java.io.*;
import java.util.*;
import org.junit.Test;

/*
 * The Properties class represents a persistent set of properties.
 *
 * The Properties can be saved to a stream or loaded from a stream.
 *
 * Each key and its corresponding value in the property list is a string.
 */
public class BaseProperties extends AbstractUtils {

  /**
   * A property list can contain another property list as its "defaults"; this second property *
   * list is searched if the property key is not found in the original property list.
   */
  @Test
  public void initialization() {
    // 1. constructor
    Properties properties = new Properties();

    // 2. init with capacity
    Properties oneProps = new Properties(1);
    Object setProperty = oneProps.setProperty("env", "dev");
    println("saved value by 'env' key:", setProperty);
    println("props:", oneProps);

    // 3. init by props
    Properties propsToProps = new Properties(oneProps);
    propsToProps.setProperty("test", "impl");
    propsToProps.setProperty("animal", "cat");
    println("props:", propsToProps);
    println("get by 'env' key:", propsToProps.getProperty("env"));
    println("get by 'test' key:", propsToProps.getProperty("test"));
  }

  @Test
  public void methods() {
    Properties properties = new Properties();

    // 1. set value
    //    synchronized method
    Object setProperty = properties.setProperty("env", "dev");

    // 2. get value by key
    String property = properties.getProperty("env");
    String defaultIfNotFoundProps = properties.getProperty("animal", "DEFAULT");

    // 3. Returns an enumeration of all the keys in this property list, including distinct keys in
    // the default property
    Enumeration<?> propertyNames = properties.propertyNames();
    println("names:", propertyNames, "val:", propertyNames.nextElement());

    // 4. unmodifiable set of keys from this property list
    Set<String> stringSet = properties.stringPropertyNames();
    println(stringSet);
  }

  /**
   * Reads a property list (key and element pairs) from the input character stream in a simple
   * line-oriented format.
   */
  @Test
  public void load() throws Exception {
    Reader reader = new FileReader("src/main/resources/log4j.properties");
    Properties properties = new Properties();
    // synchronized method
    properties.load(reader);
    println(properties);
  }

  /**
   * Writes this property list (key and element pairs) in this Properties table to the output
   * character stream in a format suitable for using the load(Reader) method.
   */
  @Test
  public void store() throws IOException {
    var properties = new Properties();
    properties.setProperty("name", "Stefan");
    properties.setProperty("email", "stef@java.com");
    properties.store(new FileWriter("temp.properties"), "Java Properties Example");
  }

  /**
   * Prints this property list out to the specified output stream. This method is useful for
   * debugging.
   */
  @Test
  public void list() {
    PrintWriter writer = new PrintWriter(System.out);
    Properties properties = new Properties();
    properties.setProperty("name", "Stefan");
    properties.setProperty("email", "stef@java.com");
    properties.list(writer);
    println(properties );
  }
}
