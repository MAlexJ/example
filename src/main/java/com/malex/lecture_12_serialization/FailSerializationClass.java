package com.malex.lecture_12_serialization;

import static com.malex.lecture_12_serialization.utils.SerializationDeserializationUtils.serialization;
import static junit.framework.TestCase.fail;

import com.malex.utils.AbstractUtils;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import org.junit.BeforeClass;
import org.junit.Test;

public class FailSerializationClass extends AbstractUtils {

  private static final String PATH_SOURCE = "serialization/source.txt";
  private static File sourceFile;

  @BeforeClass
  public static void before() {
    var classLoader = Thread.currentThread().getContextClassLoader();
    var resourceUrl = classLoader.getResource(PATH_SOURCE);
    sourceFile =
        Optional.ofNullable(resourceUrl)
            .map(URL::getFile)
            .map(File::new)
            .orElseThrow(RuntimeException::new);
  }

  @Test
  public void cannotSerializationClass() {
    var company = new Company(1, "epam");
    try {
      serialization(sourceFile, company);
      fail();
    } catch (Exception ex) {
      printlnError(ex, 2);
    }
  }

  private record Company(int rate, String name) {}
}
