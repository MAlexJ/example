package com.malex.lecture_22_Design_Pattern.example_03_Proxy_Pattern.pattern;

import lombok.extern.log4j.Log4j;

@Log4j
public class ProxyPatternApp {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded from disk
        image.display();
        log.info("");

        //image will not be loaded from disk
        image.display();
    }
}
