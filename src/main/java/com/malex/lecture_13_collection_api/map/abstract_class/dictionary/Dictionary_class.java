package com.malex.lecture_13_collection_api.map.abstract_class.dictionary;

import static junit.framework.TestCase.*;

import com.malex.utils.AbstractUtils;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import org.junit.Test;

/*
 * Dictionary class is abstract parent of any class, such as Hashtable, which maps keys to values.
 *
 * Every key and every value is an object. In any one Dictionary object, every key is associated
 * with at most one value.
 */
public class Dictionary_class extends AbstractUtils {

  @Test
  public void simple() {
    Dictionary<String, Integer> dictionary = new Hashtable<>();

    // first put
    Integer prevValue = dictionary.put("1", 2);
    assertNull(prevValue);

    // get value by key
    Integer valueByKey = dictionary.get("1");
    assertEquals(Integer.valueOf(2), valueByKey);

    // remove not exist value
    Integer remove = dictionary.remove("3");
    assertNull(remove);

    boolean empty = dictionary.isEmpty();
    assertFalse(empty);

    int size = dictionary.size();
    assertEquals(1, size);
  }

  @Test
  public void keys() {
    Dictionary<String, Integer> dictionary = new Hashtable<>();

    // Returns: previous value of  specified key in this hashtable, or null if it did not have one
    Integer put = dictionary.put("first", 2);
    assertNull(put);

    // Returns an enumeration of the keys in this dictionary. The general contract for the keys
    // method is that an Enumeration object is returned that will generate all the keys for which
    // this dictionary contains entries.
    Enumeration<String> keys = dictionary.keys();
    String first = keys.nextElement();
    assertEquals("first", first);
    println(first);
  }

  @Test
  public void elements() {
    Dictionary<String, Integer> dictionary = new Hashtable<>();

    // test put elements
    Integer firstPut = dictionary.put("xxx", 0);
    Integer secondPut = dictionary.put("xxx", 1111);
    assertNull(firstPut);
    assertEquals(Integer.valueOf(0), secondPut);

    // test elements() method
    Enumeration<Integer> enumeration = dictionary.elements();
    Integer nextElement = enumeration.nextElement();
    println(nextElement);
    assertEquals(Integer.valueOf(1111), nextElement);
  }
}
