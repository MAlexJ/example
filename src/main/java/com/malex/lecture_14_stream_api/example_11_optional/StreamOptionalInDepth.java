package com.malex.lecture_14_stream_api.example_11_optional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;

/**
 * Java 8 has introduced a new class Optional in java.util package. It is used to represent a value is present or absent.
 * <p>
 * Advantages of Java 8 Optional:
 * 1.  Null checks are not required.
 * 2.  No more NullPointerException at run-time.
 * 3.  We can develop clean and neat APIs.
 * 4.  No more Boiler plate code
 */
public class StreamOptionalInDepth {

    @Test
    public void testOfNullable(){
        Optional<String> opt = Optional.ofNullable(null);
        assertFalse(opt.isPresent());
    }

    @Test(expected = NoSuchElementException.class)
    public void testOfNullableGetElement(){
        Optional<String> opt = Optional.ofNullable(null);
        opt.get();
    }

    @Test(expected = NullPointerException.class)
    public void testOfIfValueIsNull(){
        Optional<String> opt = Optional.of(null);
        opt.isPresent();
    }

    @Test
    public void testOfNullableIfPresent(){
        Optional<String> opt = Optional.ofNullable(null);
        opt.ifPresent(e -> System.out.println(e + "sdgg"));
    }

}
