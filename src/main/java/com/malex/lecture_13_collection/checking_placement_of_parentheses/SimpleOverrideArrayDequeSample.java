package com.malex.lecture_13_collection.checking_placement_of_parentheses;

import com.google.common.collect.Lists;
import lombok.NonNull;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.*;

public class SimpleOverrideArrayDequeSample {

    @Test
    public void allTests() {
        exceptionTest();
        incorrectParenthesesTest();
        simpleTest();
    }

    @Test
    public void exceptionTest() {
        System.out.println((int) '[');
        System.out.println((int) ']');
        for (String parentheses : Lists.newArrayList("", null)) {
            try {
                isValid(parentheses);
                fail();
            } catch (IllegalArgumentException ex) {
                //
            }
        }
    }

    @Test
    public void incorrectParenthesesTest() {
        List<String> incorrectParentheses = Lists.newArrayList("[",
                "(",
                "{",
                "{()",
                "{()))",
                "))",
                "}{"
        );
        for (String parentheses : incorrectParentheses) {
            assertFalse(isValid(parentheses));
        }
    }

    @Test
    public void simpleTest() {
        List<String> parenthesesList = Lists.newArrayList("[]", "()", "{}",
                "(())", "([{}])",
                "()()", "{}()[]",
                "({}([]){}[]){[()]()}"
        );
        for (String parentheses : parenthesesList) {
            assertTrue(isValid(parentheses));
        }
    }

    public boolean isValid(String parentheses) {
        if (Objects.isNull(parentheses) || parentheses.length() == 0) {
            throw new IllegalArgumentException();
        }

        Deque<Integer> deque = new ArrayDeque<>() {
            private final Set<Integer> openBrackets = Set.of(0x28, 0x5b, 0x7b);
            private final Set<Integer> closeBrackets = Set.of(0x29, 0x5d, 0x7d);

            @Override
            public boolean add(@NonNull Integer bracket) {
                return openBrackets.contains(bracket)
                        // add open bracket
                        ? offer(bracket)
                        // otherwise, attempt to retrieve and remove last element of this deque
                        : tryPollLast(bracket);
            }

            private boolean tryPollLast(Integer closeBracket) {
                boolean isAbsent = !closeBrackets.contains(closeBracket);
                boolean isDequeNotEmpty = !isEmpty();

                /*
                 example:
                    1. char '{' is 123 and char '}' is 125, condition 125 - 123 < 3 is true
                    2. char '(' is 40 and char ')' is 41, condition 41 - 40 < 3 is true
                    3. char '[ is 91 and char ']' is 93, condition 93 - 91 < 3 is true
                 */
                boolean calculateShiftBetweenBrackets = closeBracket - pollLastOpenBracket() < 3;
                return isAbsent || (isDequeNotEmpty && calculateShiftBetweenBrackets);
            }

            private Integer pollLastOpenBracket() {
                return Optional.ofNullable(pollLast())
                        .orElse(0);
            }
        };
        return parentheses.chars()
                .allMatch(deque::add) && deque.isEmpty();
    }
}
