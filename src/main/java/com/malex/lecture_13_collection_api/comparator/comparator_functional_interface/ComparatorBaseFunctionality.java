package com.malex.lecture_13_collection_api.comparator.comparator_functional_interface;

import com.malex.lecture_13_collection_api.comparator.utils.AbstractComparatorTestUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * The general contract of the compareTo method is similar to that of equals:
 * Compares this object with the specified object for order.
 * Returns a negative integer, zero, or a positive integer as this object is less than,
 * equal to, or greater than the specified object.
 */
public class ComparatorBaseFunctionality extends AbstractComparatorTestUtils {

    private final Comparator<Cat> AGE_COMPARATOR = Comparator.comparingInt(c -> c.age);

    @Override
    public void simpleTest(String testDescription) {
        var cat1 = new Cat(8, "Stefan");
        var cat2 = new Cat(2, "Tom");
        var cat3 = new Cat(5, "Murzik");
        var cat4 = new Cat(5, "Barsik");
        var cat5 = new Cat(12, "XyliMay");

        List<Cat> cats = Arrays.asList(cat1, cat2, cat3, cat4, cat5);
        print("Cats", cats);

        print("Age", cat1.age, ">", cat2.age, ", comparator value =", AGE_COMPARATOR.compare(cat1, cat2));
        assertEquals(1, AGE_COMPARATOR.compare(cat1, cat2));

        print("Age", cat2.age, ">", cat5.age, ", comparator value =", AGE_COMPARATOR.compare(cat2, cat5));

        print("Age", cat3.age, "=", cat4.age, ", comparator value =", AGE_COMPARATOR.compare(cat3, cat4));
        assertEquals(0, AGE_COMPARATOR.compare(cat3, cat4));
    }


    /**
     * 1. The implementor must ensure that sgn(x.compareTo(y)) == -sgn(y. compareTo(x)) for all x and y.
     * (This implies that x.compareTo(y) must throw an exception if and only if y.compareTo(x) throws an exception.)
     */
    @Test
    public void antisymmetryTest() {
        // given
        var cat1 = new Cat(3, "Stefan");
        var cat2 = new Cat(5, "Tom");

        // when
        Comparator<Cat> comparator = Comparator.comparingInt(Cat::age);

        //then
        assertEquals(comparator.compare(cat1, cat2), -comparator.compare(cat2, cat1));
    }


    /**
     * Finally, the implementor must ensure that x.compareTo(y) == 0
     * implies that sgn(x.compareTo(z)) == sgn(y.compareTo(z)), for all z
     */
    @Test
    public void equalitySignTest() {
        // given
        var cat1 = new Cat(5, "Stefan");
        var cat2 = new Cat(5, "Tom");
        var cat3 = new Cat(5, "Murzik");

        // when
        Comparator<Cat> comparator = Comparator.comparingInt(Cat::age);

        // then
        assertTrue(comparator.compare(cat1,cat2) == 0);
        // and
        assertTrue(comparator.compare(cat3,cat1) == 0);
        // and
        assertTrue(comparator.compare(cat3,cat2) == 0);
    }


    /**
     * The implementor must also ensure that the relation is transitive: (x.compareTo(y) > 0 && y.compareTo(z) > 0)
     * implies x.compareTo(z) > 0.
     */
    @Test
    public void transitivityTest() {
        // given
        var cat1 = new Cat(8, "Stefan");
        var cat2 = new Cat(5, "Tom");
        var cat3 = new Cat(3, "Murzik");

        // then
        Comparator<Cat> comparator = Comparator.comparingInt(Cat::age);

        // when
        assertTrue(comparator.compare(cat1, cat2) > 0);
        // and
        assertTrue(comparator.compare(cat2, cat3) > 0);
        // and
        assertTrue(comparator.compare(cat1, cat3) > 0);
    }


    private record Cat(int age, String name) {
    }
}
