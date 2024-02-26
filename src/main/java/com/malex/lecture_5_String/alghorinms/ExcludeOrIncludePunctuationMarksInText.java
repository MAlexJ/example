package com.malex.lecture_5_String.alghorinms;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

/**
 * Here are the punctuation marks in English: <br>
 * <br>
 * Period (.)<br>
 * Comma (,)<br>
 * Question mark (?)<br>
 * Exclamation mark (!)<br>
 * Colon (:)<br>
 * Semicolon (;)<br>
 * Quotation marks (" ")<br>
 * Apostrophe (')<br>
 * Ellipsis (...)<br>
 * Dash (-)<br>
 * Parentheses (())<br>
 * Brackets ([])<br>
 */
public class ExcludeOrIncludePunctuationMarksInText {

  @Test
  public void testExcludePunctuationMarks() {
    assertEquals("test", excludePunctuationMarks(".test!.,?"));
    assertEquals("test", excludePunctuationMarks(".test!..."));
    assertEquals("test", excludePunctuationMarks("---.test-"));
    assertEquals("test", excludePunctuationMarks("(()))))test{}}}}"));
    assertEquals("xxx", excludePunctuationMarks(":;:;\"\"xxx!.,?"));
  }

  @Test
  public void testFindALlPunctuationMarks() {
    assertEquals(".!.,?", findAllPunctuationMarksInText(".test!.,?"));
    assertEquals(":;!?.!}(.,?", findAllPunctuationMarksInText(":;!?.test!}(.,?"));
  }

  /** The \\p{P} pattern matches any Unicode punctuation character. */
  private String excludePunctuationMarks(String word) {
    return word.replaceAll("\\p{P}", "");
  }

  /**
   * Define a regex pattern to match all punctuation marks pattern: Pattern.compile("[^\\p{P}\\s]");
   */
  private String findAllPunctuationMarksInText(String word) {
    return word.replaceAll("[^\\p{P}\\s]", "");
  }
}
