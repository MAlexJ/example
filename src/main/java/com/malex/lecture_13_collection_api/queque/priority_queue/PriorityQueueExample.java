package com.malex.lecture_13_collection_api.queque.priority_queue;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import com.malex.lecture_13_collection_api.AbstractTestUtil;
import com.malex.lecture_13_collection_api.TestNameAnnotation;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample extends AbstractTestUtil {

  @TestNameAnnotation("Add custom class to PriorityQueue")
  @Override
  public void simpleTest(String description) {
    Queue<Person> queue = new PriorityQueue<>();
    queue.add(new Person(2, "Alex"));
    queue.add(new Person(1, "Max"));
    queue.add(new Person(14, "Anna"));
    print(queue);

    Person person = queue.peek();
    assertNotNull(person);
    assertEquals(1, person.id());
  }

  @TestNameAnnotation("Custom comparator for class field")
  @Override
  public void baseFunctionalityTest(String description) {
    var comparator = Comparator.<Person, String>comparing(person -> person.name);
    Queue<Person> queue = new PriorityQueue<>(comparator);
    queue.add(new Person(21, "Alex"));
    queue.add(new Person(2, "Max"));
    queue.add(new Person(34, "Ivan"));

    assertEquals("Alex", Objects.requireNonNull(queue.poll()).name);
    assertEquals("Ivan", Objects.requireNonNull(queue.poll()).name);
    assertEquals("Max", Objects.requireNonNull(queue.peek()).name);
  }

  @Override
  public void additionalFunctionalityTest(String description) {}

  private record Person(int id, String name) implements Comparable<Person> {
    @Override
    public int compareTo(Person person) {
      return Integer.compare(this.id, person.id);
    }

    @Override
    public String toString() {
      return String.join(" ", "Person [id:" + this.id, ", name:", this.name + "]");
    }
  }
}
