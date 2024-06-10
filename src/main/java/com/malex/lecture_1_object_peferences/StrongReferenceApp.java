package com.malex.lecture_1_object_peferences;

import static junit.framework.TestCase.*;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class StrongReferenceApp extends AbstractUtils {

  @Test
  public void simple() {
    Object obj = new Object();
    assertNotNull(obj);

    obj = null;
    assertNull(obj);
  }

  @Test
  public void collections() {
    Object obj = new Object();

    List<Object> list = new ArrayList<>();
    list.add(obj);
    obj = null;
    assertNull(obj);

    Object objFromList = list.getFirst();
    objFromList = null;
    assertNull(objFromList);

    assertNotNull(list.getFirst());
  }
}
