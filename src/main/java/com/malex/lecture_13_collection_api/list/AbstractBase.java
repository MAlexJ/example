package com.malex.lecture_13_collection_api.list;

import com.malex.utils.AbstractUtils;
import java.util.List;

public abstract class AbstractBase extends AbstractUtils {

  protected static final List<String> PREPARED_NAMES =
      List.of("Anna", "Alex", "Stefan", "Alexandra", "Cat");

  protected static final List<Cat> PREPARED_CATS =
      List.of(
          new Cat(1, "Stephan"),
          new Cat(4, "May"),
          new Cat(6, "Cat"),
          new Cat(9, "Jerry"),
          new Cat(3, "Tom"));

  protected final List<Dog> PREPARED_DOGS =
      List.of(
          new Dog(1, "Stephan"),
          new Dog(4, "May"),
          new Dog(6, "Cat"),
          new Dog(9, "Jerry"),
          new Dog(3, "Tom"));

  public record Dog(int age, String name) {}

  public record Cat(int age, String name) {}
}
