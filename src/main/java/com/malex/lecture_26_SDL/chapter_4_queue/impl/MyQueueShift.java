package com.malex.lecture_26_SDL.chapter_4_queue.impl;

import com.malex.lecture_26_SDL.chapter_4_queue.IQueue;

public class MyQueueShift implements IQueue {
    private int maxSize;
    private int[] queArray;
    private int nItems;
    private int rear;
    private int front;
    private int shift;


    public MyQueueShift(int size) {
        this.maxSize = size;
        this.queArray = new int[size];
        this.nItems = 0;
        this.front = 0;
        this.rear = -1;
        this.shift = 1;
    }

    @Override
    public void insert(int item) {
        if (nItems == maxSize) throw new IllegalArgumentException("Queue is full!");
        queArray[++rear] = item;
        nItems++;
    }

    @Override
    public int remove() {
        if (nItems == 0) throw new IllegalArgumentException("Queue is empty!");
        nItems--;
        rear--;
        int temp = queArray[front];
        queArray = shiftQueue();
        return temp;
    }

    // shift queue
    private int[] shiftQueue() {
        int[] result = new int[maxSize];
        System.arraycopy(queArray, shift, result, 0, maxSize - shift);
        return result;
    }

    @Override
    public int peekFront() {
        if (nItems == 0) throw new IllegalArgumentException("Queue hasn't items!");
        return queArray[front];
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
