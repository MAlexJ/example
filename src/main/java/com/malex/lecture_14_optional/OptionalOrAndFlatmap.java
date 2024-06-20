package com.malex.lecture_14_optional;

import java.util.Optional;

import org.junit.Test;

import com.malex.utils.AbstractUtils;

public class OptionalOrAndFlatmap extends AbstractUtils {

    @Test
    public void orAndFlatmap(){

        Optional.ofNullable("text")
                .filter(text -> !text.isBlank());
//                .or()


    }
}
