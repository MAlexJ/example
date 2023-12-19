package com.malex.lecture_15_Thread.wait_notify;


import com.malex.utils.AbstractUtils;
import com.malex.utils.SampleException;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.IntSupplier;

public class WaitAndNotify extends AbstractUtils {

    private final Random random;

    public WaitAndNotify() {
        random = new Random();
    }

    @Test
    @SneakyThrows
    public void testWait() {
        // init object
        var integerManager = new IntegerManager();

        // first thread
        var firstThread = initializationThreadToReadVariable(integerManager::getValue);

        // second thread
        var secondThread = initializationThreadToWriteVariable(integerManager, random.nextInt());

        // start thread with delay
        firstThread.start();
        TimeUnit.MILLISECONDS.sleep(2000);
        secondThread.start();

        // join to main
        firstThread.join();
        secondThread.join();
    }

    @Test
    @SneakyThrows
    public void testWaitWithTimeoutMillis() {
        // init object
        var integerManager = new IntegerManager();
        long timout = 2000;

        // first thread
        var firstThread = initializationThreadToReadVariable(() -> integerManager.getValue(timout));

        // start thread with delay
        firstThread.start();

        // join to main
        firstThread.join();
    }

    private Thread initializationThreadToWriteVariable(IntegerManager manager, int value) {
        return new Thread(() -> {
            println("  >>> Write variable, thread:", Thread.currentThread().getName(), "set new value:", value);
            manager.setValue(value);
        });
    }

    private Thread initializationThreadToReadVariable(IntSupplier supplier) {
        return new Thread(() -> {
            println("  <<< Read variable, thread:", Thread.currentThread().getName(), "..............");
            int value = supplier.getAsInt();
            println("  <<< Read variable, thread:", Thread.currentThread().getName(), "value:", value);
        });
    }


    public static class IntegerManager extends AbstractUtils {
        private Integer value;

        public synchronized int getValue() {
            println(Thread.currentThread().getName(), "Trying to get value ...");
            if (value == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    println(Thread.currentThread().getName(), "Thread:", e.getMessage());
                    throw new SampleException(e);
                }
            }
            return value;
        }

        public synchronized int getValue(long millis) {
            println(Thread.currentThread().getName(), "Trying to get value ...");
            if (value == null) {
                try {
                    wait(millis);
                } catch (InterruptedException e) {
                    println(Thread.currentThread().getName(), "Thread:", e.getMessage());
                    throw new SampleException(e);
                }
            }
            return Optional.ofNullable(value).orElse(-1);
        }

        public synchronized void setValue(int value) {
            println(Thread.currentThread().getName(), "Insert new value:", value);
            this.value = value;
            println(Thread.currentThread().getName(), "Value is added");
            notifyAll();
        }
    }

}