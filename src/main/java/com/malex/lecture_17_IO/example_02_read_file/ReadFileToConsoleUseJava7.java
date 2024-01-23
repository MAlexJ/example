package com.malex.lecture_17_IO.example_02_read_file;

import com.malex.lecture_17_IO.AbstractReadFile;
import java.io.*;
import org.junit.Test;

/** JAVA 7 closing resources automatically */
public class ReadFileToConsoleUseJava7 extends AbstractReadFile {

  @Test
  public void simpleReadFile() {
    try (InputStream in = new FileInputStream(PATH_TO_SOURCE_FILE);
        OutputStream out = new FileOutputStream(PATH_TO_DESTINATION_FILE)) {
      int s;
      while ((s = in.read()) != -1) {
        println("char =", s);
        out.write(s);
      }
    } catch (IOException ex) {
      println(ex.getMessage());
    }
  }
}
