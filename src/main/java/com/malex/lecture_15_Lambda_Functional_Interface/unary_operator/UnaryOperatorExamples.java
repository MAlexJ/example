package com.malex.lecture_15_Lambda_Functional_Interface.unary_operator;

import com.google.common.collect.Lists;
import lombok.extern.java.Log;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * In Java 8, UnaryOperator is a functional interface and it extends Function.
 * The UnaryOperator takes one argument, and returns a result of the same type of its arguments.
 * The Function takes one argument of any type and returns a result of any type.
 *
 * @FunctionalInterface public interface Function<T, R> {
 * R apply(T t);
 * }
 * @FunctionalInterface public interface UnaryOperator<T> extends Function<T, T>
 * Returns a unary operator that always returns its input argument.
 * static<T> UnaryOperator<T>
 * identity(){  return t->t; }
 */
@Log
public class UnaryOperatorExamples {

    @Test
    public void testIdentity() {
        UnaryOperator<Boolean> func = UnaryOperator.identity();
        log.info("first: " + func.apply(true));
        log.info("second: " + func.apply(false));
    }

    @Test
    public void test() {
        Function<Integer, Integer> func = x -> x + 1;
        log.info("Function: " + func.apply(1));

        UnaryOperator<Integer> uFunction = x -> x - 1;
        log.info("Function: " + uFunction.apply(1));
    }

    @Test
    public void applyTest() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        log.info("Init: " + list);

        List<Integer> result = math(list, x -> x + 1);
        log.info("Result: " + result);
    }

    private <T> List<T> math(List<T> list, UnaryOperator<T> func) {
        return list.stream() //
                .map(func) //
                .collect(Collectors.toList());
    }

    @Test
    public void chainApplyTest() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        log.info("Init: " + list);

    }

    private <T> List<T> applyChainFunc(List<T> list, UnaryOperator<T> first, //
                                       UnaryOperator<T> second, //
                                       UnaryOperator<T> third) {
        return list.stream() //
                .map(t -> first //
                        .andThen(second) //
                        .andThen(third) //
                        .apply(t))  //
                .collect(Collectors.toList());
    }

}