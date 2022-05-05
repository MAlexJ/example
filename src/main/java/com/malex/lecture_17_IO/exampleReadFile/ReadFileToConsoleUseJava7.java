package com.malex.lecture_17_IO.exampleReadFile;

import lombok.extern.java.Log;

import java.io.*;
import java.net.URL;
import java.util.Objects;

/**
 * JAVA 7 closing resources automatically
 */
@Log
public class ReadFileToConsoleUseJava7 {

    private static final String PATH_SOURCE = "source/source.txt";
    private static final String PATH_DESTINATION = "destination/destination.txt";

    private static final String ERROR_MESSAGE = "File not found: %s";

    private static final String SOURCE_FILE;
    private static final String DESTINATION_FILE;

    static {
        ClassLoader context = Thread.currentThread().getContextClassLoader();

        URL sourceRes = context.getResource(PATH_SOURCE);
        URL destinationRes = context.getResource(PATH_DESTINATION);

        if (Objects.isNull(sourceRes) || Objects.isNull(destinationRes)) {
            String message = String.format(ERROR_MESSAGE, Objects.isNull(sourceRes) ? PATH_SOURCE : PATH_DESTINATION);
            throw new IllegalArgumentException(message);
        }

        SOURCE_FILE = sourceRes.getFile();
        DESTINATION_FILE = destinationRes.getFile();
    }

    public static void main(String[] args) {
        try (InputStream in = new FileInputStream(SOURCE_FILE); OutputStream out = new FileOutputStream(DESTINATION_FILE)) {
            int s;
            while ((s = in.read()) != -1) {
                log.info("char = " + s);
                out.write(s);
            }
        } catch (IOException ex) {
            log.severe(ex.getMessage());
        }
    }
}
