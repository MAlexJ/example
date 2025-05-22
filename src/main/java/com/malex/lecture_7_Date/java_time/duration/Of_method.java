package com.malex.lecture_7_Date.java_time.duration;

import java.time.Duration;

import org.junit.Test;

import com.malex.utils.AbstractUtils;

/*
* PT3M15S (ISO 8601 format)
 */
public class Of_method extends AbstractUtils {

    @Test
    public void of(){
        Duration d1 = Duration.ofSeconds(30);
        Duration d2 = Duration.ofMinutes(5);
        Duration d3 = Duration.ofHours(2);
        Duration d4 = Duration.ofMillis(500);

        println("d1: ", d1);
        println("d2: ", d2);
        println("d3: ", d3);
        println("d4: ", d4);
    }

    @Test
    public void plus(){
        Duration d = Duration.ofMinutes(2).plusSeconds(30);
        println("d: ", d);
    }
}
