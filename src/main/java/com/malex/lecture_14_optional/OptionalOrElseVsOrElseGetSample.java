package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Before;
import org.junit.Test;

/**
 * Documentation 1. <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a>
 * <br>
 */
public class OptionalOrElseVsOrElseGetSample extends AbstractUtils {

  private AtomicInteger counter = null;

  @Before
  public void before() {
    counter = new AtomicInteger();
    println("Before all test, counter:", counter.get());
  }

  @Test
  public void eagerInitializationTest() {
    // given
    var name = "Test";
    println("orElse");

    // when
    String nameOpt = Optional.ofNullable(name).orElse(defaultImpl());

    // then
    assertEquals(1, counter.get());
    assertEquals(name, nameOpt);
  }

  @Test
  public void lazyInitializationTest() {
    // given
    var counter = new AtomicInteger();
    println("orElseGet");

    // when
    Optional.ofNullable("Test").orElseGet(this::defaultImpl);

    // then
    assertEquals(0, counter.get());
  }

  private String defaultImpl() {
    println("Default imp:", counter.incrementAndGet());
    return "name";
  }
}
