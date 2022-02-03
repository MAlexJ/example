package com.malex.lecture_4_decrimenting_carousel.impl;

import java.util.ArrayDeque;

public class DecrementingCarousel {

    /**
     * Composition example
     * link: https://facingissuesonit.com/2019/09/30/java-aggregation-and-composition-has-a/
     */
    private final CarouselRun carousel;

    /**
     * The composition is special type of aggregation where one object
     * is strongly associated with another object and more restrictive.
     * When the contained object in “HAS-A” and one object can not exist without
     * the existence of others it’s the case of composition.
     * <p>
     * Benefits of Composition
     * The composition provides re-usability.
     * The composition can control the visibility of another object and reuse only when needed.
     */
    public DecrementingCarousel(int capacity) {
        carousel = new CarouselRun(new ArrayDeque<>(), capacity);
        // Композиция — еще более «жесткое отношение,
        // когда объект не только является частью другого объекта,
        // но и вообще не может принадлежат еще кому-то.
    }

    public boolean addElement(int element) {
        return carousel.addElement(element);
    }

    public CarouselRun run() {
        return carousel.run();
    }
}
