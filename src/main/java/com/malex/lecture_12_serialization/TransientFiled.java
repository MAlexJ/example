package com.malex.lecture_12_serialization;

import static com.malex.lecture_12_serialization.utils.SerializationDeserializationUtils.deserialization;
import static com.malex.lecture_12_serialization.utils.SerializationDeserializationUtils.serialization;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import com.malex.utils.AbstractUtils;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.Optional;
import lombok.Builder;
import lombok.Data;
import org.junit.BeforeClass;
import org.junit.Test;

public class TransientFiled extends AbstractUtils {

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
  public void canSerializationTransientObj() {
    var user = User.builder().name("Max").age(23).build();
    serialization(sourceFile, user);
    println("Serialized user object: " + user);

    var desUser = deserialization(sourceFile, User.class);

    println("Deserialized from file: " + desUser);
    assertEquals(user.getName(), desUser.getName());
    assertNull(desUser.getAge());
  }

  @Data
  @Builder
  private static class User implements Serializable {
    private String name;
    private transient Integer age;
  }
}
