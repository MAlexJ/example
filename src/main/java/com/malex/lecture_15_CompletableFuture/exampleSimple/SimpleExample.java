package com.malex.lecture_15_CompletableFuture.exampleSimple;

import lombok.extern.java.Log;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@Log
public class SimpleExample {

    private static final String PATH_SOURCE = "source/source.txt";
    private static final String SOURCE_FILE;

    private static final String ERROR_MESSAGE = "File not found: %s";

    static {
        ClassLoader context = Thread.currentThread().getContextClassLoader();
        URL sourceRes = context.getResource(PATH_SOURCE);

        if (Objects.isNull(sourceRes)) {
            String message = String.format(ERROR_MESSAGE, PATH_SOURCE);
            throw new IllegalArgumentException(message);
        }

        SOURCE_FILE = sourceRes.getFile();
    }

    public static void main(String[] args) throws InterruptedException {
        /*
         * Returns a new CompletableFuture that is asynchronously completed
         * by a task running in the {@link ForkJoinPool#commonPool()} with
         * the value obtained by calling the given Supplier.
         */
        CompletableFuture.supplyAsync(SimpleExample::readFile).thenAcceptAsync(log::info);

        Thread.sleep(1000);
    }

    private static String readFile() {
        StringBuilder contentBuilder = new StringBuilder();
        Path path = Paths.get(SOURCE_FILE);

        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        } catch (IOException ex) {
            log.severe(ex.getMessage());
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, SOURCE_FILE));
        }

        return contentBuilder.toString();
    }
}