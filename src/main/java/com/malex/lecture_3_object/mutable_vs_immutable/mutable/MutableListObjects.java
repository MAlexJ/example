package com.malex.lecture_3_object.mutable_vs_immutable.mutable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class MutableListObjects {

    @Test
    public void test() {
        // given
        var numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        var mutableClass = new MutableClass(1, numbers);

        // when
        numbers.add(8);

        // then
        assertTrue(mutableClass.getNumbers().contains(8));
    }

    @Getter
    @AllArgsConstructor
    public class MutableClass {
        private Integer number;
        private List<Integer> numbers;
    }
}
