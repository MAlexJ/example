package com.malex.lecture_13_collection_api.algoritms.contains;

import java.util.List;
import java.util.Objects;

public class ListContains {

  // contains only one element
  public static <E> boolean containsOnlyOne(List<E> list, E element) {
    Objects.requireNonNull(list, "List cannot be null");
    Objects.requireNonNull(element, "The element cannot be null");
    //  WTF: boolean contains = list.contains(element);
    return list.stream().anyMatch(e -> e.equals(element));
  }

  // contains at least one

  // contains all

  // no match
}
