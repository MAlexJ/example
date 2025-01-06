package com.malex.lecture_15_Thread.example_14_thread;

import org.junit.Test;

public class IncorrectProgram extends AbstractProgram {

  @Test
  public void test() throws InterruptedException {

    Thread t1 =
        new Thread(
            () -> {
              int count = (int) firstList.stream().filter(n -> n % 2 == 0).count();
              int doSomething = doSomething();
              println("count: " + count + ", doSomething=" + doSomething);
              result.add(count);
            });

    Thread t2 =
        new Thread(
            () -> {
              int max = secondList.stream().max(Integer::compare).orElse(0);
              int doSomething = doSomething();
              println("max: " + max + ", doSomething=" + doSomething);
              result.add(max);
            });

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    println(result);
  }

  private static int doSomething() {
    int num = 0;
    for (int i = 0; i < 999999999; i++) {
      num += i;
    }
    return num;
  }
}
