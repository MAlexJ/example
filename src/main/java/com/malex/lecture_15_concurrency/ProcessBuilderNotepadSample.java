package com.malex.lecture_15_concurrency;

import java.io.IOException;

public class ProcessBuilderNotepadSample {

    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
        processBuilder.start();
    }
}
