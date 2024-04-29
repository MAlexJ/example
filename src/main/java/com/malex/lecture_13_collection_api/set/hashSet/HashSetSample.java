package com.malex.lecture_13_collection_api.set.hashSet;

import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.list.AbstractBase;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;

public class HashSetSample extends AbstractBase {

  @Test
  public void test() {
    HashSet<String> hashSet = new HashSet<>();
    boolean added = hashSet.add("Elem");
    assertTrue(added);

    boolean addAll = hashSet.addAll(List.of("A", "B", "C"));
    assertTrue(addAll);
  }
}
