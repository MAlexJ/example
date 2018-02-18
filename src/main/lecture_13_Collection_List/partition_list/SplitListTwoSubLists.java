package partition_list;

import com.google.common.collect.Lists;
import lombok.NonNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Split a List into two SubList
 * src: http://www.techiedelight.com/split-list-two-sublists-java/
 */
public class SplitListTwoSubLists {

    private enum Type {
        NATIVE, SUB_LIST
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

        // List.subList();
        assertSplit(Lists.newArrayList(Lists.newArrayList(1, 2), Lists.newArrayList(3)), Lists.newArrayList(1, 2, 3), Type.SUB_LIST);
        assertSplit(Lists.newArrayList(Lists.newArrayList(1), Lists.newArrayList(2)), Lists.newArrayList(1, 2), Type.SUB_LIST);
        assertSplit(Lists.newArrayList(Lists.newArrayList(1), Lists.newArrayList()), Lists.newArrayList(1), Type.SUB_LIST);
        assertSplit(Lists.newArrayList(), Lists.newArrayList(), Type.SUB_LIST);
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
            default:
                throw new IllegalArgumentException("Incorrect type");
        }
    }

    /**
     * Native solution would to create two new empty lists and assign elements from first half of th original list to the first list
     * and elements from second half of the original list to the second list
     */
    private <T> List<List<T>> splitNative(List<T> list) {
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
     * Sub list
     */
    private <T> List<List<T>> subList(@NonNull List<T> list) {
        List<List<T>> result = new ArrayList<>();
        if (list.isEmpty())
            return result;
        int size = list.size();
        int partitionSize = (size + 1) / 2;

        result.add(list.subList(0, partitionSize));
        result.add(list.subList(partitionSize, size));

        return result;
    }

}