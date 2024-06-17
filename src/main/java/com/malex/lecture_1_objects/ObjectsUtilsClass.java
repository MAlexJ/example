package com.malex.lecture_1_objects;

import static junit.framework.TestCase.*;

import com.malex.utils.AbstractUtils;
import java.util.Comparator;
import java.util.Objects;
import org.junit.Test;

public class ObjectsUtilsClass extends AbstractUtils {

  @Test
  public void isOrNotNullMethod() {
    boolean isNull = Objects.isNull(null);
    assertTrue(isNull);

    boolean nonNull = Objects.nonNull(new String());
    assertTrue(nonNull);
  }

  @Test
  public void toStringMethod() {
    /*
     * Returns the result of calling toString for a non-null argument and "null" for a null
     * argument.
     */
    String cat = Objects.toString(Dgf.from("cat"));
    println("cat:", cat);

    String nullCat = Objects.toString(null);
    println("nullCat:", nullCat);
    assertEquals("null", nullCat);

    /*
    Returns the result of calling toString on the first argument if the first argument is not null
    and returns the second argument otherwise.
     */
    String nullDefault = Objects.toString(null, "default");
    println("nullDefault:", nullDefault);
    assertEquals("default", nullDefault);
  }

  /**
   * Returns a string equivalent to the string returned by { Object. toString} if that method and {
   * hashCode} are not overridden.
   */
  @Test
  public void toIdentityStringMethod() {
    String cat = Objects.toIdentityString(Dgf.from("cat"));
    println("cat:", cat);

    try {
      Objects.toIdentityString(null);
      fail();
    } catch (NullPointerException e) {
      // none
    }
  }

  @Test
  public void compareMethod() {
    var stefan = Dgf.from("Stefan");
    var bars = Dgf.from("Bars");
    int compare = Objects.compare(stefan, bars, Comparator.comparing(o -> o.name));
    assertFalse(compare < 1);
  }

  @Test
  public void equalsMethod() {
    // equals
    var stefan = Dgf.from("Stefan");
    var bars = Dgf.from("Bars");
    boolean equals = Objects.equals(stefan, bars);
    assertFalse(equals);

    // deepEquals
    int[] first = new int[3];
    first[0] = 1;
    first[1] = 5;
    first[2] = 3;
    int[] second = new int[3];
    second[0] = 1;
    second[1] = 5;
    second[2] = 3;
    // base equals
    assertFalse(Objects.equals(first, second));
    // deep Equals
    assertTrue(Objects.deepEquals(first, second));
  }

  @Test
  public void hashAndHashcodeMethod() {
    Objects.isNull(null);
    Objects.nonNull(new String());
  }

  @Test
  public void checkMethod() {
    /*
    Checks if the index is within the bounds of the range from 0 (inclusive) to length (exclusive).
    The index is defined to be out of bounds if any of the following inequalities is true:
    1. index < 0
    2. index >= length
    3. length < 0, which is implied from the former inequalities
    */
    int index = Objects.checkIndex(-1, 10);
    println(index);

    try {
      Objects.checkIndex(-1, 10);
    } catch (IndexOutOfBoundsException e) {
      // none
      println("java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 10");
    }
  }

  @Test
  public void requiredMethod() {
    /*
    Checks that the specified object reference is not null.
    Throws: NullPointerException – if obj is null
     */
    Dgf cat = Objects.requireNonNull(Dgf.from("Cat"));

    /*
    Returns the first argument if it is non-null and otherwise returns the non-null second argument
     */
    Dgf aDefault = Objects.requireNonNullElse(null, Dgf.from("default"));
    println(aDefault);
    assertEquals("default", aDefault.name);
  }

  private record Dgf(String name) {
    public static Dgf from(String name) {
      return new Dgf(name);
    }
  }
}
