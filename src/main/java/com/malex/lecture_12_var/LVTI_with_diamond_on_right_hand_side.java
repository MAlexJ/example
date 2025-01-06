package com.malex.lecture_12_var;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/*
 * Q8. Can you use var with a diamond on the right-hand side?
 *
 * link: https://openjdk.org/projects/amber/guides/lvti-faq
 *
 * Yes, it works, but it’s probably not what you want.
 * Consider:
 *
 *  var list = new ArrayList<>();
 *
 * This will infer the type of list to be ArrayList<Object>.
 *
 * In general, it’s preferable use an explicit type on the left with diamond on the right,
 * or use var on the left with an explicit type on the right.
 *
 * See the LVTI Style Guidelines, guideline G6, for further information.
 *
 *
 */
public class LVTI_with_diamond_on_right_hand_side {

  @Test
  public void test() {
    var list = new ArrayList<>();

    assertTrue(list instanceof ArrayList<Object>);

    assertTrue(list instanceof ArrayList);

    assertTrue(list instanceof List);

    assertTrue(list instanceof Collection<?>);

    // false
    assertFalse(list instanceof Set<?>);
  }
}
