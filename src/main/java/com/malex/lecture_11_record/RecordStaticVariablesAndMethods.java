package com.malex.lecture_11_record;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * Tutorial: Tutorial: Java 14 Record Keyword
 *
 * <p>link: <a href="https://www.baeldung.com/java-record-keyword#static">Static Variables &
 * Methods</a>
 */
public class RecordStaticVariablesAndMethods extends AbstractUtils {

  @Test
  public void sample() {
    String template = MRecord.TEMPLATE;
    println("MRecord.TEMPLATE :", template);

    String method = MRecord.staticMethod();
    println("static method :", method);

    var mRecord = new MRecord();
    IntStream.range(0, 5).forEach(num -> assertEquals(num, mRecord.noneStaticMethod(num)));
  }

  private record MRecord() {

    private static final String TEMPLATE = "String template";

    private static String staticMethod() {
      return TEMPLATE;
    }

    public int noneStaticMethod(int num) {
      return num;
    }
  }
}
