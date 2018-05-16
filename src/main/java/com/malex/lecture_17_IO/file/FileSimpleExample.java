package com.malex.lecture_17_IO.file;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

/**
 * Created by admin on 26.04.2015.
 */
public class FileSimpleExample {
    private static final String PATH_TO_FILE = "source/file.txt";

    public static void main(String[] args) throws URISyntaxException {
        URL resource = FileSimpleExample.class.getClassLoader().getResource(PATH_TO_FILE);
        if (Objects.isNull(resource)) {
            return;
        }

        URI uri = resource.toURI();
        File file = new File(uri);
        System.out.println("It is the directory: " + file.isDirectory());
        System.out.println("File name: " + file.getName());
        System.out.println("The file is exist: " + file.exists());
        // file.delete();
    }
}