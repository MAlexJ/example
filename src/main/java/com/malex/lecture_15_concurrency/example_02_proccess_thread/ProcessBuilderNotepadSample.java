package com.malex.lecture_15_concurrency.example_02_proccess_thread;

import java.io.IOException;

public class ProcessBuilderNotepadSample {

    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
        processBuilder.start();
    }
}
