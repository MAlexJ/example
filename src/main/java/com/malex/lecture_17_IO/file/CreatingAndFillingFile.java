package com.malex.lecture_17_IO.file;

import lombok.extern.log4j.Log4j;

import java.io.*;
import java.net.URL;
import java.util.Optional;

/**
 * The simple example of filling and reading a file in a folder with resources
 */
@Log4j
public class CreatingAndFillingFile {
    /**
     * The path to file
     */
    private static final String PATH_TO_SRS = "new_file.txt";
    /**
     * The URL to resources folder
     */
    private static final URL RESOURCE_FOLDER = CreatingAndFillingFile.class.getClassLoader().getResource(PATH_TO_SRS);

    public static void main(String[] args) {
        String pathToFile = Optional.ofNullable(RESOURCE_FOLDER).orElseThrow(IllegalArgumentException::new).getPath();
        File file = new File(pathToFile);

        // #1 Creating a file
        try {

            String path = RESOURCE_FOLDER.getPath();
            file = new File(path);
            if (!file.exists() && !file.createNewFile()) {
                throw new IOException("Error creating the file : " + file.getName());
            }
        } catch (IOException ex) {
            log.error("Error creating the file | message : " + ex.getMessage());
        }

        // #2 Filling a file with data
        try (FileOutputStream output = new FileOutputStream(file); DataOutputStream dataOutputStream = new DataOutputStream(output)) {
            dataOutputStream.writeChars("c");
            dataOutputStream.writeChars("b");
        } catch (IOException ex) {
            log.error("Error filling the file | message : " + ex.getMessage());
        }

        // #3 Read the file
        try (FileInputStream input = new FileInputStream(file); DataInputStream dataInput = new DataInputStream(input)) {
            log.info(dataInput.readChar());
            log.info(dataInput.readChar());
        } catch (IOException ex) {
            log.error("Error reading the file | message : " + ex.getMessage());
        }
    }
}
