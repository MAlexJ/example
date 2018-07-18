package com.malex.lecture_15_Thread.example_14_thread;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CorrectProgramLock
{
    public static void main(String[] args) throws InterruptedException
    {
        Lock lock = new ReentrantLock();

        List<Integer> firstList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> secondList = Lists.newArrayList(12, 32, 53, 75, 34, 67);

        List<Integer> result = new ArrayList<>();

        Thread t1 = new Thread(() ->
        {
            int count = (int) firstList.stream().filter(n -> n % 2 == 0).count();
            // <<<<<<  lock  <<<<<<<<<<<
            lock.lock();
            System.out.println("count: " + count + ", doSomething()=" + doSomething());
            result.add(count);
            lock.unlock();
            // <<<<<<<  unlock  <<<<<<<<<<
        });

        Thread t2 = new Thread(() ->
        {
            int max = secondList.stream().max(Integer::compare).orElse(0);
            // <<<<<<<  lock  <<<<<<<<<<
            lock.lock();
            System.out.println("max: " + max + ", doSomething() =" + doSomething());
            result.add(max);
            lock.unlock();
            // <<<<<<<  unlock  <<<<<<<<<<
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(result);
    }

    private static int doSomething()
    {
        int num = 0;
        for (int i = 0; i < 10000000; i++)
        {
            num += i;
        }
        return num;
    }
}
