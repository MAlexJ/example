package com.malex.lecture_1_object_peferences;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

import java.lang.ref.SoftReference;
import org.junit.Test;

/**
 * Soft reference objects, which are cleared at discretion of garbage collector in response to
 * memory demand. Soft references are most often used to implement memory-sensitive caches
 */
public class SoftReferenceApp {

  @Test
  public void initialization() {
    // given
    Object obj = new Object();

    // when
    SoftReference<Object> softReference = new SoftReference<>(obj);

    // and
    obj = null;
    System.gc();

    // then
    assertNotNull(softReference.get());
  }

  @Test
  public void cleanMethod() {
    // given
    Object obj = new Object();

    // when
    SoftReference<Object> softReference = new SoftReference<>(obj);

    // and
    softReference.clear();

    // then
    assertNull(softReference.get());

    // and
    assertNotNull(obj);
  }
}
