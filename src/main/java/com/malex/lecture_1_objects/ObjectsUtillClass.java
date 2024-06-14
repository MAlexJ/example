package com.malex.lecture_1_objects;

import com.malex.utils.AbstractUtils;
import java.util.Objects;
import org.junit.Test;

public class ObjectsUtillClass extends AbstractUtils {

  @Test
  public void run() {
    Objects.isNull(null);
    Objects.nonNull(new String());
  }
}
