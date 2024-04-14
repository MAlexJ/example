package com.malex.lecture_13_collection_api.list.arraylist;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AddElementToList extends AbstractBase {

  /**
   * Appends the specified element to the end of this list.
   *
   * <ul>
   *   <li>public boolean add(E e) { ... }
   * </ul>
   */
  @Test
  public void addElement() {
    // given
    var dogs = new ArrayList<>(PREPARED_DOGS);
    assertEquals(5, dogs.size());
    // and
    var dog = new Dog(99999, "BigCat");

    // when >> Appends the specified element to the end of this list.
    boolean added = dogs.add(dog);
    assertTrue(added);
    assertTrue(dogs.contains(dog));

    // then
    assertEquals(6, dogs.size());
    // test: Appends the specified element to the end of this list.
    assertEquals(dog, dogs.getLast());
  }

  /**
   * Adds an element as first/last element of this collection
   *
   * <ul>
   *   <li>public void addFirst(E element) {....}
   *   <li>public void addLast(E element) {....}
   * </ul>
   */
  @Test
  public void addElementFirstOrLast() {
    // given
    var dogs = new ArrayList<>(PREPARED_DOGS);
    assertEquals(5, dogs.size());
    // and
    var first = new Dog(99999, "First");
    var last = new Dog(-454545, "Last");

    // when
    dogs.addFirst(first);
    dogs.addLast(last);

    // then
    assertEquals(7, dogs.size());
    // and
    assertEquals(first, dogs.getFirst());
    assertEquals(last, dogs.getLast());
  }

  /**
   * Inserts the specified element at the specified position in this list. Shifts the element
   * currently at that position (if any) and any subsequent elements to the right
   */
  @Test
  public void addElementUsingIndexPosition() {
    // given
    var dogs = new ArrayList<>(PREPARED_DOGS);
    assertEquals(5, dogs.size());
    // and
    var dog = new Dog(99999, "BigCat");

    dogs.add(1, dog);

    // then
    assertEquals(6, dogs.size());
    // test: Shifts the element currently at that position to the right
    assertEquals(dog, dogs.get(1));
    assertNotEquals(dog, dogs.getFirst());
  }

  /** Appends all elements in the specified collection to the end of this list */
  @Test
  public void addAll() {
    // given
    var dogs = new ArrayList<>(PREPARED_DOGS);
    assertEquals(5, dogs.size());
    // and
    var first = new Dog(99999, "First");
    var last = new Dog(-454545, "Last");

    var newDogs = List.of(first, last);

    // when >> add elements to the end of list
    dogs.addAll(newDogs);

    // then
    assertEquals(7, dogs.size());
    // test: add elements to the end of list
    assertEquals(first, dogs.get(dogs.size() - 2));
    assertEquals(last, dogs.getLast());
  }

  /**
   * Inserts all elements in the specified collection into this list, starting at the specified
   * position. Shifts the element currently at that position
   */
  @Test
  public void addAllUsingIndexPosition() {
    // given
    var dogs = new ArrayList<>(PREPARED_DOGS);
    assertEquals(5, dogs.size());
    // and
    var first = new Dog(99999, "First");
    var last = new Dog(-454545, "Last");
    var third = new Dog(-454545, "Last");

    var newDogs = List.of(first, last, third);

    // when >>
    // Inserts all elements starting at specified position
    // Shifts exist element to the right
    dogs.addAll(0, newDogs);

    // then
    assertEquals(8, dogs.size());
    // test: add elements to the end of list
    assertEquals(first, dogs.getFirst());
  }
}
