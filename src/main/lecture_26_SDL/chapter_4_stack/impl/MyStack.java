package chapter_4_stack.impl;

import chapter_4_stack.StackInterface;

public class MyStack implements StackInterface
{
    private static final int START_POSITION = -1;

    private int maxSize;
    private int[] arr;
    private int top;

    public MyStack(int size)
    {
        this.maxSize = size;
        this.arr = new int[size];
        this.top = START_POSITION;
    }

    @Override
    public void push(int num)
    {
        if (isFull()) throw new IllegalArgumentException("Stack is full!");
        this.arr[++top] = num;
    }

    // get element
    @Override
    public int pop()
    {
        return arr[top];
    }

    @Override
    public int peek()
    {
        if (isEmpty()) throw new IllegalArgumentException("Stack is empty!");
        return arr[top--];
    }

    @Override
    public boolean isEmpty()
    {
        return this.top == START_POSITION;
    }

    @Override
    public boolean isFull()
    {
        return this.top == this.maxSize - 1;
    }

}