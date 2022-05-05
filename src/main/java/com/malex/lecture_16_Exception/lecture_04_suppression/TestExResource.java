package com.malex.lecture_16_Exception.lecture_04_suppression;

import lombok.extern.java.Log;

@Log
public class TestExResource {

    public static void main(String[] args) {

        try (ExResource ex0 = new ExResource("0"); ExResource ex1 = new ExResource("1"); ExResource ex2 = new ExResource("2"); ExResource ex3 = new ExResource("3")) {
            ex0.calc(22, 2);
            ex1.calc(22, 2);
            ex2.calc(22, 2);
            ex3.calc(22, 2);

            throw new RuntimeException("try");

        } catch (Exception e) {
            log.severe(e.toString());
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable iter : suppressed) {
                log.severe(iter.toString());
            }
        }
    }
}
