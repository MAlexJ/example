package com.malex.lecture_22_Design_Pattern.Behavioral.strategy;

import lombok.Setter;

import java.util.Optional;

public class Context {

    @Setter
    private Strategy strategy;

    public int execute(int a, int b) {
        return Optional.ofNullable(strategy)
                .map(st -> st.calculate(a, b))
                .orElseThrow(() -> new IllegalArgumentException("Specific strategy has not been initialized!"));
    }

}
