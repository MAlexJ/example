package com.malex.lecture_15_Lambda_Functional_Interface.bi_consumer;

import com.malex.utils.AbstractUtils;
import java.util.function.BiConsumer;
import org.junit.Test;

/*
* public interface BiConsumer<T, U>
*
* Represents an operation that accepts two input arguments and returns no result.
* This is the two-arity specialization of Consumer.
* Unlike most other functional interfaces, BiConsumer is expected to operate via side-effects.
*
*  Type parameters:
      <T> – the type of the first argument to the operation
      <U> – the type of the second argument to the operation
*/
public class BiConsumer_sample extends AbstractUtils {

  @Test
  public void test() {
    BiConsumer<String, Integer> biConsumer =
        (a, b) -> {
          println("a:", a);
          println("b:", b);
        };

    biConsumer.accept("hello!", 3);
  }
}
