package com.malex.lecture_17_IO.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import lombok.extern.log4j.Log4j;

/** The simple example of filling and reading a file in a folder with resources */
@Log4j
public class CreatingAndFillingFile {

  /** The path to file */
  private static final String PATH_TO_SRS = "new_file.txt";

  /** Error message */
  private static final String ERROR_MESSAGE = "Error %s the file %s | message : %s";

  /** The URL to resources folder */
  private static final URL RESOURCE_FOLDER =
      CreatingAndFillingFile.class.getClassLoader().getResource(PATH_TO_SRS);

  public static void main(String[] args) {
    String pathToFile =
        Optional.ofNullable(RESOURCE_FOLDER).orElseThrow(IllegalArgumentException::new).getPath();
    File file = new File(pathToFile);

    // #1 Creating a file
    try {

      String path = RESOURCE_FOLDER.getPath();
      file = new File(path);
      if (!file.exists() && !file.createNewFile()) {
        throwException("creating", new IOException());
      }
    } catch (IOException ex) {
      throwException("creating", ex);
    }

    // #2 Filling a file with data
    try (FileOutputStream output = new FileOutputStream(file);
        DataOutputStream dataOutputStream = new DataOutputStream(output)) {
      dataOutputStream.writeChars("c");
      dataOutputStream.writeChars("b");
    } catch (IOException ex) {
      throwException("filling", ex);
    }

    // #3 Read the file
    try (FileInputStream input = new FileInputStream(file);
        DataInputStream dataInput = new DataInputStream(input)) {
      log.info(dataInput.readChar());
      log.info(dataInput.readChar());
    } catch (IOException ex) {
      throwException("reading", ex);
    }
  }

  private static void throwException(String action, IOException ex) {
    String errorMessage = String.format(ERROR_MESSAGE, action, PATH_TO_SRS, ex.getMessage());
    log.error(errorMessage);
    throw new IllegalArgumentException(errorMessage);
  }
}
