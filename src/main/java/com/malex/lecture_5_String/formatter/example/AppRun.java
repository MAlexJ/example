package com.malex.lecture_5_String.formatter.example;

import lombok.extern.java.Log;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Formatter;
import java.util.Optional;
import java.util.Scanner;

@Log
public class AppRun {

    private static final String SOURCE_FILE;
    private static final String PATH_SOURCE = "format.txt";

    private static final String ERROR_MESSAGE = "File not found: %s";

    static {
        ClassLoader context = Thread.currentThread().getContextClassLoader();
        URL sourceRes = Optional.ofNullable(context.getResource(PATH_SOURCE)).orElseThrow(() -> {
            String errorMessage = String.format(ERROR_MESSAGE, PATH_SOURCE);
            log.severe(errorMessage);
            return new IllegalArgumentException(errorMessage);
        });
        SOURCE_FILE = sourceRes.getFile();
    }

    /**
     * //%s - String //%d - integer type number //%f - double type number // /n - new line
     */
    public static void main(String[] args) {

        try (Formatter formatter = new Formatter(SOURCE_FILE); Scanner scanner = new Scanner(System.in)) {

            log.info("Write to file -> ");

            String line = scanner.nextLine();
            formatter.format(line, "Alex");

            log.info(">>> exit ");
        } catch (FileNotFoundException ex) {
            log.severe(ex.getMessage());
        }
    }
}
