package com.malex.lecture_15_Thread.example_14_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;

public class CorrectProgramLock extends AbstractProgram {

  @Test
  public void test() throws InterruptedException {
    Lock lock = new ReentrantLock();

    Thread t1 =
        new Thread(
            () -> {
              int count = (int) firstList.stream().filter(n -> n % 2 == 0).count();
              // <<<<<<  lock  <<<<<<<<<<<
              lock.lock();
              println("count: " + count + ", doSomething()=" + doSomething());
              result.add(count);
              lock.unlock();
              // <<<<<<<  unlock  <<<<<<<<<<
            });

    Thread t2 =
        new Thread(
            () -> {
              int max = secondList.stream().max(Integer::compare).orElse(0);
              // <<<<<<<  lock  <<<<<<<<<<
              lock.lock();
              println("max: " + max + ", doSomething() =" + doSomething());
              result.add(max);
              lock.unlock();
              // <<<<<<<  unlock  <<<<<<<<<<
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
}
