package com.malex.lecture_14_stream_api.skip;

import com.malex.utils.AbstractUtils;
import java.util.stream.Stream;
import org.junit.Test;

public class Skip extends AbstractUtils {

  @Test
  public void skip() {
    var list = Stream.of(1, 2, 3, 4, 5, 6, 7).skip(3).peek(this::println).toList();

    println("list:", list);
  }
}
