package com.malex.lecture_26_SDL.chapter_4_queue.impl;
import com.malex.lecture_26_SDL.chapter_4_queue.IQueue;

/**
 * Circle Buffer or LoopQueue
 */
public class LoopQueue implements IQueue {
    private int maxSize;
    private int nItems;
    private int rear;
    private int front;
    private int[] queArray;

    public LoopQueue(int size) {
        maxSize = size;
        queArray = new int[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    @Override
    public void insert(int item) {
        if (nItems == maxSize) throw new IllegalArgumentException("Queue is full!");
        if (rear == maxSize - 1) rear = -1;  // TODO <<<
        queArray[++rear] = item;
        nItems++;
    }

    @Override
    public int remove() {
        if (nItems == 0) throw new IllegalArgumentException("Queue is empty!");
        if (front == maxSize) front = 0; // TODO <<<
        int temp = queArray[front++];
        nItems--;
        return temp;
    }

    @Override
    public int peekFront() {
        if (nItems == 0) throw new IllegalArgumentException("Queue hasn't items!");
        return queArray[front - 1];
    }

    @Override
    public boolean isEmpty() {
        return nItems == 0;
    }

    @Override
    public boolean isFull() {
        return nItems == maxSize;
    }

    @Override
    public int size() {
        return nItems;
    }
}
