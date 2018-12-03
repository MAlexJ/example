package com.malex.lecture_17_IO.file;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Objects;
import java.util.Set;
import lombok.extern.log4j.Log4j;

@Log4j
public class CopyFileNIO {

  private static final String PATH_SOURCE = "source/file11.txt";
  private static final String PATH_DESTINATION = "destination.txt";

  private static final String ERROR_CREATE_FILE = "An error occurred while creating the file '%s'";
  private static final String ERROR_COPY_FILE = "An error occurred while copy the file '%s'";

  private static final String PERMISSIONS = "rwxrwxrwx";

  private static final String SOURCE_FILE;
  private static final String DESTINATION_FILE;

  private static final FileAttribute<Set<PosixFilePermission>> FILE_ATTRIBUTE = fileAttribute();
  private static final CopyOption[] COPY_OPTIONS = getCopyOptions();

  static {
    ClassLoader context = Thread.currentThread().getContextClassLoader();
    SOURCE_FILE = creatingFileIfNotExist(context, PATH_SOURCE);
    DESTINATION_FILE = creatingFileIfNotExist(context, PATH_DESTINATION);
  }

  public static void main(String[] args) {

    Path from = Paths.get(SOURCE_FILE);
    Path to = Paths.get(DESTINATION_FILE);

    try {

      Path path = Files.copy(from, to, COPY_OPTIONS);
      log.debug("File " + path + " copied successfully!");

    } catch (IOException e) {
      String message = String.format(ERROR_COPY_FILE, PATH_SOURCE);
      log.error(message);
      throw new IllegalArgumentException(message);
    }
  }

  private static FileAttribute<Set<PosixFilePermission>> fileAttribute() {
    return PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString(PERMISSIONS));
  }

  private static CopyOption[] getCopyOptions() {
    return new CopyOption[] {
      StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING,
    };
  }

  /** Create a file if it does not exist */
  private static String creatingFileIfNotExist(ClassLoader context, String fileName) {

    URL fileUrl = context.getResource(fileName);
    if (!Objects.isNull(fileUrl)) {
      return fileUrl.getFile();
    }

    File file = new File(fileName);
    try {
      if (!file.exists()) {
        log.debug("The file is created!");
        Files.createFile(file.toPath(), FILE_ATTRIBUTE);
      }
    } catch (IOException e) {
      String message = String.format(ERROR_CREATE_FILE, fileName);
      log.error(message);
      throw new IllegalArgumentException(message);
    }

    return file.getPath();
  }
}
