package com.malex.lecture_4_algorithms.round_robin;

import com.malex.utils.AbstractUtils;
import java.util.List;
import org.junit.Test;

public class TesApp extends AbstractUtils {

  @Test
  public void run() {
    var roundRobin = new RoundRobin<>(List.of(1, 2, 3, 4));

    shutdownThread(5000);

    var iterator = roundRobin.iterator();
    while (iterator.hasNext()) {
      println(iterator.next());
      sleepInMillis(200);
    }
  }
}
