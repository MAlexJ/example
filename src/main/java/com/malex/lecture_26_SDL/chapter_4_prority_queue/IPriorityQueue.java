package com.malex.lecture_26_SDL.chapter_4_prority_queue;

public interface IPriorityQueue {
    /**
     * Add a new element
     */
    void insert(int num);

    /**
     * extract min element
     */
    long remove();

    /**
     * Get min element
     */
    int peekMin();
}