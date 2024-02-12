package com.malex.lecture_5_String.feature;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * @since Lava 13
 * topic: JEP 355: Text Blocks
 *
 * <p>Add text blocks to the Java language. <br>
 * A text block is a multi-line string literal that avoids the need for most escape sequences,
 * automatically formats the string in a predictable way, and gives the developer control over
 * format when desired. <br>
 * This is a preview language feature in JDK 13.
 *
 * <p>link: <a href="https://openjdk.org/jeps/355">JEP 355: Text Blocks</a>
 */
public class TextBlocksJava13 extends AbstractUtils {

  private static final String FEATURE = """
line1
line2
line3
""";

  @Test
  public void run() {
    println(FEATURE);

    String html =
        """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;

    println(html);
  }
}
