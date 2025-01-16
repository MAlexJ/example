package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.collect.collectors.toCollection;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class ToCollection_method extends AbstractUtils {

  @Test
  public void toCollection_LinkedList() {
    LinkedList<Integer> linkedList =
        Stream.of(1, 2, 3, 4, 5).collect(Collectors.toCollection(LinkedList::new));
    println("class:", linkedList.getClass().getName());
    println("list:", linkedList);
  }

  @Test
  public void toCollection_ArrayList() {
    ArrayList<Integer> arrayList =
        Stream.of(1, 2, 3, 4, 5).collect(Collectors.toCollection(ArrayList::new));
    println("class:", arrayList.getClass().getName());
    println("list:", arrayList);
  }

  @Test
  public void toCollection_HashSet() {
    HashSet<Integer> hashSet =
        Stream.of(1, 2, 3, 4, 5).collect(Collectors.toCollection(HashSet::new));
    println("class:", hashSet.getClass().getName());
    println("list:", hashSet);
  }

  @Test
  public void toCollection_Stack() {
    var stack = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toCollection(Stack::new));
    println("class:", stack.getClass().getName());
    println("list:", stack);
  }
}
