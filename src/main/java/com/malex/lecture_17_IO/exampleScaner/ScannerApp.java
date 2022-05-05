package com.malex.lecture_17_IO.exampleScaner;

import lombok.extern.java.Log;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Log
public class ScannerApp {

    /**
     * encoding type for scanner
     */
    private static final String ENCODING_TYPE = StandardCharsets.UTF_8.name();

    public static void main(String[] args) {

        log.info("Enter an integer: ");
        Scanner scanner = new Scanner(System.in, ENCODING_TYPE);
        int i;

        // returns true if an integer can be read from the input stream
        if (scanner.hasNextInt()) {
            // reads an integer from the input stream and stores it in a variable
            i = scanner.nextInt();
            log.info("> " + i * 2);
        } else {
            log.info("You did not enter an integer!");
        }
    }
}
