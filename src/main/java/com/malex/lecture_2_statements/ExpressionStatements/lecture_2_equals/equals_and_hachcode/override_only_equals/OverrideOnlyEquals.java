package com.malex.lecture_2_statements.ExpressionStatements.lecture_2_equals.equals_and_hachcode.override_only_equals;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.util.Arrays;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

/** Override only equals without hashcode */
public class OverrideOnlyEquals {

  @Test
  public void overrideOnlyEqualsWithoutHashcode() {
    // #1 create a first object
    MouseObject m1 = new MouseObject();
    m1.setId(1);

    // #2 create a second object
    MouseObject m2 = new MouseObject();
    m2.setId(1);

    // #3 assert these objects
    assertEquals(m1, m2);
    assertTrue(m1.hashCode() != m2.hashCode());
  }

  @Getter
  @Setter
  public static class MouseObject {

    private int id;

    private String name;

    private int[] params;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      MouseObject that = (MouseObject) o;

      if (id != that.id) return false;

      if (!Objects.equals(name, that.name)) return false;

      return Arrays.equals(params, that.params);
    }
  }
}
