package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import java.util.Optional;
import org.junit.Test;

public class OptionalMap {

  @Test
  public void mapOptionalTest() {
    // given
    var stringNumber = "123345";

    // when
    var result = Optional.of(stringNumber).map(Integer::parseInt).map(Result::new).orElseThrow();

    // then
    assertNotNull(result);
    assertEquals(Integer.valueOf(stringNumber), result.number());
  }

  record Result(Integer number) {}
}
