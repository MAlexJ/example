package com.malex.lecture_15_Lambda.consumer;

import com.malex.utils.AbstractUtils;
import java.util.List;
import java.util.function.Consumer;
import org.junit.Test;

/** interface Iterable -> default void forEach ( Consumer<? super T> action ) */
public class ConsumerIterableForeach extends AbstractUtils {

  @Test
  public void runIterator() {
    var list = List.of("Java", "JavaScript", "Python");
    Consumer<String> printConsumer = this::println;
    list.forEach(printConsumer);
  }
}
