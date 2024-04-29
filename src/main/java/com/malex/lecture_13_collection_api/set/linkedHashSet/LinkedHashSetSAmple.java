package com.malex.lecture_13_collection_api.set.linkedHashSet;

import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.list.AbstractBase;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.Test;

public class LinkedHashSetSAmple extends AbstractBase {

  @Test
  public void test() {
    LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
    boolean added = linkedHashSet.add("elem");
    assertTrue(added);

    boolean addAll = linkedHashSet.addAll(List.of("A", "B", "C", "D"));
    assertTrue(addAll);

    linkedHashSet.addFirst("First");
    linkedHashSet.addLast("Last");
  }
}
