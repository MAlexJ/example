package com.malex.lecture_13_comparator.comparator_functional_interface;


import com.malex.lecture_13_comparator.utils.AbstractComparatorTestUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ComparatorSimpleExample extends AbstractComparatorTestUtils {

    @Test
    public void test1() {
        var iArray = new int[]{1, 4, -56, 3, 3, 0, 234};
        Comparator<Integer> iComparator = Comparator.comparingInt(Integer::intValue);
        print("Comparator<Integer> iComparator = Comparator.comparingInt(Integer::intValue)");
        for (int i = 0; i < iArray.length; i++) {
            if (i == iArray.length - 1) {
                break;
            }
            int first = iArray[i];
            int second = iArray[i + 1];
            print(i + 1 + ".", "compare number", first, "and", second, "result", iComparator.compare(first, second));
        }


        List<Long> lList = List.of(2L, 45L, -1243L, 0L, 4L, 4L, 454L);
        Comparator<Long> lComparator = Comparator.comparingLong(Long::longValue);
        print("Comparator<Long> lComparator = Comparator.comparingLong(Long::longValue)");
        int x = 0;
        while (x < lList.size()) {
            if (x == lList.size() - 1)
                break;
            long first = lList.get(x);
            Long second = lList.get(x + 1);
            print(x + 1 + ".", "compere teo long - first", first, "second", second, "result", lComparator.compare(first, second));
            x++;
        }

        Comparator<Double> dComparator = Comparator.comparingDouble(Double::doubleValue);
        print("Comparator<Double> dComparator = Comparator.comparingDouble(Double::doubleValue)");
        print("", dComparator.compare(0.12d, 1.201));
    }


    @Test
    public void test2() {
        // given
        List<Integer> list = Arrays.asList(12, -3, 0, 123, -99, 21, 0, 1);

        // when
        Comparator<Integer> comparator = Integer::compare;
        list.sort(comparator);

        // then
        assertEquals(-99, list.getFirst().intValue());
        assertEquals(123, list.getLast().intValue());
    }

    private final Comparator<String> COMPARING_STRING_BY_CHARACTER = (s1, s2) -> {
        char charX = 'x';
        return getNumberCharacterOccurrences(s2, charX) - getNumberCharacterOccurrences(s1, charX);
    };


    @Override
    public void simpleTest(String testDescription) {
        // given
        List<String> aStrings = Arrays.asList("718", "alex", "max", "xxx", "x_x_x_x", "anna");
        print("Before sorting:", aStrings);

        // when
        aStrings.sort(COMPARING_STRING_BY_CHARACTER);
        print("After sorting by number of char 'x':", aStrings);

        // then
        assertEquals("x_x_x_x", aStrings.get(0));
        assertEquals("anna", aStrings.get(5));
    }

    /**
     * Get the number of occurrences of a character
     */
    private int getNumberCharacterOccurrences(String str, char symbol) {
        return (int) str.chars() //
                .filter(c -> c == symbol) //
                .count();
    }
}
