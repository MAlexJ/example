package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.average;

import com.malex.utils.AbstractUtils;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.junit.Test;

public class Average_method extends AbstractUtils {

  /*
   * IntStream - a sequence of primitive int-valued elements
   */
  @Test
  public void averageIntStream() {
    var averageOptionalDouble = IntStream.of(1, 2, 3).average();
    println("is present:", averageOptionalDouble.isPresent());
    print("average:", averageOptionalDouble);
  }

  /*
   * LongStream - a sequence of primitive long-valued elements
   */
  @Test
  public void averageLongStream() {
    var averageOptionalDouble = LongStream.of(1, 2, 3).average();
    print("average:", averageOptionalDouble);
  }

  /*
   * DoubleStream - sequence of primitive double-valued elements
   */
  @Test
  public void averageDoubleStream() {
    var averageOptionalDouble = DoubleStream.of(1.0, 2.23, 3.333).average();
    print("average:", averageOptionalDouble);
  }
}
