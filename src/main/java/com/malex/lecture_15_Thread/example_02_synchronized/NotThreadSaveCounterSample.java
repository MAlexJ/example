package com.malex.lecture_15_Thread.example_02_synchronized;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Issue in synchronized void addEntry(String s) method
 *
 * Exception in thread "Thread-0" Exception in thread "Thread-4" java.lang.ArrayIndexOutOfBoundsException: 15
 * 	at java.util.ArrayList.add(ArrayList.java:465)
 * 	at com.malex.lecture_15_Thread.example_02_synchronized.CounterSample$Container.addEntry(CounterSample.java:40)
 * 	at com.malex.lecture_15_Thread.example_02_synchronized.CounterSample.lambda$main$0(CounterSample.java:18)
 * 	at java.lang.Thread.run(Thread.java:748)
 * java.lang.ArrayIndexOutOfBoundsException: 823
 * 	at java.util.ArrayList.add(ArrayList.java:465)
 * 	at com.malex.lecture_15_Thread.example_02_synchronized.CounterSample$Container.addEntry(CounterSample.java:40)
 * 	at com.malex.lecture_15_Thread.example_02_synchronized.CounterSample.lambda$main$0(CounterSample.java:18)
 * 	at java.lang.Thread.run(Thread.java:748)
 *  ........................................
 */
@Log4j
public class NotThreadSaveCounterSample {

    @SneakyThrows
    public static void main(String[] args) {
        Runnable foo = () -> {
            Container container = new Container();
            for (int i = 0; i < 100000; i++) {
                container.addEntry("foo");
            }
        };

        List<Thread> threads = new ArrayList<>();
        for (long count = 10; count > 0; count--) {
            Thread thread = new Thread(foo);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }
        log.info(Container.list.size());
    }

    @Getter
    static class Container {
        static final List<String> list = new ArrayList<>();
        synchronized void addEntry(String s) {
            list.add(s);
        }
    }
}