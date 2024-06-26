package com.malex.lecture_1_object_peferences;

import com.malex.utils.AbstractUtils;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import org.junit.Test;

/**
 * Strong, Soft, Weak, Phantom Reference
 *
 * <p>Link to video: https://www.youtube.com/watch?v=5HC8qVHQPi8
 *
 * <p>Link to habr: https://habr.com/ru/articles/169883/
 *
 * <p>Link to javarush:
 * https://javarush.com/en/groups/posts/en.1267.differences-between-weak-soft-phantom-and-regular-references-in-java
 */
public class BaseExplanationReferences extends AbstractUtils {

  @Test
  public void explanation() {
    // 1. Strong reference
    Object object = new Object();

    // 2. Soft reference
    SoftReference<Object> softReference = new SoftReference<>(object);

    // 3. Weak reference
    WeakReference<Object> weakReference = new WeakReference<>(object);

    // 4. Phantom reference
    ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
    PhantomReference<Object> phantomReference = new PhantomReference<>(object, referenceQueue);

    println("Strong reference:", object);
    println("Soft reference:", softReference.get());
    println("Weak reference:", weakReference.get());
    println("Phantom reference:", phantomReference.get());
  }
}
