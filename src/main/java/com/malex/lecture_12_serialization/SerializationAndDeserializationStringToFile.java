package com.malex.lecture_12_serialization;

import static com.malex.lecture_12_serialization.utils.SerializationDeserializationUtils.deserialization;
import static com.malex.lecture_12_serialization.utils.SerializationDeserializationUtils.serialization;
import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import org.junit.Test;

public class SerializationAndDeserializationStringToFile extends AbstractUtils {

  private static final String FILE_NAME = "source.txt";
  private static final String PATH_SOURCE = "serialization/%s";
  private static final String ERROR_MESSAGE = "File '%s' not found!";
  private static final File SOURCE_FILE;

  static {
    var classLoader = Thread.currentThread().getContextClassLoader();
    var url = classLoader.getResource(String.format(PATH_SOURCE, FILE_NAME));
    //  Gets the file name of this URL
    SOURCE_FILE =
        Optional.ofNullable(url)
            .map(URL::getFile)
            .map(File::new)
            .orElseThrow(() -> new RuntimeException(String.format(ERROR_MESSAGE, FILE_NAME)));
  }

  @Test
  public void serializationAndDeserializationStringToFile() {
    var hello = "Hello!";

    // #1 serialization
    println("Before:", hello);
    serialization(SOURCE_FILE, hello);

    // #2 deserialization
    var deserializationString = deserialization(SOURCE_FILE, String.class);
    println("After:", deserializationString);

    assertEquals(hello, deserializationString);
  }
}
