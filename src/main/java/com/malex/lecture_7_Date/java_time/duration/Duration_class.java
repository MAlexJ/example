package com.malex.lecture_7_Date.java_time.duration;

import java.time.Duration;

import org.junit.Test;

import com.malex.utils.AbstractUtils;

public class Duration_class extends AbstractUtils {

    @Test
    public void init(){
        Duration zero = Duration.ZERO;
        println("zero: ", zero);
    }
}
