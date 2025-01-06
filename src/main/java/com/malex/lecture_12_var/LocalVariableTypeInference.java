package com.malex.lecture_12_var;

import java.io.Reader;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/*
 * The Java Local Variable Type Inference (LVTI)
 * Java 10
 *
 * Links: https://openjdk.org/jeps/286
 * https://habr.com/ru/articles/438206/
 * https://habr.com/ru/companies/otus/articles/688722/
 */
public class LocalVariableTypeInference extends AbstractUtils {

  @Test
  public void run() {
    var string = "Hello World";
    var integer = 1;
    var object = new Object();


    // using var
    var intNumber = Integer.class;
    var fileReader = Reader.class;


  }
}
