package com.malex.lecture_13_collection_api;

import com.malex.utils.AbstractUtils;
import com.malex.utils.SampleException;
import java.lang.reflect.Method;
import java.util.Optional;

abstract class AbstractTest extends AbstractUtils {

  private static final String DEFAULT_DESCRIPTION = "Default description";

  protected String getAnnotationDescription(String name) {
    Class<? extends AbstractUtils> aClass = this.getClass();
    try {
      Method method =
          Optional.of(aClass.getDeclaredMethod(name, String.class)) //
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          String.format("method - '%s' not found!", name)));
      return Optional.ofNullable(method.getAnnotation(TestNameAnnotation.class)) //
          .map(TestNameAnnotation::value) //
          .orElse(DEFAULT_DESCRIPTION);
    } catch (NoSuchMethodException e) {
      throw new SampleException(e);
    }
  }
}
