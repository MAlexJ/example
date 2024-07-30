package com.malex.lecture_17_IO.file;

import com.malex.utils.AbstractUtils;
import java.io.*;
import java.net.URL;
import java.util.Optional;
import org.junit.Test;

/** The simple example of filling and reading a file in a folder with resources */
public class CreatingAndFillingFile extends AbstractUtils {

  /** The path to file */
  private static final String PATH_TO_SRS = "new_file.txt";

  /** Error message */
  private static final String ERROR_MESSAGE = "Error %s the file %s | message : %s";

  /** The URL to resources folder */
  private static final URL RESOURCE_FOLDER =
      CreatingAndFillingFile.class.getClassLoader().getResource(PATH_TO_SRS);

  @Test
  public void test() {
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
      print("dataInput - " + dataInput.readChar());
      print("dataInput - " + dataInput.readChar());
    } catch (IOException ex) {
      throwException("reading", ex);
    }
  }

  private void throwException(String action, IOException ex) {
    String errorMessage = String.format(ERROR_MESSAGE, action, PATH_TO_SRS, ex.getMessage());
    printError(errorMessage);
    throw new IllegalArgumentException(errorMessage);
  }
}
