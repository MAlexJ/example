package com.malex.lecture_5_math;

import lombok.extern.log4j.Log4j;

@Log4j
public class MathCell {

  public static void main(String[] args) {

    // #1 example: cell()
    methodCell();



  }

  private static void methodCell() {
    double ceil = Math.ceil(2.45);
    log.debug("Ceil: " + ceil);
  }
}
