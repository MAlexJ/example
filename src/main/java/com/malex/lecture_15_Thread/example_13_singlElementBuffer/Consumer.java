package com.malex.lecture_15_Thread.example_13_singlElementBuffer;

import lombok.extern.java.Log;

@Log
public class Consumer implements Runnable {

    private final SingleElementBuffer buffer;

    Consumer(SingleElementBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            Integer item = buffer.get();
            log.info("  <<< Consumer: " + Thread.currentThread().getName() + ", received item:" + item);
        }
    }
}
