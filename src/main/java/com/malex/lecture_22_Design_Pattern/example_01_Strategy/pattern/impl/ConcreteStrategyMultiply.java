package com.malex.lecture_22_Design_Pattern.example_01_Strategy.pattern.impl;

import com.malex.lecture_22_Design_Pattern.example_01_Strategy.pattern.Strategy;
import lombok.extern.log4j.Log4j;

@Log4j
public class ConcreteStrategyMultiply implements Strategy {

    @Override
    public int execute(int a, int b) {
        log.info("ConcreteStrategyMultiply -> execute ");
        return a * b;
    }
}
