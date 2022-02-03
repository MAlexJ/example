package com.malex.lecture_4_decrimenting_carousel.test;

import com.malex.lecture_4_decrimenting_carousel.impl.CarouselRun;
import com.malex.lecture_4_decrimenting_carousel.impl.DecrementingCarousel;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CarouselRunTest {

    @Test
    public void testEmptyCase() {
        CarouselRun run = new DecrementingCarousel(7).run();

        assertTrue(run.isFinished());
        assertEquals(-1, run.next());
        assertEquals(-1, run.next());

        assertTrue(run.isFinished());
        assertEquals(-1, run.next());
        assertEquals(-1, run.next());
    }

    @Test
    public void testHalfEmptyCase1() {
        DecrementingCarousel carousel = new DecrementingCarousel(7);

        carousel.addElement(3);
        carousel.addElement(7);
        carousel.addElement(4);
        CarouselRun run = carousel.run();

        assertEquals(3, run.next());
        assertEquals(7, run.next());
        assertEquals(4, run.next());

        assertEquals(2, run.next());
        assertEquals(6, run.next());
        assertEquals(3, run.next());

        assertEquals(1, run.next());
        assertEquals(5, run.next());
        assertEquals(2, run.next());

        assertEquals(4, run.next());
        assertEquals(1, run.next());

        assertEquals(3, run.next());
        assertEquals(2, run.next());
        assertEquals(1, run.next());


        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }

    @Test
    public void testHalfEmptyCase2() {
        DecrementingCarousel carousel = new DecrementingCarousel(7);

        carousel.addElement(7);
        carousel.addElement(3);
        carousel.addElement(4);
        CarouselRun run = carousel.run();

        assertEquals(7, run.next());
        assertEquals(3, run.next());
        assertEquals(4, run.next());

        assertEquals(6, run.next());
        assertEquals(2, run.next());
        assertEquals(3, run.next());

        assertEquals(5, run.next());
        assertEquals(1, run.next());
        assertEquals(2, run.next());

        assertEquals(4, run.next());
        assertEquals(1, run.next());

        assertEquals(3, run.next());
        assertEquals(2, run.next());
        assertEquals(1, run.next());


        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }

    @Test
    public void testFullCase1() {
        DecrementingCarousel carousel = new DecrementingCarousel(5);

        carousel.addElement(7);
        carousel.addElement(2);
        carousel.addElement(3);
        carousel.addElement(1);
        carousel.addElement(4);
        CarouselRun run = carousel.run();

        assertEquals(7, run.next());
        assertEquals(2, run.next());
        assertEquals(3, run.next());
        assertEquals(1, run.next());
        assertEquals(4, run.next());

        assertEquals(6, run.next());
        assertEquals(1, run.next());
        assertEquals(2, run.next());
        assertEquals(3, run.next());

        assertEquals(5, run.next());
        assertEquals(1, run.next());
        assertEquals(2, run.next());

        assertEquals(4, run.next());
        assertEquals(1, run.next());

        assertEquals(3, run.next());
        assertEquals(2, run.next());
        assertEquals(1, run.next());


        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }

    @Test
    public void testFullCase2() {
        DecrementingCarousel carousel = new DecrementingCarousel(6);

        carousel.addElement(7);
        carousel.addElement(2);
        carousel.addElement(100);
        carousel.addElement(3);
        carousel.addElement(1);
        carousel.addElement(4);
        CarouselRun run = carousel.run();

        assertEquals(7, run.next());
        assertEquals(2, run.next());
        assertEquals(100, run.next());
        assertEquals(3, run.next());
        assertEquals(1, run.next());
        assertEquals(4, run.next());

        assertEquals(6, run.next());
        assertEquals(1, run.next());
        assertEquals(99, run.next());
        assertEquals(2, run.next());
        assertEquals(3, run.next());

        assertEquals(5, run.next());
        assertEquals(98, run.next());
        assertEquals(1, run.next());
        assertEquals(2, run.next());

        assertEquals(4, run.next());
        assertEquals(97, run.next());
        assertEquals(1, run.next());

        assertEquals(3, run.next());
        assertEquals(96, run.next());
        assertEquals(2, run.next());
        assertEquals(95, run.next());
        assertEquals(1, run.next());
        assertEquals(94, run.next());

        for (int i = 93; i > 0; i--) {
            assertEquals(i, run.next());
        }

        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }
}