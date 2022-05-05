package com.malex.lecture_17_IO.exampleReadFile;

import lombok.extern.java.Log;

import java.io.*;
import java.net.URL;
import java.util.Objects;

/**
 * JAVA 6 support for closing resources
 */
@Log
public class ReadFileToConsole {

    private static final String SOURCE_FILE;
    private static final String DESTINATION_FILE;

    static {
        ClassLoader context = Thread.currentThread().getContextClassLoader();

        URL sourceRes = context.getResource("source/source.txt");
        URL destinationRes = context.getResource("destination/destination.txt");

        if (Objects.isNull(sourceRes) || Objects.isNull(destinationRes)) {
            throw new IllegalArgumentException("Files aren't found!");
        }

        SOURCE_FILE = sourceRes.getFile();
        DESTINATION_FILE = destinationRes.getFile();
    }

    public static void main(String[] args) {
        InputStream inStream = null;
        OutputStream outStream = null;
        try {
            inStream = new FileInputStream(SOURCE_FILE);
            outStream = new FileOutputStream(DESTINATION_FILE);

            int i;
            while ((i = inStream.read()) != -1) {
                log.info("char: " + ((char) i));
                outStream.write(i);
            }
        } catch (IOException e) {
            log.severe(e.getMessage());
        } finally {
            try {
                // close input stream
                if (inStream != null) inStream.close();
                // close output stream
                if (outStream != null) outStream.close();
            } catch (IOException e) {
                log.severe(e.getMessage());
            }
        }
    }
}
