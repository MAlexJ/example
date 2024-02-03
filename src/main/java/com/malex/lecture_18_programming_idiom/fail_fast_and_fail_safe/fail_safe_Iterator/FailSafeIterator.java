package com.malex.lecture_18_programming_idiom.fail_fast_and_fail_safe.fail_safe_Iterator;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * Link:
 * https://www.javatpoint.com/fail-fast-and-fail-safe-in-java#:~:text=The%20Fail%2DFast%20system%20terminates,Failures%20as%20much%20as%20possible.
 * link: https://www.baeldung.com/java-fail-safe-vs-fail-fast-iterator
 */
public class FailSafeIterator extends AbstractUtils {

  private static final List<String> LIST_OF_NAMES =
      List.of("Alex", "Max", "Anna", "Stefan", "Paul");

  private static final Map<Integer, String> LIST_OF_STUDENTS;

  static {
    LIST_OF_STUDENTS =
        IntStream.range(0, LIST_OF_NAMES.size())
            .boxed()
            .collect(Collectors.toMap(num -> num, LIST_OF_NAMES::get));
  }

  @Test
  public void mapExample() {
    // creating ConcurrentHashMap by copy students map
    var concurrentMap = new ConcurrentHashMap<>(LIST_OF_STUDENTS);
    var iterator = concurrentMap.keySet().iterator();
    println("Before:", "map size -", concurrentMap.size());

    var nameOf = "Max";
    var revertName = new StringBuilder(nameOf).reverse().toString();

    while (iterator.hasNext()) {
      Integer next = iterator.next();
      Optional.ofNullable(LIST_OF_STUDENTS.get(next))
          .filter(name -> name.equalsIgnoreCase(nameOf))
          .ifPresent(
              name -> {
                concurrentMap.put(123, revertName);
              });
    }
    println("After: adding", "map size -", concurrentMap.size());

    concurrentMap.forEach(
        (num, name) -> {
          if (name.equalsIgnoreCase(revertName)) {
            concurrentMap.remove(num);
          }
        });

    println("After: removing", "map size -", concurrentMap.size());

    assertFalse(concurrentMap.contains(revertName));
  }

  @Test
  public void listExample() {
    // creating CopyOnWriteArrayList by copy students ArrayList
    var copyStudents = new CopyOnWriteArrayList<>(LIST_OF_NAMES);

    // creating an instance of the Iterator class
    var itr = copyStudents.iterator();

    // iterating CopyOnWriteArrayList using Iterator
    while (itr.hasNext()) {
      String name = itr.next();
      if (name.equalsIgnoreCase("Paul"))
        // The Rubby name will not print but it has created separate copy
        copyStudents.add("Rubby");
    }
    print(copyStudents);

    assertTrue(copyStudents.contains("Rubby"));
  }
}
