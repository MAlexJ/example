package com.malex.lecture_17_IO.example_02_read_file;

import com.malex.lecture_17_IO.AbstractReadFile;
import java.io.*;
import org.junit.Test;

/** JAVA 6 support for closing resources */
public class ReadFileToConsoleJava6 extends AbstractReadFile {

  @Test
  public void simpleReadFile() {
    InputStream inStream = null;
    OutputStream outStream = null;
    try {
      inStream = new FileInputStream(PATH_TO_SOURCE_FILE);
      outStream = new FileOutputStream(PATH_TO_DESTINATION_FILE);

      int i;
      while ((i = inStream.read()) != -1) {
        println("char:", ((char) i));
        outStream.write(i);
      }
    } catch (IOException e) {
      e.fillInStackTrace();
    } finally {
      try {
        // close input stream
        if (inStream != null) inStream.close();
        // close output stream
        if (outStream != null) outStream.close();
      } catch (IOException e) {
        e.fillInStackTrace();
      }
    }
  }
}
