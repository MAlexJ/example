package chapter_4_queue.impl;


import chapter_4_queue.QueueInterface;

public class MyQueue implements QueueInterface
{
    private int maxSize;
    private int[] queArray;
    private int nItems;
    private int rear;
    private int front;

    public MyQueue(int size)
    {
        this.maxSize = size;
        this.queArray = new int[size];
        this.nItems = 0;
        this.front = 0;
        this.rear = -1;
    }

    @Override
    public void insert(int item)
    {
        if (nItems == maxSize) throw new IllegalArgumentException("Queue is full!");
        queArray[++rear] = item;
        nItems++;
    }

    @Override
    public int remove()
    {
        if (nItems == 0) throw new IllegalArgumentException("Queue is empty!");
        int temp = this.queArray[this.front++];
        this.nItems--;
        return temp;
    }

    @Override
    public int peekFront()
    {
        if (nItems == 0) throw new IllegalArgumentException("Queue hasn't items!");
        return queArray[front];
    }

    @Override
    public boolean isEmpty()
    {
        return nItems == 0;
    }

    @Override
    public boolean isFull()
    {
        return nItems == maxSize;
    }

    @Override
    public int size()
    {
        return nItems;
    }
}
