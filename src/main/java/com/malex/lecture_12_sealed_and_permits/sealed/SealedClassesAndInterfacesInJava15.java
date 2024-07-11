package com.malex.lecture_12_sealed_and_permits.sealed;

import com.malex.utils.AbstractUtils;
import lombok.ToString;
import org.junit.Test;

/**
 * Sealed Classes and Interfaces in Java
 *
 * <p>link: <a href="https://www.baeldung.com/java-sealed-classes-interfaces">Sealed Classes and
 * Interfaces</a>
 *
 * <p>link: <a href="https://habr.com/ru/companies/otus/articles/720044/">Sealed classes Java in
 * action</a>
 */
public class SealedClassesAndInterfacesInJava15 extends AbstractUtils {

  @Test
  public void test() {
    Loan securedLoan = new SecuredLoan();
    println("secured loan: " + securedLoan);

    Loan unsecuredLoan = new UnsecuredLoan("UnsecuredLoan");
    println("unsecured loan:", unsecuredLoan);
  }

  private sealed interface Loan {}

  @ToString
  private final class SecuredLoan implements Loan {
    private String name = "SecuredLoan";
  }

  private record UnsecuredLoan(String name) implements Loan {}
}
