package com.malex.lecture_13_collection_api.set.set;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.HashSet;
import org.junit.Test;

/*
 * boolean add( E e )
 *
 * Adds the specified element to this set if it is not already present.
 *
 * More formally, adds the specified element e to this set
 * if this set contains no element e2 such that Objects.equals(e, e2).
 *
 * If this set already contains the element, the call leaves the set unchanged and returns false.
 *
 * Returns: true if this set did not already contain the specified element
 */
public class AddElementToSet extends AbstractUtils {

  @Test
  public void add() {
    var set = new HashSet<>();
    assertTrue(set.add(1));
    assertTrue(set.add(2));
    assertTrue(set.add(3));
  }

  @Test
  public void addDuplicates() {
    var set = new HashSet<>();
    assertTrue(set.add(1));
    assertFalse(set.add(1));
    assertFalse(set.add(1));
  }
}
