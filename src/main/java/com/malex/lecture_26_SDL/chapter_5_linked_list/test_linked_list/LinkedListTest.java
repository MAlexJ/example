package com.malex.lecture_26_SDL.chapter_5_linked_list.test_linked_list;

import com.malex.lecture_26_SDL.chapter_5_linked_list.ILinkedList;
import com.malex.lecture_26_SDL.chapter_5_linked_list.impl.MyLinkedList;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class LinkedListTest {

    @Test
    public void testSimpleAddAndRemove() {
        ILinkedList list = new MyLinkedList();
        assertEquals(0, list.size());

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        assertEquals(4, list.size());

        assertTrue(list.remove("4"));
        assertEquals(3, list.size());

        assertTrue(list.remove("2"));
        assertEquals(2, list.size());

        assertTrue(list.remove("1"));
        assertEquals(1, list.size());

        assertFalse(list.remove("1"));
        assertEquals(1, list.size());

        assertTrue(list.remove("3"));
        assertEquals(0, list.size());
    }


    @Test
    public void testSimpleAddAndRemoveNull() {
        ILinkedList list = new MyLinkedList();
        assertEquals(0, list.size());

        list.add(null);
        list.add(null);
        list.add(null);
        assertEquals(3, list.size());

        assertTrue(list.remove(null));
        assertEquals(2, list.size());

        assertTrue(list.remove(null));
        assertEquals(1, list.size());

        assertTrue(list.remove(null));
        assertEquals(0, list.size());
    }

    @Test
    public void testSimpleAddAndRemoveOneValue() {
        ILinkedList list = new MyLinkedList();
        assertEquals(0, list.size());

        list.add("One");
        assertEquals(1, list.size());

        assertTrue(list.remove("One"));
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveElemWhenListIsEmpty() {
        ILinkedList list = new MyLinkedList();
        assertEquals(0, list.size());

        assertFalse(list.remove("One"));
        assertEquals(0, list.size());

        assertFalse(list.remove(null));
        assertEquals(0, list.size());
    }


    @Test
    public void testSimpleAddAndRemoveOneNullValue() {
        ILinkedList list = new MyLinkedList();
        assertEquals(0, list.size());

        list.add(null);
        assertEquals(1, list.size());

        assertTrue(list.remove(null));
        assertEquals(0, list.size());

        assertFalse(list.remove(null));
        assertEquals(0, list.size());
    }

    @Test
    public void testSimpleAddAndRemoveEmptyAndNull() {
        ILinkedList list = new MyLinkedList();
        assertEquals(0, list.size());

        list.add(null);
        list.add("");
        list.add(null);
        list.add("");
        list.add(null);

        assertEquals(5, list.size());

        assertTrue(list.remove(null));
        assertEquals(4, list.size());

        assertTrue(list.remove(null));
        assertEquals(3, list.size());

        assertTrue(list.remove(null));
        assertEquals(2, list.size());

        assertTrue(list.remove(""));
        assertEquals(1, list.size());

        assertTrue(list.remove(""));
        assertEquals(0, list.size());
    }
}
