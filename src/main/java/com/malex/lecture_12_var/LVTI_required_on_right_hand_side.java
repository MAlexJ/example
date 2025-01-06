package com.malex.lecture_12_var;

import org.junit.Test;

/*
 * Q6. Why is an initializer required on the right-hand side of var?
 *
 * link: https://openjdk.org/projects/amber/guides/lvti-faq
 *
 * The type of the variable is inferred from the type of the initializer.
 * This means, of course, that var can only be used when there is an initializer.
 * We could have chosen to infer the type from the assignments to the variable,
 * but that would have made the feature considerably more complex, and it could potentially lead to misleading
 * or hard-to-diagnose errors.
 * In order to keep things simple, we’ve defined var so that only local information is used for type inference.
 *
 * To avoid these problems, it seems preferable to require that the type be inferred using an explicit initializer.
 *
 */
public class LVTI_required_on_right_hand_side {

  @Test
  public void run() {
    /*
     * NOTE: initializer required on the right-hand side of var
     */

    //    var order;        << - error
    //    order = "first";
    //    order = 2;
  }
}
