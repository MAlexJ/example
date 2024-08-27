package com.malex.lecture_15_Thread.old_new_thread;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.malex.utils.AbstractUtils;

public class StartThread extends AbstractUtils {

    @Test
    public void startThread() throws Exception {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            print("sleep");
        });

        thread.run();
        thread.join();
        print("join");
    }
}
