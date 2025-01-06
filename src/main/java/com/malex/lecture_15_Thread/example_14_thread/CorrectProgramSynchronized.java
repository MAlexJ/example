package com.malex.lecture_15_Thread.example_14_thread;

import org.junit.Test;

public class CorrectProgramSynchronized extends AbstractProgram {

  @Test
  public void test() throws InterruptedException {

    Thread t1 =
        new Thread(
            () -> {
              int count = (int) firstList.stream().filter(n -> n % 2 == 0).count();
              synchronized (result) {
                println("count: " + count + ", doSomething()=" + doSomething());
                result.add(count);
              }
            });

    Thread t2 =
        new Thread(
            () -> {
              int max = secondList.stream().max(Integer::compare).orElse(0);
              synchronized (result) {
                println("max: " + max + ", doSomething() =" + doSomething());
                result.add(max);
              }
            });

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    println(result);
  }

  private static int doSomething() {
    int num = 0;
    for (int i = 0; i < 10000000; i++) {
      num += i;
    }
    return num;
  }

  private void run() {
    int count = (int) firstList.stream().filter(n -> n % 2 == 0).count();
    synchronized (result) {
      println("count: " + count + ", doSomething()=" + doSomething());
      result.add(count);
    }
  }
}
