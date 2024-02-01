package com.malex.lecture_2_statements.ExpressionStatements.lecture_2_equals.equals_and_hachcode.equals_different_classes;

import static org.junit.Assert.*;

import com.malex.utils.AbstractUtils;
import java.util.Objects;
import lombok.*;
import org.junit.Test;

/** Created by alex on 14.06.15. Comparison of different classes in the program */
public class ComparisonOfDifferentClassesInApp extends AbstractUtils {

  @Test
  public void oneClassWithoutOverrideEqualsAndHashCode() {
    // given
    var firstUser = new UserWithoutOverride("Anna", 20);
    var secondUser = new UserWithoutOverride("Anna", 20);
    var thirdUser = firstUser;

    // then
    println("Equals object:", firstUser.equals(secondUser));
    assertNotEquals(firstUser, secondUser);

    println("Equals first and second links:", firstUser == secondUser);
    assertNotSame(firstUser, secondUser);

    println("Equals first and third links:", firstUser == thirdUser);
    assertSame(firstUser, thirdUser);
  }

  @Test
  public void onlyOneFieldOverridesInEquals() {
    // given
    var firstUser = new UserOnlyOneOverrides("Anna11", 20);
    var secondUser = new UserOnlyOneOverrides("Xxx", 20);

    // then
    println("Comparison of objects by age:", firstUser.equals(secondUser));
    assertEquals(firstUser, secondUser);
  }

  @Test
  public void allClassFieldsAreOverriddenInEqualsAndHashcode() {
    // given
    var firstUser = new UserAllFieldsOverridden("Anna", 20);
    var secondUser = new UserAllFieldsOverridden("Anna", 20);

    // then
    println("Comparison of objects across all fields:", firstUser.equals(secondUser));
    assertEquals(firstUser, secondUser);
  }

  @ToString
  @AllArgsConstructor
  public static class UserWithoutOverride {
    private final String name;
    private final int age;
  }

  @ToString
  @AllArgsConstructor
  public static class UserOnlyOneOverrides {
    private final String name;
    private final int age;

    @Override
    public int hashCode() {
      return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      UserOnlyOneOverrides user = (UserOnlyOneOverrides) o;
      // equals -> age
      return this.age == user.age;
    }
  }

  @AllArgsConstructor
  public static class UserAllFieldsOverridden {

    private final String name;
    private final int age;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      UserAllFieldsOverridden user = (UserAllFieldsOverridden) o;

      if (age != user.age) return false;
      return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
      int result = name != null ? name.hashCode() : 0;
      result = 31 * result + age;
      return result;
    }

    @Override
    public String toString() {
      return "User_3{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
  }
}
