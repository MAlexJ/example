package com.malex.lecture_13_collection_api;

import com.malex.utils.AbstractUtils;
import java.lang.reflect.Method;
import java.util.Optional;
import lombok.SneakyThrows;

abstract class AbstractTest extends AbstractUtils {

  private static final String DEFAULT_DESCRIPTION = "Default description";

  @SneakyThrows
  protected String getAnnotationDescription(String name) {
    Class<? extends AbstractUtils> aClass = this.getClass();
    Method method =
        Optional.of(aClass.getDeclaredMethod(name, String.class)) //
            .orElseThrow(
                () ->
                    new IllegalArgumentException(String.format("method - '%s' not found!", name)));

    return Optional.ofNullable(method.getAnnotation(TestNameAnnotation.class)) //
        .map(TestNameAnnotation::value) //
        .orElse(DEFAULT_DESCRIPTION);
  }
}
