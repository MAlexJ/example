package remove_consecutive_duplicates;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Remove consecutive duplicates from an ArrayList in Java
 */
public class RemoveConsecutiveDuplicates {

    /**
     * CASE: 1
     */
    public static List<Integer> noConsecutiveDuplicates(List<Integer> input) {
        ArrayList<Integer> newList = new ArrayList<>();
        // Always add first value
        if (input.isEmpty()) {
            throw new RuntimeException("Error!");
        }
        newList.add(input.get(0));
        // Iterate the remaining values
        for (int i = 1; i < input.size(); i++) {
            // Compare current value to previous
            if (!input.get(i - 1).equals(input.get(i))) {
                newList.add(input.get(i));
            }
        }
        return newList;
    }


    @Test
    public void test() {
        assertEquals(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7), noConsecutiveDuplicates(Lists.newArrayList(1, 1, 1, 1, 2, 3, 3, 3, 4, 5, 5, 6, 7)));
        assertEquals(Lists.newArrayList(1, 2, 3, 4, 3, 2, 1), noConsecutiveDuplicates(Lists.newArrayList(1, 1, 1, 1, 2, 3, 3, 3, 4, 3, 2, 2, 1)));
        assertEquals(Lists.newArrayList(1, 2, 3, 4, 3, 2, 1), noConsecutiveDuplicates(Lists.newArrayList(1, 1, 1, 1, 2, 3, 3, 3, 4, 3, 2, 2, 1, 1, 1)));
        assertEquals(Lists.newArrayList(1), noConsecutiveDuplicates(Lists.newArrayList(1, 1, 1, 1, 1, 1, 1)));
        assertEquals(Lists.newArrayList(1, 0), noConsecutiveDuplicates(Lists.newArrayList(1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0)));
    }
}
