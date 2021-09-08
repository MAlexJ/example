package com.malex.lecture_15_Thread.example_02_synchronized;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class ThreadSaveCounterSample {
    @SneakyThrows
    public static void main(String[] args) {
        ThreadSaveCounterSample sample = new ThreadSaveCounterSample();
        sample.runTest();
    }

    @SneakyThrows
    public void runTest() {
        Container container = new Container();
        Runnable foo = () -> {
            for (int i = 0; i < 10000000; i++) {
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

        log.info("result : " + container.size());
        while (container.size() < 100000000) {     // Todo >> infinity loop!!!!
        }
        log.info("Finished!");
    }

    @Getter
    class Container {
        private final List<String> list = new ArrayList<>();

        synchronized void addEntry(String s) {
            list.add(s);
        }

        int size() {  // todo <<< need synchronized
            return list.size();
        }
    }
}
