package com.malex.lecture_22_Pattern.example_01_Strategy;

import com.malex.lecture_22_Pattern.example_01_Strategy.pattern.Context;
import com.malex.lecture_22_Pattern.example_01_Strategy.pattern.impl.ConcreteStrategyAdd;
import com.malex.lecture_22_Pattern.example_01_Strategy.pattern.impl.ConcreteStrategyMultiply;
import com.malex.lecture_22_Pattern.example_01_Strategy.pattern.impl.ConcreteStrategySubtract;
import lombok.extern.log4j.Log4j;

@Log4j
public class StrategyApp {

    public static void main(String... a) {

        Context context = new Context();

        context.setStrategy(new ConcreteStrategyAdd());
        int resultA = context.executeStrategy(3, 4);
        log.info("Result A : " + resultA);

        context.setStrategy(new ConcreteStrategySubtract());
        int resultB = context.executeStrategy(3, 4);
        log.info("Result B : " + resultB);

        context.setStrategy(new ConcreteStrategyMultiply());
        int resultC = context.executeStrategy(3, 4);
        log.info("Result C : " + resultC);
    }
}
