package com.malex.lecture_13_collection_api.list.diff_array_and_linked;

import static java.util.Arrays.asList;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.junit.Test;

/**
 * Created by Alex on 12.02.2015.
 *
 * <p>Random access in a LinkedList is O(n), while it's O(1) in an ArrayList,
 * https://stackoverflow.com/questions/20869993/why-does-arraylist-implement-randomaccess-interface
 *
 * <p>1. There are two classes which implement RandomAccess Interface. They are: <br>
 * <br>
 * ArrayList (Part of List<I>)<br>
 * Vector (Part of List<I>)<br>
 * <br>
 * 2. The purpose of RandomAccess Interface is to retrieve any random element in the Collection at
 * the same speed. Example: I have a collection of 1 million objects. Implementing RandomAccess
 * interface makes your time to retrieve the 10th element and 17869th element the same. This makes
 * ArrayList and Vector more powerful.<br>
 * <br>
 */
public class DiffBetweenArrayAndLinkedList extends AbstractUtils {

  /*
  ArrayList<> implements RandomAccess
  interface RandomAccess -> Marker interface used by List implementations to indicate that they
  support fast (generally constant time) random access.

  public static <T>
      int binarySearch(List<? extends Comparable<? super T>> list, T key) {
          if (list instanceof RandomAccess || list.size()<BINARYSEARCH_THRESHOLD)
              return Collections.indexedBinarySearch(list, key);
           else
              return Collections.iteratorBinarySearch(list, key);
      }
  */

  /**
   * Time Complexity
   *
   * <p>ArrayList: The ArrayList in Java is backed by an array. Random access takes O(1) time
   *
   * <p>get() – is always a constant time O(1) operation
   */
  @Test
  public void testArrayList() {
    ArrayList<String> list = new ArrayList<>(asList("B", "A", "C", "F", "D"));

    /*
     * ArrayList implemented:
     *
     * public E get(int index) {
     *         rangeCheck(index); // to check for out of bounds index.
     *
     *         return elementData(index); // another method invocation
     *     }
     *
     * E elementData(int index) {
     *         return (E) elementData[index]; // accesses internal array.
     *     }
     *
     * // following is the internal array , used by ArrayList
     * transient Object[] elementData; // non-private to simplify nested class access
     */
    for (int i = 0; i < list.size(); i++) {
      // O(1)
      println(list.get(i));
    }

    // Iterator >> O(N)
    Iterator<String> iter = list.iterator();
    while (iter.hasNext()) {
      println(iter.next());
    }
  }

  /**
   * LinkedList LinkedList is a linear data structure which consists of nodes holding a data field
   * and a reference to another node.
   *
   * <p>get() – searching for an element takes O(n) time.
   */
  @Test
  public void testLinkedList() {
    LinkedList<String> list = new LinkedList<>(asList("B", "A", "C", "F", "D"));

    /*
     * public E get(int index) { checkElementIndex(index); return node(index).item; }
     *
     * Node node(int index) { // assert isElementIndex(index);
     *
     *  if (index < (size >> 1)) {
     *      Node<E> x = first;
     *      for (int i = 0; i < index; i++)
     *          x = x.next;
     *      return x;
     *  } else {
     *      Node<E> x = last;
     *      for (int i = size - 1; i > index; i--)
     *          x = x.prev;
     *      return x;
     *  }
     * }`
     */
    for (int i = 0; i < list.size(); i++) {
      // O(1)
      println(list.get(i));
    }
  }
}
