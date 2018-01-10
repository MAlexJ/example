import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;


public class ExcludeDuplicateInListTest {

    @Test
    public void test() {

        List<Integer> list = Stream.of(1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 8).collect(Collectors.toList());
        List<Integer> expectedList = Stream.of(1, 2, 3, 4, 5, 6, 7, 8).collect(Collectors.toList());

        // #1 case:  java 8 : lambda
        assertEquals(expectedList, useLambdaDistinct(list));

        // #2 case: java core
        assertEquals(expectedList, useSet(list));

        // #3 case:  java 8 : lambda
        assertEquals(expectedList, findDuplicates(list));

        // #4   case: java core
        assertEquals(expectedList, useSetSimple(list));

    }

    /**
     * Set returns a boolean whether a value already exists (true if it does not exist, false if it already exists, see Set documentation)
     */
    private List<Integer> useSet(List<Integer> list) {
        final Set<Integer> resultDuplicate = new HashSet();
        final Set<Integer> result = new HashSet();
        for (Integer item : list) {
            if (result.add(item)) {
                resultDuplicate.add(item);
            }
        }
        return new ArrayList<>(resultDuplicate);
    }

    private List<Integer> useSetSimple(List<Integer> list) {
        return new ArrayList<>(new HashSet<>(list));
    }

    /**
     * Use lambda: `distinct()`
     */
    private List<Integer> useLambdaDistinct(List<Integer> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Java 8  of using set
     * Set returns a boolean whether a value already exists (true if it does not exist, false if it already exists, see Set documentation)
     */
    private <T> List<T> findDuplicates(Collection<T> collection) {
        Set<T> uniques = new HashSet<>();
        return collection.stream()
                .filter(uniques::add)
                .collect(Collectors.toList());
    }


}
