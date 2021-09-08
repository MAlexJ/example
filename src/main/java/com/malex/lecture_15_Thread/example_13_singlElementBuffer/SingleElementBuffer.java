package com.malex.lecture_15_Thread.example_13_singlElementBuffer;

import lombok.SneakyThrows;

public class SingleElementBuffer {

    private Integer element;

    /**
     * Conclusion:
     * 1. synchronized used for many threads
     * 2. put and get are synchronized, but in not work for producer thread and consumer thread,
     * put and get different synchronize method but for one object
     * 3.
     */
    @SneakyThrows
    synchronized void put(Integer newElement) {  //
        if (element != null) {
            this.wait();
        }
        this.element = newElement;
        this.notifyAll();
    }

    @SneakyThrows
    synchronized Integer get() {
        if (element == null) {
            this.wait();
        }
        Integer result = this.element;
        this.element = null;
        this.notifyAll();
        return result;
    }
}
