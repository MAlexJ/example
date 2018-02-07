package partition_list;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * In this tutorial I will illustrate how to split a List into several sublists of a given size.
 * For a relatively simple operation, there is surprisingly no support in the standard Java collection APIs.
 */
public class PartitionList {

    /**
     * Use Guava to partition the List
     * Guava facilitates partitioning the List into sublists of a specified size – via the Lists.partition operation:
     */
    @Test
    public void test() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = Lists.partition(intList, 3);

        List<Integer> lastPartition = subSets.get(2);
        List<Integer> expectedLastPartition = Lists.newArrayList(7, 8);
        assertThat(subSets.size(), equalTo(3));
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }

    /**
     * Use Guava to partition a Collection
     * Partitioning a Collection is also possible with Guava:
     */
    @Test
    public void givenCollection_whenParitioningIntoNSublists_thenCorrect() {
        Collection<Integer> intCollection = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

        Iterable<List<Integer>> subSets = Iterables.partition(intCollection, 3);

        List<Integer> firstPartition = subSets.iterator().next();
        List<Integer> expectedLastPartition = Lists.newArrayList(1, 2, 3);
        assertThat(firstPartition, equalTo(expectedLastPartition));
    }

    /**
     * Keep in mind that the partitions are sublist views of the original collection – which means that changes in the original collection will be reflected in the partitions:
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
