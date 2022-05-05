package com.malex.lecture_13_generic.example_wildcard;

import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;

/**
 * In generic code, the question mark (?), called the wildcard, represents an unknown type. The
 * wildcard can be used in a variety of situations: - as the type of a parameter, field, or local
 * variable; - sometimes as a return type (though it is better programming practice to be more
 * specific).
 *
 * <p>The wildcard is never used as a type argument for a generic method invocation, a generic class
 * instance creation, or a supertype.
 */
@Log
public class SimpleWildcard {

    /**
     * The unbounded wildcard type is specified using the wildcard character (?), for example,
     * List<?>. This is called a list of unknown type. There are two scenarios where an unbounded
     * wildcard is a useful approach: If you are writing a method that can be implemented using
     * functionality provided in the Object class. - When the code is using methods in the generic
     * class that don't depend on the type parameter. For example, List.size or List.clear. - In fact,
     * Class<?> is so often used because most of the methods in Class<T> do not depend on T.
     */
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String> ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);

        calculateSum(Arrays.asList(1, 2, 3));
        calculateSum(Arrays.asList(Byte.MIN_VALUE, 2, 3));
        calculateSum(Arrays.asList(Long.MAX_VALUE, 2L, 3L));
        calculateSum(Arrays.asList(Double.MAX_VALUE, 2.76, 36.54));
        calculateSum(Arrays.asList(Float.MAX_VALUE, 2.76, 36.54));
    }

    /**
     * The goal of printList is to print a list of any type, but it fails to achieve that goal — it
     * prints only a list of Object instances; it cannot print List<Integer>, List<String>,
     * List<Double>, and so on, because they are not subtypes of List<Object>. To write a generic
     * printList method, use List<?>
     */
    private static void printList(List<?> list) { // if set `List<T> list`, then an error occurs.
        list.forEach(item -> log.info(item.toString()));
        log.info("size: " + list.size());
    }

    private static void calculateSum(List<? extends Number> list) {
        Number firstValue = list.stream().findFirst().orElseThrow(RuntimeException::new);
        log.info("first: " + firstValue);
    }
}
