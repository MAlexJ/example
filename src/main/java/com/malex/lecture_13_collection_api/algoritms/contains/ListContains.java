package com.malex.lecture_13_collection_api.algoritms.contains;

import java.util.List;

public class ListContains {

  /*
   * Contains only one element
   */
  public static <E> boolean contains(List<E> list, E element) {
    //  WTF: boolean contains = list.contains(element);
    return list.stream().anyMatch(e -> e.equals(element));
  }

  /*
   * Contains only one
   */
  public static <E> boolean containsOnlyOne(List<E> list, List<E> subList) {
    return true;
  }

  /*
   * Contains at least one
   */
  public static <E> boolean containsAtLeastOne(List<E> list, List<E> subList) {
    return true;
  }

  /*
   * Contains all
   */
  public static <E> boolean containsAll(List<E> list, List<E> subList) {
    return true;
  }

  /*
   * No match
   */
  public static <E> boolean noMatch(List<E> list, List<E> subList) {
    return true;
  }
}
