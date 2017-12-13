package chapter_4_prority_queue.impl;

import chapter_4_prority_queue.AbstractPriorityQueue;
import chapter_4_prority_queue.PriorityQueueInretface;

public class PriorityQueueImpl extends AbstractPriorityQueue implements PriorityQueueInretface
{
    public PriorityQueueImpl(int size)
    {
        super(size);
    }

    @Override
    public void insert(int num)
    {
        isFullQueue();
        if (nItems == DEFAULT_VALUE)
            arr[nItems++] = num;
        else
        {
            int temp;
            for (temp = nItems - 1; temp >= 0; temp--)  // TODO <<<<<  check it
            {
                if (num > arr[temp])
                {
                    arr[temp + 1] = arr[temp];
                } else
                {
                    break;
                }
            }
            arr[temp + 1] = num;
            nItems++;
        }
    }

    @Override
    public long remove()
    {
        isEmptyQueue();
        return arr[--nItems];
    }

    @Override
    public int peekMin()
    {
        isEmptyQueue();
        return arr[nItems - 1];
    }

    @Override
    public boolean isFull()
    {
        return nItems == maxSize;
    }

    @Override
    public boolean isEmpty()
    {
        return nItems == DEFAULT_VALUE;
    }
}
