package com.malex.lecture_13_collection_api.algoritms.checking_placement_of_parentheses;

import static junit.framework.TestCase.*;

import java.util.*;
import java.util.stream.Stream;
import org.junit.Test;

/** Example of solutions: https://www.cyberforum.ru/java-j2se/thread1221665.html */
public class CheckingPlacementOfParenthesesInString {

  @Test
  public void allTests() {
    exceptionTest();
    incorrectParenthesesTest();
    simpleTest();
  }

  @Test
  public void exceptionTest() {
    for (String parentheses : List.of("", null)) {
      try {
        checkingParentheses(parentheses);
        fail();
      } catch (IllegalArgumentException ex) {
        //
      }
    }
  }

  @Test
  public void incorrectParenthesesTest() {
    List<String> incorrectParentheses = List.of("[", "(", "{", "{()", "{()))", "))", "}{");
    for (String parentheses : incorrectParentheses) {
      assertFalse(checkingParentheses(parentheses));
    }
  }

  @Test
  public void simpleTest() {
    List<String> parenthesesList =
        List.of("[]", "()", "{}", "(())", "([{}])", "()()", "{}()[]", "({}([]){}[]){[()]()}");
    for (String parentheses : parenthesesList) {
      assertTrue(checkingParentheses(parentheses));
    }
  }

  public record Bracket(Character open, Character close) {}

  private List<Bracket> initBrackets() {
    var type1 = new Bracket('(', ')');
    var type2 = new Bracket('{', '}');
    var type3 = new Bracket('[', ']');
    return Stream.of(type1, type2, type3).toList();
  }

  private boolean checkingParentheses(String parentheses) {
    if (Objects.isNull(parentheses) || parentheses.length() == 0) {
      throw new IllegalArgumentException();
    }

    if (parentheses.length() % 2 == 1) {
      return false;
    }

    List<Bracket> brackets = initBrackets();
    char[] charArray = parentheses.toCharArray();
    if (findCloseBracket(charArray[0], brackets).isPresent()) {
      return false;
    }

    Deque<Bracket> stack = new LinkedList<>();
    for (char bracket : charArray) {
      findOpenBracket(bracket, brackets).ifPresent(stack::push);
      findCloseBracket(bracket, brackets)
          .ifPresent(
              closeBracket ->
                  Optional.ofNullable(stack.peek())
                      .ifPresent(
                          peekBracket -> {
                            if (peekBracket.equals(closeBracket)) {
                              stack.pop();
                            }
                          }));
    }
    return stack.isEmpty();
  }

  private Optional<Bracket> findOpenBracket(char bracket, List<Bracket> brackets) {
    return brackets.stream().filter(br -> br.open().equals(bracket)).findFirst();
  }

  private Optional<Bracket> findCloseBracket(char bracket, List<Bracket> brackets) {
    return brackets.stream().filter(br -> br.close().equals(bracket)).findFirst();
  }
}
