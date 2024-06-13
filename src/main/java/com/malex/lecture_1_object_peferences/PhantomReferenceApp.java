package com.malex.lecture_1_object_peferences;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

import com.malex.utils.AbstractUtils;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import org.junit.Test;

public class PhantomReferenceApp extends AbstractUtils {

  @Test
  public void initialization() {
    Object object = new Object();

    // 4. Phantom reference
    ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
    PhantomReference<Object> phantomReference = new PhantomReference<>(object, referenceQueue);

    println("Strong reference:", object);
    assertNotNull(object);

    println("Phantom reference:", phantomReference.get());
    assertNull(phantomReference.get());
    System.gc();

    println("Phantom reference:", phantomReference.get());
    assertNull(phantomReference.get());
  }
}
