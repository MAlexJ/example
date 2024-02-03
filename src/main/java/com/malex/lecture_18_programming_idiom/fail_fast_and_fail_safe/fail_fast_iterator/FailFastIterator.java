package com.malex.lecture_18_programming_idiom.fail_fast_and_fail_safe.fail_fast_iterator;

import static junit.framework.TestCase.fail;

import com.malex.utils.AbstractUtils;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * Topic: Fail-fast and Fail-safe in Java
 *
 * <p>link: <a
 * href="https://www.javatpoint.com/fail-fast-and-fail-safe-in-java#:~:text=The%20Fail%2DFast%20system%20terminates,Failures%20as%20much%20as%20possible">Fail-fast
 * and Fail-safe in Java</a>.
 */
public class FailFastIterator extends AbstractUtils {

  private static final List<String> LIST_OF_NAMES =
      List.of("Alex", "Max", "Anna", "Stefan", "Paul");

  private static final Map<Integer, String> LIST_OF_STUDENTS;

  static {
    LIST_OF_STUDENTS =
        IntStream.range(0, LIST_OF_NAMES.size())
            .boxed()
            .collect(Collectors.toMap(num -> num, LIST_OF_NAMES::get));
  }

  /**
   * Fail-fast Iterator <br>
   * <br>
   * When we use the Fail-fast iterator, it immediately throws ConcurrentModificationException when
   * an element is added or removed from the collection while the thread is iterating over the
   * collection. <br>
   * Examples: Iterator in HashMap, Iterator on ArrayList, etc.
   */
  @Test(expected = ConcurrentModificationException.class)
  public void whileIterator() {
    // given
    var students = new HashMap<>(LIST_OF_STUDENTS);
    var iterator = students.keySet().iterator();

    // when
    while (iterator.hasNext()) {
      println("1.", students.get(iterator.next()));
      // on the next call of next() method, exception will be thrown.
      students.put(104, "Rubby");
      println("2.", "add new student: Rubby");
    }

    // then
    unattainableMethod();
  }

  @Test(expected = ConcurrentModificationException.class)
  public void forIterator() {
    // given
    var students = new HashMap<>(LIST_OF_STUDENTS);

    // when
    for (Integer integer : students.keySet()) {
      println("1.", students.get(integer));
      // on the next call of next() method, exception will be thrown.
      students.put(104, "Rubby");
      println("2.", "add new student: Rubby");
    }

    // then
    unattainableMethod();
  }

  @Test(expected = ConcurrentModificationException.class)
  public void forStreamIterator() {
    // given
    var students = new HashMap<>(LIST_OF_STUDENTS);
    students
        .keySet()
        .forEach(
            intNum -> {
              println("1.", students.get(intNum));
              // on the next call of next() method, exception will be thrown.
              students.put(104, "Rubby");
              println("2.", "add new student: Rubby");
            });

    // then
    unattainableMethod();
  }

  @Test(expected = ConcurrentModificationException.class)
  public void whileIteratorForArrayList() {
    // given
    var students = new ArrayList<>(LIST_OF_NAMES);
    Iterator<String> iterator = students.iterator();

    // when
    while (iterator.hasNext()) {
      String name = iterator.next();
      if (name.equals("Max")) {
        students.remove("Alex");
      }
    }

    // then
    unattainableMethod();
  }

  @Test(expected = ConcurrentModificationException.class)
  public void forIteratorForArrayList() {
    // given
    var students = new ArrayList<>(LIST_OF_NAMES);

    // when
    for (String name : students) {
      if (name.equals("Max")) {
        boolean removed = students.remove("Alex");
        println("remove:", "Alex", ", result -", removed);
      }
    }

    // then
    unattainableMethod();
  }

  private void unattainableMethod() {
    fail("The program should not reach the end of program");
  }
}
