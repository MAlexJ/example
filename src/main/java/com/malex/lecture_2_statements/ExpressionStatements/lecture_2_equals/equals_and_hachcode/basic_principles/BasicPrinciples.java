package com.malex.lecture_2_statements.ExpressionStatements.lecture_2_equals.equals_and_hachcode.basic_principles;

import static junit.framework.TestCase.*;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

/** Testing the basic principles */
public class BasicPrinciples {

  /** Reflexive: For any non-null reference value x, x.equals(x) must return true */
  @Test
  public void reflexive() {
    TUser user = new TUser(1, "NAME");
    assertEquals(user, user);
  }

  /**
   * Symmetric: For any non-null reference values x and y, x.equals(y) must return true if and only
   * if y.equals(x) returns true
   */
  @Test
  public void symmetric() {
    TUser x = new TUser(2, "X");
    TUser y = new TUser(2, "X");

    assertEquals(x, y);
    assertEquals(y, x);
  }

  /**
   * Transitive: For any non-null reference values x, y, z, if x.equals(y) returns true and
   * y.equals(z) returns true, then x.equals(z) must return true
   */
  @Test
  public void transitive() {
    TUser userX = new TUser(2, "X");
    TUser userY = new TUser(2, "X");
    TUser userZ = new TUser(2, "X");

    assertEquals(userX, userY);
    assertEquals(userX, userZ);
    assertEquals(userY, userZ);
  }

  /**
   * Consistent: For any non-null reference values x and y, multiple invocations of x.equals(y)
   * consistently return true or consistently return false, provided no information used in equals
   * comparisons on the objects is modified.
   */
  @Test
  public void consistent() {
    TUser userX = new TUser(2, "X");
    TUser userY = new TUser(2, "X");

    for (int i = 0; i < 20; i++) {
      assertEquals(userX, userY);
      assertEquals(userY, userX);
    }
  }

  /** For any non-null reference value x, x.equals(null) must return false */
  @Test
  public void non_null_reference() {
    TUser user = new TUser(2, "X");
    assertNotNull(user);
  }

  @Getter
  @Setter
  public static class TUser {

    private int id;

    private String name;

    public TUser(int id, String name) {
      this.id = id;
      this.name = name;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      TUser tUser = (TUser) o;
      if (id != tUser.id) return false;
      return Objects.equals(name, tUser.name);
    }

    @Override
    public int hashCode() {
      int result = id;
      result = 31 * result + (name != null ? name.hashCode() : 0);
      return result;
    }
  }
}
