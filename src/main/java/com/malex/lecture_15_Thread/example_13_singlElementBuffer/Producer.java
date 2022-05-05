package com.malex.lecture_15_Thread.example_13_singlElementBuffer;

import lombok.extern.java.Log;

@Log
public class Producer implements Runnable {

    private long productionTime;
    private Integer startValue;
    private final SingleElementBuffer buffer;

    public Producer(SingleElementBuffer buffer, Integer startValue, long productionTime) {
        this.startValue = startValue;
        this.buffer = buffer;
        this.productionTime = productionTime;
    }

    @Override
    public void run() {
        while (true) {
            try {
                log.info(">>> Producer: " + Thread.currentThread().getName() + ", produce new value: " + startValue);
                buffer.put(startValue);
                Thread.sleep(productionTime);
                startValue++;
            } catch (InterruptedException e) {
                log.severe("Producer error" + e);
                // Restore interrupted state.
                Thread.currentThread().interrupt();
            }
        }
    }
}
