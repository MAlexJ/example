package com.malex.lecture_22_Design_Pattern.Structural.example_03_Proxy_Pattern.pattern;

import lombok.extern.java.Log;

@Log
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        log.info("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        log.info("Loading " + fileName);
    }
}
