package com.malex.lecture_22_Design_Pattern.Behavioral;

import com.malex.lecture_22_Design_Pattern.Behavioral.strategy.Client;
import com.malex.lecture_22_Design_Pattern.Behavioral.strategy.Context;
import com.malex.lecture_22_Design_Pattern.Behavioral.strategy.impl.Addition;
import com.malex.lecture_22_Design_Pattern.Behavioral.strategy.impl.Multiplication;
import com.malex.lecture_22_Design_Pattern.Behavioral.strategy.impl.Subtraction;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class StrategyPattern {

    @Test
    public void simpleTest() {
        Client client = new Client();
        assertNotNull(client);
        client.calculate();
    }

    @Test
    public void testStrategy() {
        Context ctx = new Context();
        ctx.setStrategy(new Addition());
        assertEquals(3, ctx.execute(1, 2));

        ctx.setStrategy(new Subtraction());
        assertEquals(-1, ctx.execute(1, 2));

        ctx.setStrategy(new Multiplication());
        assertEquals(6, ctx.execute(2, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() {
        Context ctx = new Context();
        ctx.execute(1, 2);
    }
}
