package com.malex.lecture_18_programming_idiom.loose_coupling_and_high_cohesion.cohesion;

import lombok.Getter;
import lombok.Setter;

/**
 * Cohesion is the degree to which elements inside a module belong together.
 *
 * <p>A module could be a class or a package or even a microservice.
 *
 * <p>Simply put, it means “the code that changes together, stays together”.
 */
public class Cohesion {

  /**
   * Module with high cohesion contains elements that are tightly related to each other and united in their purpose.
   */
  @Getter
  @Setter
  class _User_HighCohesion {
    private String name;
    private String email;
  }

  /**
   * A module is said to have low cohesion if it contains unrelated elements.
   */
  @Getter
  @Setter
  class _User_LowCohesion {
    private String name;
    private String email;

    void sendEmail() {
      // .......
    }

    boolean validateEmail() {
      // ......
      return false;
    }
  }
}
