package com.malex.lecture_22_Design_Pattern.Behavioral.strategy.impl;

import com.malex.lecture_22_Design_Pattern.Behavioral.strategy.Strategy;

public class Subtraction implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }

    @Override
    public String toString() {
        return "Subtraction";
    }
}
