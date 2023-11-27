package com.malex.lecture_13_comparator;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

public class SimpleExampleComparable {

    @Test
    public void test() {

    }

    @Getter
    @Setter
    private static class Cat implements Comparable<Cat> {
        private int age;
        private String name;

        @Override
        public int compareTo(Cat cat) {
            if (cat == null) {
                throw new NullPointerException();
            }
            return 0;
        }
    }
}
