package com.malex.lecture_11_record;

import static org.junit.Assert.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

/**
 * Custom Constructor in Java Records link to info: <a
 * href="https://www.baeldung.com/java-records-custom-constructor">Custom Constructor in Java
 * Records</a>
 *
 * <p>Java Records give us greater control during object initialization by allowing for data
 * validation and error handling
 */
public class RecordWithCustomConstructor extends AbstractUtils {

  record Student(String name, int roll, int marks) {

    /**
     * One parameter and
     */
    public Student() {
      this("", 0, 0);
    }

    public Student(String name) {
      this(name, 0, 0);
    }

    public Student {
      if (name == null) {
        throw new IllegalArgumentException("Name cannot be null");
      }
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullArgument() {
    new Student(null, 1, 2);
  }

  @Test
  public void testListOfRecords() {
    var students =
        List.of( //
            new Student("Diana", 1, 5), //
            new Student("Alex", 3, 4), //
            new Student("Inna", 4, 2), //
            new Student("Nikolay", 11, 1));

    var arrayList = new ArrayList<>(students);
    arrayList.sort(Comparator.comparing(Student::name));
    assertEquals(
        "Alex", arrayList.stream().findFirst().orElseThrow(IllegalArgumentException::new).name());

    /*
     * how to get last element in stream - https://www.baeldung.com/java-stream-last-element <br>
     * use: reduce or skip function
     */
    assertEquals(
        "Nikolay", arrayList.stream().reduce((first, second) -> second).orElseThrow().name());
  }
}
