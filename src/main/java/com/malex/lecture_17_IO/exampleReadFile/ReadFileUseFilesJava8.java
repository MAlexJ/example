package com.malex.lecture_17_IO.exampleReadFile;

import lombok.extern.java.Log;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

@Log
public class ReadFileUseFilesJava8 {


    private static final String PATH_SOURCE = "source/source.txt";
    private static final String DELIMITER = "\n";
    private static final String SOURCE_FILE;

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(PATH_SOURCE);
        //  Gets the file name of this URL
        SOURCE_FILE = Optional.ofNullable(resource).orElseThrow(RuntimeException::new).getFile();
    }

    public static void main(String[] args) {
        String text = readLineByLine();
        log.info(text);
    }

    /**
     * Read file content into string with - Files.lines(Path path, Charset cs)
     *
     * @return string with context from a file
     */
    private static String readLineByLine() {
        StringBuilder builder = new StringBuilder();
        Path path = Paths.get(SOURCE_FILE);

        // Read all lines from a file as a {@code Stream}.
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.forEach(line -> builder.append(line).append(DELIMITER));
        } catch (IOException ex) {
            log.severe(ex.getMessage());
            throw new IllegalArgumentException("Something wrong!");
        }

        return builder.toString();
    }
}
