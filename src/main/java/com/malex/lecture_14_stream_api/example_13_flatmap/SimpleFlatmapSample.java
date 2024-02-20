package com.malex.lecture_14_stream_api.example_13_flatmap;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.List;
import org.junit.Test;

public class SimpleFlatmapSample extends AbstractUtils {

  @Test
  public void run() {
    var numbers = List.of(List.of(1, 2), List.of(3), List.of(4, 5, 6, 7));
    var resultFlatmap =
        numbers.stream() //
            .flatMap(
                list -> {
                  println("element:", list);
                  return list.stream();
                }) //
            .toList();

    println("result:", resultFlatmap);
    assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), resultFlatmap);
  }
}
