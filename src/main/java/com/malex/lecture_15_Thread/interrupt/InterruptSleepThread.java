package com.malex.lecture_15_Thread.interrupt;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class InterruptSleepThread extends AbstractUtils {

    @Test
    public void test() {
        var thread = new Thread(() -> {
            println(Thread.currentThread().getName(), "start");
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                println(Thread.currentThread().getName(), "sleep interrupted!");
                throw new RuntimeException(e);
            }
        });
        thread.start();
        thread.interrupt();
    }
}
