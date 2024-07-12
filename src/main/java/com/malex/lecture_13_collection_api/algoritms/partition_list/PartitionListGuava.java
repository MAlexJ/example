package com.malex.lecture_13_collection_api.algoritms.partition_list;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import org.junit.Test;

/**
 * In this tutorial I will illustrate how to split a List into several sub-lists of a given size.
 * For a relatively simple operation, there is surprisingly no support in the standard Java
 * collection APIs.
 */
public class PartitionListGuava {

  /**
   * Use Guava to partition the List Guava facilitates partitioning the List into sub-lists of a
   * specified size – via the Lists.partition operation:
   */
  @Test
  public void test() {
    // given
    List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8);

    // when
    List<List<Integer>> subLists = Lists.partition(intList, 3);

    // then
    assertThat(subLists.size(), equalTo(3));
    // and
    List<Integer> lastPartition = subLists.getLast();
    assertThat(lastPartition, equalTo(List.of(7, 8)));
  }

  /** Use Guava to partition a Collection Partitioning a Collection is also possible with Guava: */
  @Test
  public void givenCollection_whenParitioningIntoNSublists_thenCorrect() {
    Collection<Integer> intCollection = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

    Iterable<List<Integer>> subSets = Iterables.partition(intCollection, 3);

    List<Integer> firstPartition = subSets.iterator().next();
    List<Integer> expectedLastPartition = Lists.newArrayList(1, 2, 3);
    assertThat(firstPartition, equalTo(expectedLastPartition));
  }

  /**
   * Keep in mind that the partitions are sublist views of the original collection – which means
   * that changes in the original collection will be reflected in the partitions:
   */
  @Test
  public void givenListPartitioned_whenOriginalListIsModified_thenPartitionsChangeAsWell() {
    // Given
    List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
    List<List<Integer>> subSets = Lists.partition(intList, 3);

    // When
    intList.add(9);

    // Then
    List<Integer> lastPartition = subSets.get(2);
    List<Integer> expectedLastPartition = Lists.<Integer>newArrayList(7, 8, 9);
    assertThat(lastPartition, equalTo(expectedLastPartition));
  }
}
