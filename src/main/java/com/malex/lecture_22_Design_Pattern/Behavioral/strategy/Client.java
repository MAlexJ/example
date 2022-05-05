package com.malex.lecture_22_Design_Pattern.Behavioral.strategy;

import com.malex.lecture_22_Design_Pattern.Behavioral.strategy.impl.Addition;
import com.malex.lecture_22_Design_Pattern.Behavioral.strategy.impl.Multiplication;
import com.malex.lecture_22_Design_Pattern.Behavioral.strategy.impl.Subtraction;
import lombok.extern.java.Log;

@Log
public class Client {

    public static final String TEMPLATE_MESSAGE = "Apply strategy '%s', result = %s";
    private final Context context;

    public Client() {
        context = new Context();
    }

    public void calculate() {
        Strategy strategy = new Addition();
        context.setStrategy(strategy);
        log.info(String.format(TEMPLATE_MESSAGE, strategy, context.execute(1, 2)));

        strategy = new Multiplication();
        context.setStrategy(strategy);
        log.info(String.format(TEMPLATE_MESSAGE, strategy, context.execute(2, 3)));

        strategy = new Subtraction();
        context.setStrategy(strategy);
        log.info(String.format(TEMPLATE_MESSAGE, strategy, context.execute(2, 3)));
    }
}
