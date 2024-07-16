package com.malex.lecture_23_Principles_of_Software_Development.solid.single_responsibility;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * Single Responsibility Principle
 *
 * <p>As the name suggests, this principle states that each class should have one responsibility,
 * one single purpose. This means that a class will do only one job, which leads us to conclude it
 * should have only one reason to change.
 */
public class BadPractice extends AbstractUtils {

  /**
   * For example, if we have a class that we change a lot, and for different reasons, then this
   * class should be broken down into more classes, each handling a single concern. Surely, if an
   * error occurs, it will be easier to find.
   *
   * <p>Although this may seem fine, it is not a good example of the SRP. Here we have two
   * responsibilities: manipulating and printing the text.
   */
  private static class TextManipulator {

    private String text;

    public TextManipulator(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }

    // responsibility: manipulating
    public void appendText(String newText) {
      text = text.concat(newText);
    }

    // responsibility: manipulating
    public String findWordAndReplace(String word, String replacementWord) {
      if (text.contains(word)) {
        text = text.replace(word, replacementWord);
      }
      return text;
    }

    // responsibility: manipulating
    public String findWordAndDelete(String word) {
      if (text.contains(word)) {
        text = text.replace(word, "");
      }
      return text;
    }

    // responsibility: printing
    public void printText() {
      printlnString(this.getText());
    }
  }

  @Test
  public void test() {
    var textManipulator = new TextManipulator("Hello!");
    textManipulator.findWordAndReplace("!", " world");
    textManipulator.appendText("!");
    textManipulator.printText();
  }
}
