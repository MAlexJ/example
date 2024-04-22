package com.malex.lecture_13_collection_api.list;

import static junit.framework.TestCase.assertTrue;

import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class ListInitialization extends AbstractBase {

  /** Container class for immutable collections */
  @Test
  public void listsOfImmutableCollectionsClassTest2() {
    // given
    List<String> list = Collections.singletonList("Hello!");

    // when
    list.removeFirst();

    // then
    assertTrue(list.isEmpty());
  }
}
