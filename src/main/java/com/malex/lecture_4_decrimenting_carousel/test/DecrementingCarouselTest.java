package com.malex.lecture_4_decrimenting_carousel.test;

import com.malex.lecture_4_decrimenting_carousel.impl.DecrementingCarousel;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class DecrementingCarouselTest {

    @Test
    public void checkAddElement() {
        DecrementingCarousel carousel = new DecrementingCarousel(5);
        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-1));
        assertFalse(carousel.addElement(-123456));
        assertFalse(carousel.addElement(0));

        assertTrue(carousel.addElement(1));
        assertTrue(carousel.addElement(2));

        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-123));

        assertTrue(carousel.addElement(1234));
        assertTrue(carousel.addElement(1234));

        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-456));

        assertTrue(carousel.addElement(22));

        assertFalse(carousel.addElement(22));

        assertFalse(carousel.addElement(-856));
        assertFalse(carousel.addElement(0));

        assertFalse(carousel.addElement(357));
        assertFalse(carousel.addElement(159));
        assertFalse(carousel.addElement(1));
    }

    @Test
    public void checkAddElementAfterRun() {
        DecrementingCarousel carousel = new DecrementingCarousel(5);

        assertTrue(carousel.addElement(1));
        assertTrue(carousel.addElement(2));
        assertTrue(carousel.addElement(3));

        carousel.run();

        assertFalse(carousel.addElement(4));
        assertFalse(carousel.addElement(5));
        assertFalse(carousel.addElement(6));

        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-123));
        assertFalse(carousel.addElement(-4568));
    }

    @Test
    public void testCarouselRunsSingleTimeOnly() {
        DecrementingCarousel carousel = new DecrementingCarousel(4);
        carousel.addElement(4);

        assertNotNull(carousel.run());
        assertNull(carousel.run());
        assertNull(carousel.run());
    }

}