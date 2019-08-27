package com.malex.lecture_22_Pattern.example_01_Strategy.pattern.impl;

import com.malex.lecture_22_Pattern.example_01_Strategy.pattern.Strategy;
import lombok.extern.log4j.Log4j;

@Log4j
public class ConcreteStrategySubtract implements Strategy {

    @Override
    public int execute(int a, int b) {
        log.info("ConcreteStrategySubtract -> execute ");
        return a - b;
    }
}
