package com.malex.lecture_13_collection_api.algoritms.intersection;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class SetIntersection extends AbstractUtils {

  public static <E> Set<E> intersection(Set<E> initialSet, Set<E> verificationSet) {
    return initialSet.stream()
        // predicate: .filter(el -> verificationSet.contains(el))
        .filter(verificationSet::contains)
        .collect(Collectors.toSet());
  }

  /*
   * Additional functionality
   */
  public static <E> List<E> intersection(List<E> initial, List<E> verification) {
    Set<E> intersection = intersection(new HashSet<E>(initial), new HashSet<E>(verification));
    return new ArrayList<>(intersection);
  }

  @Test
  public void test() {
    assertEquals(Set.of(), intersection(Set.of(4, 2), Set.of(1, 3)));
    assertEquals(Set.of(1), intersection(Set.of(1, 2), Set.of(1, 3)));
    assertEquals(Set.of(2, 4), intersection(Set.of(2, 4), Set.of(1, 2, 4)));
  }
}
