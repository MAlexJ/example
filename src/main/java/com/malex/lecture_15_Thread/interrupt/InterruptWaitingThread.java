package com.malex.lecture_15_Thread.interrupt;

import com.malex.utils.AbstractUtils;
import lombok.Getter;
import org.junit.Test;

public class InterruptWaitingThread extends AbstractUtils {

    @Test
    public void test() {
        var monitor = new Monitor();
        var thread = new Thread(() -> {
            println("start", Thread.currentThread().getName(), "state:", Thread.currentThread().getState());
            monitor.setValue(1);
            println("end", Thread.currentThread().getName(), "state:", Thread.currentThread().getState());
        });
        thread.start();
        thread.interrupt();
    }

    @Getter
    private static class Monitor extends AbstractUtils {
        private Integer val;

        public synchronized void setValue(int val) {
            this.val = val;
            try {
                println("middle", Thread.currentThread().getName(), "state:", Thread.currentThread().getState());
                wait();
            } catch (InterruptedException e) {
                println("error", Thread.currentThread().getName(), "state:", Thread.currentThread().getState());
                throw new RuntimeException(e);
            }
        }
    }
}
