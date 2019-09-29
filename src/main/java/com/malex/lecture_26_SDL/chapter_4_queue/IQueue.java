package com.malex.lecture_26_SDL.chapter_4_queue;

public interface IQueue {
    void insert(int item);

    int remove();

    int peekFront();

    boolean isEmpty();

    boolean isFull();

    int size();
}