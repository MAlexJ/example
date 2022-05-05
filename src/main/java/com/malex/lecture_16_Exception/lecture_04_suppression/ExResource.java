package com.malex.lecture_16_Exception.lecture_04_suppression;

import lombok.extern.java.Log;

@Log
public class ExResource implements AutoCloseable {

    private final String str;

    public ExResource(String str) {
        this.str = str;
    }

    public void calc(int a, int b) {
        log.info("a / b = " + a / b);
    }

    @Override
    public void close() {
        // Failed to close the resource correctly.
        throw new RuntimeException(str);
    }
}
