package com.malex.lecture_4_decrimenting_carousel.impl;

import java.util.Deque;

public class CarouselRun {

    /**
     * Aggregation example
     * link: https://facingissuesonit.com/2019/09/30/java-aggregation-and-composition-has-a/
     */
    private final Deque<Integer> structure;
    private final int capacity;
    private boolean finished;

    /**
     * Aggregation is a term which is used to refer one way relationship between two objects.
     * For example, Student class can have reference of Address class but vice versa does not make sense.
     * <p>
     * In Java, aggregation represents HAS-A relationship,
     * which means when a class contains reference of another class known to have aggregation.
     * <p>
     * The HAS-A relationship is based on usage, rather than inheritance.
     * In other words, class A has-a relationship with class B, if class A has a reference to an instance of class B.
     * <p>
     * Advantage of Aggregation
     * The main advantage of using aggregation is to maintain code re-usability.
     * If an entity has a relation with some other entity than it can reuse code just by referring that.
     */
    public CarouselRun(Deque<Integer> structure, int capacity) {
        this.capacity = capacity;
        this.structure = structure;
    }

    public int next() {
        if (this.structure.isEmpty()) {
            return -1;
        }
        int currentValue = structure.removeFirst();
        int evaluateValue = currentValue - 1;
        if (evaluateValue > 0) {
            this.structure.addLast(evaluateValue);
        }
        return currentValue;
    }

    public boolean isFinished() {
        return finished && structure.isEmpty();
    }

    public boolean addElement(int element) {
        if (finished || element <= 0 || structure.size() >= capacity) {
            return false;
        }
        return structure.add(element);
    }

    protected CarouselRun run() {
        if (finished) {
            return null;
        }
        finished = true;
        return this;
    }
}
