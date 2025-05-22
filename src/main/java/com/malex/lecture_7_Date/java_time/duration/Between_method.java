package com.malex.lecture_7_Date.java_time.duration;

import com.malex.utils.AbstractUtils;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class Between_method extends AbstractUtils {
  @Test
  public void between() throws InterruptedException {

    Instant start = Instant.now();

    TimeUnit.SECONDS.sleep(1);

    Instant end = Instant.now();

    Duration elapsed = Duration.between(start, end);
    println("Elapsed time: " + elapsed.toMillis() + " ms");
  }
}
