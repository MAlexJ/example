package com.malex.lecture_17_IO.exampleReadFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Objects;
import org.apache.log4j.Logger;

/** JAVA 6 support for closing resources */
public class ReadFileToConsole {
  private static final Logger LOG = Logger.getLogger(ReadFileToConsole.class);

  private static final String SOURCE_FILE;
  private static final String DESTINATION_FILE;

  static {
    ClassLoader context = Thread.currentThread().getContextClassLoader();

    URL sourceRes = context.getResource("source/source.txt");
    URL destinationRes = context.getResource("destination/destination.txt");

    if (Objects.isNull(sourceRes) || Objects.isNull(destinationRes)) {
      throw new IllegalArgumentException("Files aren't found!");
    }

    SOURCE_FILE = sourceRes.getFile();
    DESTINATION_FILE = destinationRes.getFile();
  }

  public static void main(String[] args) {
    InputStream inStream = null;
    OutputStream outStream = null;
    try {
      inStream = new FileInputStream(SOURCE_FILE);
      outStream = new FileOutputStream(DESTINATION_FILE);

      int i;
      while ((i = inStream.read()) != -1) {
        LOG.debug((char) i);
        outStream.write(i);
      }
    } catch (IOException e) {
      LOG.error(e.getMessage());
    } finally {
      try {
        // close input stream
        if (inStream != null) inStream.close();
        // close output stream
        if (outStream != null) outStream.close();
      } catch (IOException e) {
        LOG.error(e.getMessage());
      }
    }
  }
}
