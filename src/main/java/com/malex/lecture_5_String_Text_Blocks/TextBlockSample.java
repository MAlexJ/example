package com.malex.lecture_5_String_Text_Blocks;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class TextBlockSample extends AbstractUtils {

  @Test
  public void test() {
    String str =
        """
Hello
Stefan!
""";

    println(str);
  }
}
