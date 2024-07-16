package com.malex.lecture_23_Principles_of_Software_Development.solid.single_responsibility;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class BestPractice extends AbstractUtils {

  @Test
  public void test() {
    var textManipulator = new TextManipulator("Hello");

    var textPrinter = new TextPrinter(textManipulator);
    textPrinter.printRangeOfCharacters(1, 5);

    textManipulator.appendText(" world!");
    textPrinter.printText();
  }

  private class TextManipulator {

    private String text;

    TextManipulator(String text) {
      this.text = text;
    }

    String getText() {
      return text;
    }

    void appendText(String newText) {
      text = text.concat(newText);
    }

    String findWordAndReplace(String word, String replacementWord) {
      if (text.contains(word)) {
        text = text.replace(word, replacementWord);
      }
      return text;
    }
  }

  private class TextPrinter {

    private TextManipulator textManipulator;

    TextPrinter(TextManipulator textManipulator) {
      this.textManipulator = textManipulator;
    }

    public void printText() {
      printlnString(textManipulator.getText());
    }

    public void printRangeOfCharacters(int startingIndex, int endIndex) {
      printlnString(textManipulator.getText().substring(startingIndex, endIndex));
    }
  }
}
