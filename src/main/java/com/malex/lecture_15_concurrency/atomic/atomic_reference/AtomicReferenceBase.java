package com.malex.lecture_15_concurrency.atomic.atomic_reference;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Test;

/** An object reference that may be updated atomically. */
public class AtomicReferenceBase extends AbstractUtils {

  private record MyRef(String value) {}

  @Test
  public void get() {
    AtomicReference<MyRef> reference = new AtomicReference<>();
    info(reference);
    reference.set(new MyRef("Val"));
    info(reference);
  }

  public void info(AtomicReference<MyRef> reference) {
    println("Get - '", reference.get(), "', is null - ", reference.get() == null);
  }
}
