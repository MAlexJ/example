package com.malex.lecture_15_Thread.illegal_monitor_exception;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class WaitIllegalMonitorException extends AbstractUtils {
    @Test
    public void testIllegalMonitorException() {
        Thread thread = new Thread(() -> {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IllegalMonitorStateException ex) {
                println(ex.getMessage());
            }
        });
        thread.start();

        // interrupt thread
        thread.interrupt();
    }
}