package com.malex.lecture_13_collection_api.list.arraylist;

import static junit.framework.TestCase.*;

import java.util.ArrayList;
import java.util.List;

import com.malex.lecture_13_collection_api.list.AbstractBase;
import org.junit.Test;

/**
 * Remove elements form ArrayList
 *
 * <p>methods: <br>
 * 1. boolean remove(Object o) <br>
 * 2. E remove(int index) <br>
 * 3. E removeFirst() <br>
 * 4. E removeLast() <br>
 * 5. boolean removeAll(Collection<?> c)
 *
 * <p>Link to tutorial - <a
 * href="https://javarush.com/groups/posts/1935-udalenie-ehlementa-iz-spiska-arraylist">Remove
 * element form ArrayList</a>
 */
public class RemoveElementFromList extends AbstractBase {

  /** Removes the first occurrence of the specified element from this list, if it is present. */
  @Test
  public void removeByObject() {
    // given
    var cats = new ArrayList<>(PREPARED_CATS);
    assertEquals(5, cats.size());

    // when
    boolean removed = cats.remove(new Cat(6, "Cat"));

    // then
    assertTrue(removed);
    assertEquals(4, cats.size());
  }

  /** Removes the first occurrence of the specified element from this list, if it is present. */
  @Test
  public void removeByObjectRemovesFirstOccurrence() {
    // given
    var cats = new ArrayList<>(PREPARED_CATS);
    assertEquals(5, cats.size());
    // and
    // add exist cat to list
    Cat firstCat = cats.getFirst();
    boolean add = cats.add(firstCat);
    assertTrue(add);
    assertEquals(6, cats.size());

    // when
    //  Removes the first occurrence of the specified element
    boolean removed = cats.remove(firstCat);

    // then
    assertTrue(removed);
    assertEquals(5, cats.size());
    // and
    assertTrue(cats.contains(firstCat));
  }

  /** Removes the first occurrence of the specified element from this list, if it is present. */
  @Test
  public void removeByIndex() {
    // given
    var cats = new ArrayList<>(PREPARED_CATS);
    assertEquals(5, cats.size());

    // when
    Cat cat = new Cat(6, "Cat");
    int catIndex = cats.indexOf(cat);

    Cat removedCat = cats.remove(catIndex);

    // then
    assertNotNull(removedCat);
    assertEquals(cat, removedCat);
    assertEquals(4, cats.size());
  }

  /**
   * Since Java21 <br>
   * </> Removes and returns the first/last element of this collection (optional operation).
   */
  @Test
  public void removeFirstOrLast() {
    // given
    var cats = new ArrayList<>(PREPARED_CATS);
    assertEquals(5, cats.size());
    // and
    Cat first = cats.get(0);
    Cat last = cats.get(cats.size() - 1);

    // when
    Cat removedFirst = cats.removeFirst();
    Cat removedLast = cats.removeLast();

    // then
    assertEquals(3, cats.size());
    assertEquals(first, removedFirst);
    assertEquals(last, removedLast);
  }

  /** Removes from this list all of its elements that are contained in the specified collection. */
  @Test
  public void removeAll() {
    // given
    var cats = new ArrayList<>(PREPARED_CATS);
    assertEquals(5, cats.size());

    Cat firstCat = new Cat(1, "Stephan");
    Cat nextCat = new Cat(4, "May");

    cats.removeAll(List.of(firstCat, nextCat));
    assertEquals(3, cats.size());
  }

  /** Removes all elements of this collection that satisfy the given predicate. */
  @Test
  public void removeIf() {
    // given
    var cats = new ArrayList<>(PREPARED_CATS);
    assertEquals(5, cats.size());
    // and
    Cat mayCat = new Cat(4, "May");

    // when
    boolean removed = cats.removeIf(cat -> cat.equals(mayCat));

    // then
    assertTrue(removed);
    assertEquals(4, cats.size());
  }
}
