package com.malex.lecture_15_concurrency.example_07_atomic;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

/**
 * Tutorial: Implementing Thread-Safe Singletons with Java AtomicReference and Java Volatile
 * Variables.
 *
 * <p>Link: https://www.youtube.com/watch?v=L1Pq9-bx7KY
 */
public class AtomicReferenceSample extends AbstractUtils {

  private static final String FORMAT_MSG = "value : %s, hashcode : %s";

  private Random random = new Random();

  @Test
  public void atomicReferenceImplementation() {
    SingletonAtomicReference<Double> singleton = SingletonAtomicReference.getInstance();
    singleton.setField(23.34);

    int hashCode = singleton.hashCode();
    println(String.format(FORMAT_MSG, singleton.getField(), hashCode));

    IntStream.range(0, 10)
        .forEach(
            num -> {
              var newInstance = SingletonAtomicReference.getInstance();
              newInstance.setField(random.nextDouble());

              println(String.format(FORMAT_MSG, newInstance.getField(), newInstance.hashCode()));
              assertEquals(hashCode, newInstance.hashCode());
            });
  }

  @Test
  public void doubleCheckedLockingImplementation() {
    // 1. init singleton
    SingletonDoubleCheckedLocking<Integer> singleton = SingletonDoubleCheckedLocking.instance();
    // 2. set singleton filed
    singleton.setField(10923);
    // 3. get hash code
    int hashCode = singleton.hashCode();
    println(String.format(FORMAT_MSG, singleton.getField(), hashCode));

    // 4. new singleton instance
    IntStream.range(0, 10)
        .forEach(
            num -> {
              var newInstance = SingletonDoubleCheckedLocking.instance();
              newInstance.setField(random.nextInt() + num);

              println(String.format(FORMAT_MSG, newInstance.getField(), newInstance.hashCode()));
              assertEquals(hashCode, newInstance.hashCode());
            });
  }

  private static class SingletonAtomicReference<T> {

    private static AtomicReference<SingletonAtomicReference> instance = new AtomicReference<>(null);

    private SingletonAtomicReference() {}

    @Getter @Setter private T field;

    public static <T> SingletonAtomicReference<T> getInstance() {
      // get current value of singleton
      SingletonAtomicReference<T> newInstance = instance.get();

      // check if singleton is not yet initialized
      if (newInstance == null) {

        // create new singleton object
        newInstance = new SingletonAtomicReference<>();

        /*
        <pre>
        abstract sealed class VarHandle implements Constable

        @IntrinsicCandidate
        @MethodHandle.PolymorphicSignature
        public final native boolean compareAndSet(Object... args)

        </pre>
         */
        if (!instance.compareAndSet(null, newInstance)) {
          newInstance = instance.get();
        }
      }

      return newInstance;
    }
  }

  /**
   * Double-checked locking: <a href="https://en.wikipedia.org/wiki/Double-checked_locking">Wiki
   *
   * <p>In software engineering, double-checked locking (also known as "double-checked locking
   * optimization") is a software design pattern used to reduce the overhead of acquiring a lock by
   * testing the locking criterion (the "lock hint") before acquiring the lock. Locking occurs only
   * if the locking criterion check indicates that locking is required.
   */
  private static class SingletonDoubleCheckedLocking<T> {

    private static volatile SingletonDoubleCheckedLocking singleton;

    @Getter @Setter private T field;

    /** Double-checked locking</a> */
    public static <T> SingletonDoubleCheckedLocking<T> instance() {
      // Assign volatile to a local variable
      var instance = singleton;

      // Check if instance is not yet initialized
      if (instance == null) {
        // only synchronize if ins == null

        synchronized (SingletonDoubleCheckedLocking.class) {
          instance = singleton;

          // perform the second check (i.e., double-check)
          if (instance == null) {
            // create one-and-only instance
            singleton = instance = new SingletonDoubleCheckedLocking<T>();
          }
        }
      }

      return instance;
    }
  }
}
