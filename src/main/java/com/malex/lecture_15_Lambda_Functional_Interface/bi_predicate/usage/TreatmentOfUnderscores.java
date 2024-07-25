package com.malex.lecture_15_Lambda_Functional_Interface.bi_predicate.usage;

import java.util.function.BiFunction;

import org.junit.Test;

/*
* Treatment of underscores ( JEP 302 )
*
* link: http://openjdk.org/jeps/302
*
* In many languages, it is common to use an underscore (_) to denote an unnamed lambda parameter
* (and similarly for method and exception parameters):

    BiFunction<Integer, String, String> biss = (i, _) -> String.valueOf(i);

 * This allows stronger static checking of unused arguments,
 * and also allows multiple arguments to be marked as unused.
 */
public class TreatmentOfUnderscores {

    @Test
    public void test(){
        BiFunction<Integer, String, String> biss = (i, _) -> String.valueOf(i);
    }

}
