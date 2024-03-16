package com.malex.lecture_13_collectin_concurrent_api.CopyOnWriteArraySet;

import java.util.concurrent.CopyOnWriteArraySet;
import org.junit.Test;

/** A Set that uses an internal CopyOnWriteArrayList for all of its operations. */
public class CrudOperation extends AbstractBase {

  // TODO implement in
  @Test
  public void baseCrudOperation() {
    var set = new CopyOnWriteArraySet(PREPARED_CATS);

    // 1. add
    set.add(null);
    set.addAll(null);

    // 2.remove
    set.remove(null);
    set.removeAll(null);
    set.removeIf(null);

    // 3. retainAll
    set.retainAll(null);

    // 4. contains
    set.contains(null);

    // 5. isEmpty
    boolean empty = set.isEmpty();

    // 6. size
    int size = set.size();

    // 7. toArray
    Object[] array = set.toArray();
    //    set.toArray(null);

    // 8. clear
    set.clear();
  }
}
