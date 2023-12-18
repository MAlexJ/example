package com.malex.lecture_15_Thread.synchronize.not_thread_save;

import lombok.SneakyThrows;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class ObjectValueWithoutSynch extends AbstractObjectValue {


    @Test
    @SneakyThrows
    public void runTest() {
        var objectValue = new ObjectValue();

        int numberOfThead = 5;
        Thread t1 = new Thread(objectValue::incrementCount);
        Thread t2 = new Thread(objectValue::incrementCount);
        Thread t3 = new Thread(objectValue::incrementCount);
        Thread t4 = new Thread(objectValue::incrementCount);
        Thread t5 = new Thread(objectValue::incrementCount);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        println("Count result:", objectValue.getCount());
        assertNotEquals(TOTAL_INCREMENT_COUNT * numberOfThead, objectValue.getCount());
    }
}