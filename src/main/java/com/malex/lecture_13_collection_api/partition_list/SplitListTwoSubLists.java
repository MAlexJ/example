package partition_list;

import com.google.common.collect.Lists;
import org.junit.Test;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.*;

/**
 * Split a List into two SubList
 * src: http://www.techiedelight.com/split-list-two-sublists-java/
 */
public class SplitListTwoSubLists {

    private enum Type {
        NATIVE, SUB_LIST, PARTITION_BY, GROUP_BY, GUAVA_PARTITION
    }

    public static void main(String[] args) {
        SplitListTwoSubLists subTest = new SplitListTwoSubLists();
        subTest.test();
    }

    @Test
    public void test() {
        // Native
        assertSplit(Lists.newArrayList(Lists.newArrayList(1, 2, 3, 4, 5), Lists.newArrayList(6, 7, 8, 9)), Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9), Type.NATIVE);
        assertSplit(Lists.newArrayList(Lists.newArrayList(Integer.MIN_VALUE), Lists.newArrayList(Integer.MAX_VALUE)), Lists.newArrayList(Integer.MIN_VALUE, Integer.MAX_VALUE), Type.NATIVE);
        assertSplit(Lists.newArrayList(), Lists.newArrayList(), Type.NATIVE);
        assertSplit(Lists.newArrayList(Lists.newArrayList(1), Lists.newArrayList()), Lists.newArrayList(1), Type.NATIVE);
        assertSplit(Lists.newArrayList(), Lists.newArrayList(), Type.NATIVE);
        try {
            assertSplit(Lists.newArrayList(), null, Type.NATIVE);
            fail();
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("must not be null"));
        }

        // List.subList();
        assertSplit(Lists.newArrayList(Lists.newArrayList(1, 2), Lists.newArrayList(3)), Lists.newArrayList(1, 2, 3), Type.SUB_LIST);
        assertSplit(Lists.newArrayList(Lists.newArrayList(1), Lists.newArrayList(2)), Lists.newArrayList(1, 2), Type.SUB_LIST);
        assertSplit(Lists.newArrayList(Lists.newArrayList(1), Lists.newArrayList()), Lists.newArrayList(1), Type.SUB_LIST);
        assertSplit(Lists.newArrayList(), Lists.newArrayList(), Type.SUB_LIST);
        try {
            assertSplit(Lists.newArrayList(), null, Type.SUB_LIST);
            fail();
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("must not be null"));
        }

        // Collectors.partitioningBy
        assertSplit(Lists.newArrayList(Lists.newArrayList(1, 2), Lists.newArrayList(3)), Lists.newArrayList(1, 2, 3), Type.PARTITION_BY);
        assertSplit(Lists.newArrayList(Lists.newArrayList(1), Lists.newArrayList(2)), Lists.newArrayList(1, 2), Type.PARTITION_BY);
        assertSplit(Lists.newArrayList(Lists.newArrayList(1), Lists.newArrayList()), Lists.newArrayList(1), Type.PARTITION_BY);
        assertSplit(Lists.newArrayList(), Lists.newArrayList(), Type.PARTITION_BY);
        try {
            assertSplit(Lists.newArrayList(), null, Type.PARTITION_BY);
            fail();
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("must not be null"));
        }

    }

    private void assertSplit(List<List<Integer>> expectedList, List<Integer> list, Type type) {
        switch (type) {
            case NATIVE: {
                assertEquals(expectedList, splitNative(list));
                break;
            }
            case SUB_LIST:
                assertEquals(expectedList, subList(list));
                break;
            case PARTITION_BY:
                assertEquals(expectedList, partitionByJava8(list));
                break;
            case GROUP_BY:
                assertEquals(expectedList, partitionByJava8(list));
                break;

            case GUAVA_PARTITION:
                assertEquals(expectedList, partitionByGuava(list));
                break;
            default:
                throw new IllegalArgumentException("Incorrect type");
        }
    }

    /**
     * Guava
     * <p>
     * With Guava library, we can use <code>Lists.partition()</code> method that splits the list into consecutive sub-lists,
     * each of the specified size. In order to split the list into two sub-lists, we can pass the size that is equal to half the size of our list
     */
    private List<List<Integer>> partitionByGuava(@Nonnull List<Integer> list) {

        return null;
    }

    /**
     * >We can use <code>Collectors.partitioningBy()</code> to split the list into two sublists in Java 8
     */
    private <T> List<List<T>> partitionByJava8(@Nonnull List<T> list) {
        List<List<T>> result = new ArrayList<>();
        if (list.isEmpty()) {
            return result;
        }

        final int midIndex = (list.size() - 1) / 2;
        Collection<List<T>> values = list.stream().collect(Collectors.partitioningBy(index -> list.indexOf(index) > midIndex)).values();
        result.addAll(values);

        return result;
    }

    /**
     * Native solution would to create two new empty lists and assign elements from first half of th original list to the first list
     * and elements from second half of the original list to the second list
     */
    private <T> List<List<T>> splitNative(@Nonnull List<T> list) {
        List<List<T>> result = new ArrayList<>();
        if (list.isEmpty()) {
            return result;
        }

        // create two empty lists
        List<T> first = new ArrayList<>();
        List<T> second = new ArrayList<>();

        // get size of the list
        int size = list.size();

        // process each element of the list and add to the first list or second based on list position
        for (int i = 0; i < list.size(); i++) {
            if (i < (size + 1) / 2) {
                first.add(list.get(i));
            } else {
                second.add(list.get(i));
            }
        }

        // return a list lists to accommodate both lists
        result.add(first);
        result.add(second);
        return result;
    }

    /**
     * This is recommended approach in Java SE where we use <code>List.subList()</code> method that returns a view of this list between the specified indexes.
     * Since the returned list is backed by this list, we can construct a new List from the returned view
     */
    private <T> List<List<T>> subList(@Nonnull List<T> list) {
        List<List<T>> result = new ArrayList<>();
        if (list.isEmpty()) {
            return result;
        }
        int size = list.size();
        int partitionSize = (size + 1) / 2;

        result.add(list.subList(0, partitionSize));
        result.add(list.subList(partitionSize, size));

        return result;
    }

}