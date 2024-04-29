package com.malex.lecture_13_collection_api.set.treeSet;

import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.list.AbstractBase;
import java.util.List;
import java.util.TreeSet;
import org.junit.Test;

public class TreeSetSample extends AbstractBase {

  @Test
  public void test() {
    TreeSet<String> treeSet = new TreeSet<>();
    boolean added = treeSet.add("A");
    assertTrue(added);

    boolean addAll = treeSet.addAll(List.of("C", "D"));
    assertTrue(addAll);

    treeSet.addFirst("First");
    treeSet.addLast("Last");
  }
}
