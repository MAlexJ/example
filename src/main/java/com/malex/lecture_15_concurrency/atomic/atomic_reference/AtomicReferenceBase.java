package com.malex.lecture_15_concurrency.atomic.atomic_reference;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.atomic.AtomicReference;
import lombok.Data;
import org.junit.Test;

/** An object reference that may be updated atomically. */
public class AtomicReferenceBase extends AbstractUtils {

  @Data
  private static class MyRef {
    private String value;
  }

  @Test
  public void test() throws InterruptedException {
    AtomicReference<MyRef> atomicReference = new AtomicReference<>();
  }
}
