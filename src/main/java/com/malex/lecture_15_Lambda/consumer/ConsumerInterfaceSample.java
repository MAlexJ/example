package com.malex.lecture_15_Lambda.consumer;

import lombok.extern.java.Log;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.function.Consumer;

import static junit.framework.TestCase.assertEquals;

/**
 * Represents an operation that accepts a single input argument and returns no result.
 * Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
 */
@Log
public class ConsumerInterfaceSample {

    public static void main(String[] args) {
        Consumer<String> consumer = s1 -> System.out.println(s1  + 1);
        Consumer<String> consumer1 = consumer.andThen(s2 -> System.out.println(s2 + 2));
        Consumer<String> consumer2 = consumer1.andThen(s2 -> System.out.println(s2 + 3));

        consumer.accept("hello");
        consumer1.accept("world");
        consumer2.accept("x");
    }

    @Test
    public void test() throws IOException {
        String expected = "xyy";
        String hello = "x";
        String world = "y";
        wrapper(expected, () -> {
            Consumer<String> consumer = s1 -> System.out.print(s1);
            Consumer<String> consumer1 = consumer.andThen(s2 -> System.out.print(s2));
            consumer.accept(hello);
            consumer1.accept(world);
        });
    }

    public void wrapper(String expected, Runnable r) throws IOException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             PrintStream printStream = new PrintStream(out)) {
            System.setOut(printStream);
            r.run();
            assertEquals(expected, out.toString());
        } catch (IOException ex) {
            log.severe(ex.getMessage());
            throw ex;
        }
    }
}