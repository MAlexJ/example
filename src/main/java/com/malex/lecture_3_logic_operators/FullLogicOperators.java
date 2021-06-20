package com.malex.lecture_3_logic_operators;

import lombok.extern.java.Log;
import org.junit.Test;

import java.util.function.UnaryOperator;

import static org.mockito.Mockito.*;

/**
 * This class use of full logic operators like: || and &&
 */
@Log
public class FullLogicOperators {

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

    boolean checkFirstNumber(boolean b) {
        return b;
    }

    boolean checkSecondNumber(boolean b) {
        return b;
    }

    @Test
    public void runTest() {
        testSimpleOr(false, false, mock -> {
            verify(mock).checkFirstNumber(false);
            verify(mock).checkSecondNumber(false);
            return mock;
        });

        testSimpleOr(true, true, mock -> {
            verify(mock).checkFirstNumber(true);
            verify(mock, never()).checkSecondNumber(true);
            return mock;
        });

        testSimpleOr(true, false, mock -> {
            verify(mock).checkFirstNumber(true);
            verify(mock, never()).checkSecondNumber(false);
            return mock;
        });

        testSimpleOr(false, true, mock -> {
            verify(mock).checkFirstNumber(false);
            verify(mock).checkSecondNumber(true);
            return mock;
        });
    }

    private void testSimpleOr(boolean first, boolean second, UnaryOperator<FullLogicOperators> function) {
        FullLogicOperators mock = spy(FullLogicOperators.class);
        mock.simpleOr(first, second);
        function.apply(mock);
    }

}
