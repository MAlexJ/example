package com.malex.lecture_2_statements.ExpressionStatements.lecture_3_logic_operators;

import lombok.extern.java.Log;
import org.junit.Test;

import java.util.function.UnaryOperator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * This class use of full logic operators like: || and &&
 */
@Log
public class LogicalOperatorTruthTable {

    // -------------------------
    //   A   |    B   |  A || B
    // -------------------------
    // True  | False  |  True
    // False | True   |  True
    // False | False  |  False
    // True  | True   |  True
    boolean simpleOr(boolean one, boolean two) {
        return checkFirstNumber(one) || checkSecondNumber(two);
    }

    // -------------------------
    //   A   |    B   |  A && B
    // -------------------------
    // True  | False  |  False
    // False | True   |  False
    // False | False  |  False
    // True  | True   |  True
    boolean simpleAnd(boolean one, boolean two) {
        return checkFirstNumber(one) && checkSecondNumber(two);
    }

    // -------------------------
    //   A   |    B   |  A ^ B
    // -------------------------
    // False | False  |  False
    // True  | False  |  True
    // False | True   |  True
    // True  | True   |  False
    boolean simpleXor(boolean one, boolean two) {
        return checkFirstNumber(one) ^ checkSecondNumber(two);
    }

    boolean checkFirstNumber(boolean b) {
        return b;
    }

    boolean checkSecondNumber(boolean b) {
        return b;
    }

    @Test
    public void runALl() {
        runAndTest();
        runOrTest();
        runXorTest();
    }

    @Test
    public void runXorTest() {
        testSimpleXor(true, true, mock -> {
            verify(mock).checkFirstNumber(true);
            verify(mock).checkSecondNumber(true);
            assertFalse(mock.simpleXor(anyBoolean(), anyBoolean()));
            return mock;
        });

        testSimpleXor(false, false, mock -> {
            verify(mock).checkFirstNumber(false);
            verify(mock).checkSecondNumber(false);
            assertFalse(mock.simpleXor(anyBoolean(), anyBoolean()));
            return mock;
        });


        testSimpleXor(true, false, mock -> {
            verify(mock).checkFirstNumber(true);
            verify(mock).checkSecondNumber(false);
            assertTrue(mock.simpleXor(true, false));
            return mock;
        });

        testSimpleXor(false, true, mock -> {
            verify(mock).checkFirstNumber(false);
            verify(mock).checkSecondNumber(true);
            assertTrue(mock.simpleXor(false, true));
            return mock;
        });
    }

    @Test
    public void runAndTest() {
        testSimpleAnd(true, true, mock -> {
            verify(mock).checkFirstNumber(true);
            verify(mock).checkSecondNumber(true);
            return mock;
        });

        testSimpleAnd(true, false, mock -> {
            verify(mock).checkFirstNumber(true);
            verify(mock).checkSecondNumber(false);
            return mock;
        });

        testSimpleAnd(false, false, mock -> {
            verify(mock).checkFirstNumber(false);
            verify(mock, never()).checkSecondNumber(false);  // TODO << never call
            return mock;
        });

        testSimpleAnd(false, true, mock -> {
            verify(mock).checkFirstNumber(false);
            verify(mock, never()).checkSecondNumber(true);  // TODO << never call
            return mock;
        });
    }

    @Test
    public void runOrTest() {
        testSimpleOr(false, false, mock -> {
            verify(mock).checkFirstNumber(false);
            verify(mock).checkSecondNumber(false);
            return mock;
        });

        testSimpleOr(true, true, mock -> {
            verify(mock).checkFirstNumber(true);
            verify(mock, never()).checkSecondNumber(true);  // TODO << never call
            return mock;
        });

        testSimpleOr(true, false, mock -> {
            verify(mock).checkFirstNumber(true);
            verify(mock, never()).checkSecondNumber(false);   // TODO << never call
            return mock;
        });

        testSimpleOr(false, true, mock -> {
            verify(mock).checkFirstNumber(false);
            verify(mock).checkSecondNumber(true);
            return mock;
        });
    }

    private void testSimpleOr(boolean first, boolean second, UnaryOperator<LogicalOperatorTruthTable> function) {
        LogicalOperatorTruthTable spy = spy(LogicalOperatorTruthTable.class);
        simpleOr(first, second);
        function.apply(spy);
    }

    private void testSimpleAnd(boolean first, boolean second, UnaryOperator<LogicalOperatorTruthTable> function) {
        LogicalOperatorTruthTable spy = spy(LogicalOperatorTruthTable.class);
        simpleAnd(first, second);
        function.apply(spy);
    }

    private void testSimpleXor(boolean first, boolean second, UnaryOperator<LogicalOperatorTruthTable> function) {
        LogicalOperatorTruthTable spy = spy(LogicalOperatorTruthTable.class);
        simpleXor(first, second);
        function.apply(spy);
    }

}
