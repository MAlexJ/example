package com.malex.lecture_4_algorithms.round_robin;

import java.util.Iterator;
import java.util.List;

/**
 * Not thead save approach Link:
 * https://stackoverflow.com/questions/2041718/round-robin-scheduling-java-iterators/12931655#12931655
 */
public class RoundRobin<T> implements Iterable<T> {

  private final List<T> list;

  public RoundRobin(List<T> list) {
    this.list = list;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {

      private int index = 0;

      @Override
      public boolean hasNext() {
        return true;
      }

      @Override
      public T next() {
        index = index % list.size();
        final T element = list.get(index);
        index++;
        return element;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
}
