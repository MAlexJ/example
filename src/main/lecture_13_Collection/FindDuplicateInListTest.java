package lecture_13_Collection;

import com.google.common.collect.LinkedHashMultiset;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

public class FindDuplicateInListTest {

    @Test
    public void test() {

        List<Integer> list = Stream.of(1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 8).collect(Collectors.toList());
        List<Integer> expectedList = Stream.of(1, 5, 8).collect(Collectors.toList());

        // #1 case:  java 8 : Guava
        assertEquals(expectedList, findDuplicatesGuava(list));

        // #2 case:  java 8 : Lambda
        assertEquals(expectedList, findDuplicatesLambda(list));

    }

    /**
     * Using Guava on Java 8
     */
    private List<Integer> findDuplicatesGuava(List<Integer> input) {

        // Linked* preserves insertion order so the returned Sets iteration order is somewhat like the original list
        LinkedHashMultiset<Integer> duplicates = LinkedHashMultiset.create(input);
        System.out.println("step 1:  insert: " + duplicates);

        // Remove all entries with a count of 1
        duplicates.entrySet().removeIf(entry -> entry.getCount() == 1);
        System.out.println("step 2: removeIf(...) : " + duplicates);

        // Exclude duplicates
        Set<Integer> integers = duplicates.elementSet();
        System.out.println("step 3: elementSet(...) : " + integers);
        return new ArrayList<>(integers);
    }

    /**
     * Lambdas solution
     */
    private List<Integer> findDuplicatesLambda(List<Integer> list) {
        return list.stream()
                .distinct()
                .filter(entry -> Collections.frequency(list, entry) > 1)
                .collect(Collectors.toList());
    }

}
