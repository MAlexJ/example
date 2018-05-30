package com.malex.lecture_17_IO.file;

import lombok.extern.log4j.Log4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

/**
 * Created by admin on 26.04.2015.
 */
@Log4j
public class CopyFileIO {

    private static final String PATH_TO_SRS = "source/file.txt";
    private static final String PATH_TO_DESTINATION = "destination/file.txt";

    public static void main(String[] args) throws URISyntaxException {
        URL resourceSrs = CopyFileIO.class.getClassLoader().getResource(PATH_TO_SRS);
        if (Objects.isNull(resourceSrs)) {
            return;
        }

        URI uriSrs = resourceSrs.toURI();
        File srcFile = new File(uriSrs);

        String destPath = srcFile.getParent().replace(PATH_TO_SRS, PATH_TO_DESTINATION);
        File destFile = new File(destPath);

        try (FileInputStream fileInputStream = new FileInputStream(srcFile);
             FileOutputStream fileOutputStream = new FileOutputStream(destFile)) {
            int temp;
            while (true) {
                temp = fileInputStream.read();
                if (temp != -1) {
                    fileOutputStream.write(temp);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            log.error("The error message: " + e.getMessage());
        }
    }
}


