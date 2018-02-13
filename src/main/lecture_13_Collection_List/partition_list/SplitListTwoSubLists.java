package partition_list;

import com.google.common.collect.Lists;
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

    @Test
    public void test() {
        // Native
        assertSplit(Lists.newArrayList(Lists.newArrayList(1, 2, 3, 4, 5), Lists.newArrayList(6, 7, 8, 9)), Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9), Type.NATIVE);
        assertSplit(Lists.newArrayList(Lists.newArrayList(Integer.MIN_VALUE), Lists.newArrayList(Integer.MAX_VALUE)), Lists.newArrayList(Integer.MIN_VALUE, Integer.MAX_VALUE), Type.NATIVE);
        assertSplit(Lists.newArrayList(), Lists.newArrayList(), Type.NATIVE);

        // List.subList();

    }

    private void assertSplit(List<List<Integer>> expectedList, List<Integer> list, Type type) {
        switch (type) {
            case NATIVE: {
                assertEquals(expectedList, splitNative(list));
                break;
            }
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


}