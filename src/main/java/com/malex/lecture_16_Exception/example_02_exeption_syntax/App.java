package com.malex.lecture_16_Exception.example_02_exeption_syntax;

import lombok.extern.java.Log;

import java.io.EOFException;
import java.io.FileNotFoundException;

/**
 * Created by Alex on 4/18/2015.
 */
@Log
public class App {

    public static void main(String[] args) throws Exception {
        f0();
        f1();
        f2();
    }

    private static void f0() throws EOFException {
        // do something
        log.info("f0");
    }

    private static void f1() throws FileNotFoundException {
        //do something
        log.info("f1");
    }

    private static void f2() throws InterruptedException {
        //do something
        log.info("f2");
    }
}
