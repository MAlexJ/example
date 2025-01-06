package com.malex.lecture_2_statements.ExpressionStatements.lecture_3_logic_operators;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/*
 * The Java programming language guarantees that the operands of operators appear to be evaluated in
 * a specific evaluation order, namely, from left to right.
 *
 * boolean bool = isTrue1() | isFalse1() & isFalse2() ;
 *
 * Becomes equivalent to
 *
 * boolean bool = isTrue1() | ( isFalse1() & isFalse2() ) ;
 *
 * Link https://stackoverflow.com/questions/21557124/logical-operator-precedence-in-java
 */
public class LogicalOperatorPrecedence extends AbstractUtils {

  public static final String ONE = "one";
  public static final String TWO = "two";
  public static final String THREE = "three";

  @Test
  public void runAllTests() {
    test_and_with_or_operators();
    test_full_and_with_or_operators();
    test_or_with_and_operators();
    test_full_or_with_and_operators();
  }

  @Test
  public void test_and_with_or_operators() {
    // given
    var state = and_with_or(ONE, TWO, THREE);

    // and
    println("result:", state, "\n");

    // then
    assertEquals(List.of(ONE, TWO), state);
  }

  @Test
  public void test_full_and_with_or_operators() {
    // given
    var state = full_and_with_or(ONE, TWO, THREE);

    // and
    println("result:", state, "\n");

    // then
    assertEquals(List.of(ONE, TWO, THREE), state);
  }

  @Test
  public void test_or_with_and_operators() {
    // given
    var state = or_with_and(ONE, TWO, THREE);
    println("result:", state, "\n");

    // then
    assertEquals(List.of(ONE), state);
  }

  @Test
  public void test_full_or_with_and_operators() {
    // given
    var state = full_or_with_and(ONE, TWO, THREE);
    println("result:", state, "\n");

    // then
    assertEquals(List.of(ONE, TWO, THREE), state);
  }

  private List<String> and_with_or(String one, String two, String three) {
    var collector = new ArrayList<String>();

    // expression
    boolean result = isTrue(one, collector) && isTrue(two, collector) || isTrue(three, collector);

    println("Expression:", "true && true || " + result);
    return collector;
  }

  private List<String> or_with_and(String one, String two, String three) {
    var collector = new ArrayList<String>();

    // expression
    boolean result = isTrue(one, collector) || isTrue(two, collector) && isTrue(three, collector);

    println("Expression:", "true || true && " + result);
    return collector;
  }

  private List<String> full_and_with_or(String one, String two, String three) {
    var collector = new ArrayList<String>();

    // expression
    boolean result = isTrue(one, collector) & isTrue(two, collector) | isTrue(three, collector);

    println("Expression:", "true & true | " + result);
    return collector;
  }

  private List<String> full_or_with_and(String one, String two, String three) {
    var collector = new ArrayList<String>();

    // expression
    boolean result = isTrue(one, collector) | isTrue(two, collector) & isTrue(three, collector);

    println("Expression:", "true | true & " + result);
    return collector;
  }

  private boolean isTrue(String val, List<String> collector) {
    collector.add(val);
    return true;
  }
}
