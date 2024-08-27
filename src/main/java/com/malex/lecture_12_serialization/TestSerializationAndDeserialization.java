package com.malex.lecture_12_serialization;

import static com.malex.lecture_12_serialization.utils.SerializationDeserializationUtils.deserialization;
import static com.malex.lecture_12_serialization.utils.SerializationDeserializationUtils.serialization;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.fail;

import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class TestSerializationAndDeserialization {

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
  @Parameters({"Bye!", " Hello! ", ""})
  public void stringSerializationAndDeserialization(String expected) {
    serialization(sourceFile, expected);

    var actual = deserialization(sourceFile, String.class);
    assertEquals(expected, actual);
  }

  @Test
  @Parameters({"1", "3444", "-1235"})
  public void integerSerialization(Integer expected) {
    serialization(sourceFile, expected);

    Integer actual = deserialization(sourceFile, Integer.class);
    assertEquals(expected, actual);
  }

  @Test
  public void canSerializationClass() {
    User user =
        User.builder()
            .name(UUID.randomUUID().toString())
            .id(ThreadLocalRandom.current().nextInt(1, 100))
            .build();

    serialization(sourceFile, user);

    User actualUser = deserialization(sourceFile, User.class);
    assertEquals(user, actualUser);
  }

  @Test
  public void canSerializationTransientObj() {
    Dog dog = Dog.builder().name("Cat").bark("May, May").build();
    serialization(sourceFile, dog);

    Dog actualDog = deserialization(sourceFile, Dog.class);
    assertEquals(dog.getName(), actualDog.getName());
    assertNull(actualDog.getBark());
  }

  @Test
  public void cannotSerializationClass() {
    Company company = Company.builder().name(UUID.randomUUID().toString()).build();
    try {
      serialization(sourceFile, company);
      fail();
    } catch (Exception ex) {
      // none
    }
  }

  @Builder
  @EqualsAndHashCode
  private static class Company {
    private String name;
  }

  @Builder
  @EqualsAndHashCode
  private static class User implements Serializable {
    private int id;
    private String name;
  }

  @Builder
  @Getter
  private static class Dog implements Serializable {
    private String name;
    private transient String bark;
  }
}
