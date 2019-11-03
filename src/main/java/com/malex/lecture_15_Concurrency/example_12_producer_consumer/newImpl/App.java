package com.malex.lecture_15_Concurrency.example_12_producer_consumer.newImpl;

import lombok.Builder;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

@Log4j
public class App {

    private static BlockingQueue<Item> storage = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {

        Runnable producer = createFactory("Producer",
                () -> {
                    // `put()` - Inserts the specified element into this queue, waiting if necessary
                    //           for space to become available.
                    try {
                        int id = ThreadLocalRandom.current().nextInt();
                        String name = "Name_" + System.currentTimeMillis();
                        Item item = Item.builder()
                                .id(id)
                                .name(name)
                                .build();
                        storage.put(item);
                    } catch (InterruptedException e) {
                        log.error(e.getMessage());
                    }
                });

        Runnable consumer = createFactory("Consumer",
                () -> {
                    // `take()` -  Retrieves and removes the head of this queue, waiting if necessary
                    //             until an element becomes available.
                    try {
                        Item item = storage.take();
                        process(item);
                    } catch (InterruptedException e) {
                        log.error(e.getMessage());
                    }
                });

        new Thread(producer).start();
        new Thread(consumer).start();
    }

    private static void process(Item item) {
        log.info("Process item: " + item);
    }

    private static Runnable createFactory(String functionName,
                                          Runnable function) {
        return () -> {
            while (true) {
                log.debug(">>> " + functionName);
                function.run();
            }
        };
    }


    @Builder
    @ToString
    private static class Item {
        private int id;
        private String name;
    }
}
