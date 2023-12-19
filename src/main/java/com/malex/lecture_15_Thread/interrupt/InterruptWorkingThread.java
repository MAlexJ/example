package com.malex.lecture_15_Thread.interrupt;

import com.malex.utils.AbstractUtils;
import lombok.SneakyThrows;
import org.junit.Test;

public class InterruptWorkingThread extends AbstractUtils {

    @Test
    public void testThreadContinueWork() {
        var thread = new Thread(() -> {
            long num = 0;
            println("num =", num, ", thread isInterrupted:", Thread.currentThread().isInterrupted());
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                for (int j = 0; j < 4; j++) {
                    if (num - Integer.MAX_VALUE == 0) {
                        println("num =", num, ", thread isInterrupted:", Thread.currentThread().isInterrupted());
                    }
                    num++;
                }
            }
            println("result", num);
        });

        thread.start();
        sleepInMillis(100);
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @SneakyThrows
    public void testThreadInterrupted() {
        var thread = new Thread(() -> {
            int num = 0;
            while (!Thread.currentThread().isInterrupted()) {
                num++;
            }
            println("Result:", num);
        });
        thread.start();
        sleepInMillis(50);
        thread.interrupt();
        thread.join();
    }
}
