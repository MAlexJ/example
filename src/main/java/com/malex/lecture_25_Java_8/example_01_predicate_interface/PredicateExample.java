package com.malex.lecture_25_Java_8.example_01_predicate_interface;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.awt.Color.*;

/**
 * Predicate represents a predicate, which is boolean-valued function, of one argument.
 * Source: http://www.java2s.com/Tutorials/Java/java.util.function/Predicate/index.htm
 */
@Log4j
public class PredicateExample {

    private static final String TEMPLATE_FORMAT = "The string `%s` is contains char `j` or 'J' : %s \n";
    private static final String TEMPLATE_FORMAT_UPPERCASE = "%S";

    private static Predicate<BoxInventory> isBlack = box -> box.getColor() == BLACK;
    private static Predicate<BoxInventory> isWhite = box -> box.getColor() == WHITE;

    private static Predicate<BoxInventory> isWeight(int weight) {
        return box -> box.getWeight() == weight;
    }

    @Test
    public void test() {
        // example #1
        simpleExample();

        // example #2
        createPredicate();
    }

    /**
     * Example #1
     * The following example shows how to use the method `test` of Predicate
     */
    private static void simpleExample() {
        String condition = "j";
        Stream<String> stringStream = Stream.of("Java", "JS", "Bootstrap", "Node", "js script");

        Predicate<String> predicate =
                (str) ->
                        str.contains(condition) ||
                                str.contains(String.format(TEMPLATE_FORMAT_UPPERCASE, condition));
        stringStream
                .forEach(str -> System.out.printf(TEMPLATE_FORMAT, str, predicate.test(str)));
    }

    /**
     * Example #2
     * The following code shows how to create Predicate from method reference and lambda.
     */
    private static void createPredicate() {
        List<BoxInventory> inventories = Stream.of(
                new BoxInventory(4, BLACK),
                new BoxInventory(11, GREEN),
                new BoxInventory(34, GREEN),
                new BoxInventory(12, BLACK),
                new BoxInventory(11, WHITE),
                new BoxInventory(23, BLACK)
        ).collect(Collectors.toList());

        List<BoxInventory> filterBlacks = filter(inventories, isBlack);
        log.debug("Blacks: " + filterBlacks);

        List<BoxInventory> filterWhites = filter(inventories, isWhite);
        log.debug("Whites: " + filterWhites);

        List<BoxInventory> filterWeight = filter(inventories, isWeight(new Random().nextInt(11)));
        log.debug("Weight: " + filterWeight);
    }

    private static List<BoxInventory> filter(List<BoxInventory> inventory, Predicate<BoxInventory> predicate) {
        return inventory
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());

    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    private static class BoxInventory {
        private int weight;
        private Color color;
    }

}
