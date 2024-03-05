package com.malex.lecture_15_Lambda.consumer;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import lombok.extern.java.Log;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.BiConsumer;

import static junit.framework.TestCase.assertTrue;

/**
 * BiConsumer - It represents a function which takes in two arguments and produces a result.
 * However these kind of functions don’t return any value.
 * link: https://www.geeksforgeeks.org/java-8-biconsumer-interface-in-java-with-examples/
 * <p>
 * BiConsumer - Represents an operation that accepts two input arguments and returns no  result.
 * This is the two-arity specialization of {@code Consumer}.
 * Unlike most other functional interfaces, {@code BiConsumer} is expected to operate via side-effects.
 * <p>
 * Base methods:
 * 1. void accept(T t, U u);
 * 2. default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after)
 */
@Log
public class BiConsumerInterface {

    public void iterateCollections(Collection<String> strs, BiConsumer<Integer, String> consumer) {
        int position = 0;
        for (String s : strs) {
            if (Strings.isNullOrEmpty(s)) {
                continue;
            }
            consumer.accept(position, s);
            position++;
        }
    }

    @Test
    public void test1() {
        Collection<String> list = Arrays.asList("A", "", "B", "C");
        iterateCollections(list, (position, val) ->
        {
            log.info(val);
            assertTrue(val != null && !val.isEmpty());
        });
    }

    @Test
    public void test2() {
        Collection<String> list = Lists.newArrayList("A", "", "B", "C");
        iterateCollections(list, (position, val) ->
        {
            switch (val) {
                case "A":
                case "B":
                case "C": {
                    log.info(val);
                    break;
                }
                default:
                    throw new IllegalArgumentException("Not found item");
            }
        });
    }

}
