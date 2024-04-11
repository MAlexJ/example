package com.malex.lecture_14_optional;

import static junit.framework.TestCase.*;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.Test;

/**
 * Documentation <br>
 * 1. Optional tutorial: <a href="https://habr.com/ru/articles/658457/">Java Class guide
 * Optional</a>
 *
 * <p>Java 8 has introduced a new class Optional in java.util package. It is used to represent a
 * value is present or absent.
 *
 * <p>Advantages of Java 8 Optional: <br>
 * <br>
 * 1. Null checks are not required.<br>
 * 2. No more NullPointerException at run-time. <br>
 * 3. We can develop clean and neat APIs. <br>
 * 4. No more Boiler plate code
 */
public class BaseOptional {

  @Test
  public void testOfNullable() {
    // given
    var name = "Stefan";

    // when
    var stringOpt = Optional.ofNullable(name);

    // then
    assertTrue(stringOpt.isPresent());
  }

  /** if element is null then NoSuchElementException */
  @Test(expected = NoSuchElementException.class)
  public void testOfNullableGetElement() {
    // given
    String name = null;

    // then
    Optional<String> opt = Optional.ofNullable(name);

    // when ->  NoSuchElementException
    opt.get();
    // newer use
    fail();
  }

  /** Can't pass null to Optional.of( ... ) this results to NullPointerException */
  @Test(expected = NullPointerException.class)
  public void testOfIfValueIsNull() {
    // given
    String name = null;

    // then ->  NullPointerException
    Optional.of(name);

    // newer use
    fail();
  }

  @Test
  public void testOfNullableWithNullParams() {
    // given
    String name = null;

    // when
    Optional<String> opt = Optional.ofNullable(name);

    // then
    assertFalse(opt.isPresent());
    // and
    assertTrue(opt.isEmpty());
    // and
    assertEquals(Optional.empty(), opt);
  }
}
