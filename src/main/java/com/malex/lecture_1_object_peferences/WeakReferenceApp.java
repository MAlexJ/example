package com.malex.lecture_1_object_peferences;

import static junit.framework.TestCase.assertNull;

import com.malex.utils.AbstractUtils;
import java.lang.ref.WeakReference;
import org.junit.Test;

/**
 * Suppose that garbage collector determines at certain point in time that an object is weakly
 * reachable. At that time it will atomically clear all weak references to that object
 */
public class WeakReferenceApp extends AbstractUtils {

  @Test
  public void run() {
    // given
    var str = new String("Hello!");

    // and
    WeakReference<String> weakReference = new WeakReference<>(str);
    println(weakReference.get());

    // when
    str = null; // set null for reference
    System.gc(); // run garbage collector

    // then
    String refer = weakReference.get();
    println(refer);
    assertNull(refer);
  }
}
