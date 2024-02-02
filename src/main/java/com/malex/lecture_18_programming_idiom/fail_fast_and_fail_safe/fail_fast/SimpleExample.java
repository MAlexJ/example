package com.malex.lecture_18_programming_idiom.fail_fast_and_fail_safe.fail_fast;

import static junit.framework.TestCase.fail;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import org.junit.Test;

/** method uses 'Null' check validation and immediately throw NPE exception */
public class SimpleExample extends AbstractUtils {

  @Test
  public void run() {
    String msg = null;
    try {
      Optional.of(msg);
      fail();
    } catch (NullPointerException ex) {
      /*
         method uses 'Null' check validation and immediately throw NPE exception
         >>  return new Optional<>(Objects.requireNonNull(value));
      */
      printlnError(ex, 6);
    }
  }
}
