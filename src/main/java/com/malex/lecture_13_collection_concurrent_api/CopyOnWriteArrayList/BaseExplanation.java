package com.malex.lecture_13_collection_concurrent_api.CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.junit.Test;

public class BaseExplanation extends AbstractBase {

  /** ArrayList >> Exception >> ConcurrentModificationException */
  @Test
  public void baseExplanation_ConcurrentModificationException() {
    // given
    var list = new ArrayList<>(PREPARED_NAMES);
    println(list);

    // when
    removeAndAddElementTOList(list);
  }

  @Test
  @SneakyThrows
  public void baseExplanationConcurrent() {
    // given
    var list = new CopyOnWriteArrayList<>(PREPARED_NAMES);
    println(list);

    // when
    removeAndAddElementTOList(list);
  }

  public void removeAndAddElementTOList(List<String> list) {
    // when
    var first =
        new Thread(
            () -> {
              Iterator<String> iterator = list.iterator();
              while (iterator.hasNext()) {
                try {
                  TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                  throw new RuntimeException(e);
                }
                /* ConcurrentModificationException */
                println("iteration:", iterator.next());
              }
            });
    var second =
        new Thread(
            () -> {
              try {
                TimeUnit.SECONDS.sleep(2);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              list.removeFirst();
              list.add("New");
            });

    // then
    first.start();
    second.start();
    try {
      first.join();
      second.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    println(list);
  }
}
