package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertEquals;

import java.util.Objects;
import java.util.Optional;
import org.junit.Test;

/**
 * Documentation 1. <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a>
 * <br>
 */
public class OptionalSample {

  @Test
  public void testCases() {
    // given
    var first_user_id = "ID:1";
    var second_user_id = "ID:2";

    // then
    assertEquals(first_user_id, findUserByIdOrProvideDefaultValue(true, "ID:1"));

    // and
    assertEquals(second_user_id, findUserByIdOrProvideDefaultValue(false, "ID:1"));
    assertEquals(second_user_id, findUserByIdOrProvideDefaultValue(true, "XXXX"));
  }

  private String findUserByIdOrProvideDefaultValue(boolean returnObject, String userId) {
    var user = createUserOrNull(returnObject);
    return Optional.ofNullable(user)
        .map(User::id)
        .filter(id -> id.equals(userId))
        .orElse(new User("ID:2").id());
  }

  private User createUserOrNull(boolean returnObject) {
    return returnObject ? new User("ID:1") : null;
  }

  record User(String id) {
    User {
      Objects.requireNonNull(id, "USer id should br not null!");
    }
  }
}
