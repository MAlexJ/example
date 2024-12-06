package com.malex.lecture_16_Exception.rules;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/** Created by root on 27.06.15. */
public class ExceptionInOneThreadDoesNotInterruptMainThread extends AbstractUtils {

  @Test
  public void test() throws Exception {



    var thread =
        new Thread(
            () -> {
              for (int i = 0; i < 10; i++) {
                println(" ->>>> j=", i, "", Thread.currentThread().getName());
                if (i == 5) {
                  throw new RuntimeException();
                }
                try {
                  Thread.sleep(300);
                } catch (InterruptedException e) {
                  println(e.toString());
                }
              }
            });

    thread.start();

    for (int i = 0; i < 10; i++) {
      println(" * i=", i, "", Thread.currentThread().getName());
      Thread.sleep(300);
    }

    println("Exit main");
  }
}
