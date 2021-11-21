package com.malex.lecture_14_optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalMap {

    @Test
    public void test() {
        var r = new Result(0);
        String srt = "123345";
        Optional<Integer> number = Optional.ofNullable(srt).map(Integer::parseInt);
//         number.ifPresentOrElse(num -> r, ()-> new Result(-1));

    }

    record Result(int number) {
    }
}
