package com.malex.lecture_12_sealed_and_permits.permits;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * link: https://docs.oracle.com/en/java/javase/17/language/sealed-classes-and-interfaces.html
 */
public class PermitsKeywordsInJava15 extends AbstractUtils {

  @Test
  public void test() {
    Animal hotDog = new HotDog();
    println("dog: " + hotDog);

    Animal cat = new Cat("Stefan");
    println("cat: " + cat);
  }
}
