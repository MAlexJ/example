package com.malex.lecture_2_statements.ExpressionStatements.lecture_3_logic_operators;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * The Java programming language guarantees that the operands of operators appear to be evaluated
 * in a specific evaluation order, namely, from left to right.
 *
 * boolean bool = isTrue1() | isFalse1() & isFalse2() ;
 *
 *  Becomes equivalent to
 *
 * boolean bool = isTrue1() | ( isFalse1() & isFalse2() ) ;
 *
 * Link https://stackoverflow.com/questions/21557124/logical-operator-precedence-in-java
 *
 */
public class LogicalOperatorPrecedence {

    @Getter
    private final List<String> result = new ArrayList<>();

    public boolean simpleMethodAndOr(String one, String two, String three) {
        return isTrue(one) && isTrue(two) || isTrue(three);
    }

    public boolean simpleMethodOrAnd(String one, String two, String three) {
        return isTrue(one) || isTrue(two) && isTrue(three);
    }

    public boolean fullMethodAndOr(String one, String two, String three) {
        return isTrue(one) & isTrue(two) | isTrue(three);
    }

    public boolean fullMethodOrAnd(String one, String two, String three) {
        return isTrue(one) | isTrue(two) & isTrue(three);
    }

    boolean isTrue(String val) {
        result.add(val);
        return true;
    }

    @Test
    public void runAllTests() {
        testMethodAndOr();
        testFullMethodAndOr();
        testMethodOrAnd();
        testFullMethodOrAnd();
    }

    @Test
    public void testMethodAndOr() {
        LogicalOperatorPrecedence logic = new LogicalOperatorPrecedence();
        logic.fullMethodAndOr("one", "two", "three");
        assertEquals(Lists.newArrayList("one", "two", "three"), logic.getResult());
    }

    @Test
    public void testFullMethodAndOr() {
        LogicalOperatorPrecedence logic = new LogicalOperatorPrecedence();
        logic.simpleMethodAndOr("one", "two", "three");
        assertEquals(Lists.newArrayList("one", "two"), logic.getResult());
    }

    @Test
    public void testMethodOrAnd() {
        LogicalOperatorPrecedence logic = new LogicalOperatorPrecedence();
        logic.simpleMethodOrAnd("one", "two", "three");
        assertEquals(Lists.newArrayList("one"), logic.getResult());
    }

    @Test
    public void testFullMethodOrAnd() {
        LogicalOperatorPrecedence logic = new LogicalOperatorPrecedence();
        logic.fullMethodOrAnd("one", "two", "three");
        assertEquals(Lists.newArrayList("one", "two", "three"), logic.getResult());
    }
}
