package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.collect.collectors.toUnmodifiableSet;

import com.malex.utils.AbstractUtils;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class ToUnmodifiableSet_method extends AbstractUtils {

  @Test
  public void test() {
    Set<Integer> set = Stream.of(1, 2, 3, 4).collect(Collectors.toUnmodifiableSet());
    println("class:", set.getClass().getName());
    println("list:", set);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testException() {
    Set<Integer> set = Stream.of(1, 2, 3, 4).collect(Collectors.toUnmodifiableSet());
   try{
     set.add(6); // note: Immutable object is modified => UnsupportedOperationException
   }
   catch (UnsupportedOperationException e){
     printError(e.toString());
     throw e;
   }
  }
}
