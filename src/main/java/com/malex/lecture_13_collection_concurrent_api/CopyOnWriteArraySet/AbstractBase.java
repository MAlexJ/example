package com.malex.lecture_13_collection_concurrent_api.CopyOnWriteArraySet;

import com.malex.utils.AbstractUtils;
import java.util.List;

public abstract class AbstractBase extends AbstractUtils {

  protected static final List<Cat> PREPARED_CATS =
      List.of(
          new Cat(1, "Stephan"),
          new Cat(4, "May"),
          new Cat(6, "Cat"),
          new Cat(9, "Jerry"),
          new Cat(3, "Tom"));

  protected record Cat(int age, String name) {}
}
