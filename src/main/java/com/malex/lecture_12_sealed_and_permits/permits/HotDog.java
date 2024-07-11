package com.malex.lecture_12_sealed_and_permits.permits;

import lombok.ToString;

@ToString
public final class HotDog extends Dog {

    private String name;

    HotDog(){
        this.name = "HotDog!";
    }

}
