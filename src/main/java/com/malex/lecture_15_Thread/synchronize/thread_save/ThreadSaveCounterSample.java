package com.malex.lecture_15_Thread.synchronize.thread_save;

import com.malex.utils.AbstractUtils;
import com.malex.utils.SampleException;
import lombok.Getter;
import lombok.extern.java.Log;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;

@Log
public class ThreadSaveCounterSample extends AbstractUtils {

    private static final int TEN_NUMBERS = 10;
    private static final int TEN_MILLION_NUMBERS = 10000000;

    @Test
    public void testCounter() {
        // one class as monitor
        var container = new Container();
        var threads = IntStream.range(0, TEN_NUMBERS) //
                .mapToObj(i -> //
                        new Thread(() -> IntStream.range(0, TEN_MILLION_NUMBERS).forEach(container::addEntry)) //
                )//
                .toList();
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new SampleException(e);
            }
        });

        // init params before tests
        var listOfNumbers = container.getList();
        int size = listOfNumbers.size();

        // test.1 - check size
        println("result : " + size);
        assertEquals(TEN_MILLION_NUMBERS * TEN_NUMBERS, size);

        // test.2 - first ten numbers should be zero
        listOfNumbers.stream().sorted() //
                .limit(TEN_NUMBERS) //
                .forEach(num -> assertEquals(0, num.intValue()));

        // test.3 - number unique numbers in list
        var uniqueNumbers = new HashSet<>(listOfNumbers);
        assertEquals(TEN_MILLION_NUMBERS, uniqueNumbers.size());
    }

    @Getter
    public static class Container {

        private final List<Integer> list = new ArrayList<>();

        /**
         * synchronized method
         */
        public synchronized void addEntry(Integer num) {
            list.add(num);
        }

        public int getListSize() {
            return list.size();
        }
    }
}