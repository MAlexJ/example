package com.malex.lecture_25_Java_8.example_01_default_and_static_method_interface;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

import static junit.framework.TestCase.assertEquals;

@Log4j
public class StaticInterfaceTest {

    @Test
    public void test() {
        assertEquals(2, IStaticInterface.calc(1,1));
    }
}


interface IStaticInterface {
    static int calc(int x, int y) {
        return x + y;
    }
}