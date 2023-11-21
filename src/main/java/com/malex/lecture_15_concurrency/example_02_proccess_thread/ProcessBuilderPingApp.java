package com.malex.lecture_15_concurrency;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;

public class ProcessBuilderPingApp {

    private static final String localIp = "127.0.0.1";

    /**
     * Path to file in resources folder
     */
    private static final File PING_FILE;

    /**
     * File name
     */
    private static final String FILE_NAME = "ping.txt";

    static {
        ClassLoader context = Thread.currentThread().getContextClassLoader();
        URL sourceRes = context.getResource(FILE_NAME);
        PING_FILE = Optional.ofNullable(sourceRes) //
                .map(URL::getFile)  //
                .map(File::new).orElseThrow(() -> new RuntimeException("File not found!"));
    }

    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("ping", localIp);
        processBuilder.redirectInput(PING_FILE);
        Process process = processBuilder.start();

        readTxtFile(process);
    }

    private static void readTxtFile(Process process) throws IOException {

        try (InputStream iStream = process.getInputStream(); //
             InputStreamReader streamReader = new InputStreamReader(iStream); //
             BufferedReader reader = new BufferedReader(streamReader)) {
            print(reader);
        }
    }

    private static void print(BufferedReader reader) throws IOException {
        String line;
        while (Objects.nonNull(line = reader.readLine())) {
            System.out.println(line);
        }
    }
}
