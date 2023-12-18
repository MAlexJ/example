package com.malex.lecture_15_Thread.synchronize.not_thread_save;

import com.malex.utils.AbstractUtils;
import com.malex.utils.SampleException;
import lombok.Getter;
import lombok.extern.java.Log;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Issue in synchronized void addEntry(String s) method
 * <p>
 * Exception in thread "Thread-0" Exception in thread "Thread-4" java.lang.ArrayIndexOutOfBoundsException: 15
 * at java.util.ArrayList.add(ArrayList.java:465)
 * at com.malex.lecture_15_Thread.example_02_synchronized.CounterSample$Container.addEntry(CounterSample.java:40)
 * at com.malex.lecture_15_Thread.example_02_synchronized.CounterSample.lambda$main$0(CounterSample.java:18)
 * at java.lang.Thread.run(Thread.java:748)
 * java.lang.ArrayIndexOutOfBoundsException: 823
 * at java.util.ArrayList.add(ArrayList.java:465)
 * at com.malex.lecture_15_Thread.example_02_synchronized.CounterSample$Container.addEntry(CounterSample.java:40)
 * at com.malex.lecture_15_Thread.example_02_synchronized.CounterSample.lambda$main$0(CounterSample.java:18)
 * at java.lang.Thread.run(Thread.java:748)
 * ........................................
 */
@Log
public class NotThreadSaveCounterSample extends AbstractUtils {

    private static final int TEN_NUMBERS = 10;
    private static final int TEN_MILLION_NUMBERS = 10000000;

    @Test
    public void test() {
        // init counter
        var container = new Container();
        Runnable runnable = () -> IntStream.range(0, TEN_MILLION_NUMBERS).forEach(container::addEntry);

        List<Thread> threads = new ArrayList<>();
        for (int count = 0; count < TEN_NUMBERS; count++) {
            Thread thread = new Thread(runnable);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new SampleException(e);
            }
        }

        print(container.getListSize());
        assertNotEquals(TEN_MILLION_NUMBERS * TEN_NUMBERS, container.getListSize());
    }

    @Getter
    public static class Container {

        private final List<Integer> list = new ArrayList<>();

        /**
         * synchronized method
         */
        public void addEntry(Integer num) {
            list.add(num);
        }

        public int getListSize() {
            return list.size();
        }
    }
}
