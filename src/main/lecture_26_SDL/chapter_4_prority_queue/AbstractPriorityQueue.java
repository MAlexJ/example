package chapter_4_prority_queue;

public abstract class AbstractPriorityQueue
{
    protected final static int DEFAULT_VALUE = 0;
    protected int maxSize;
    protected int[] arr;
    protected int nItems;

    public AbstractPriorityQueue(int size)
    {
        nItems = DEFAULT_VALUE;
        maxSize = size;
        arr = new int[size];
    }

    protected abstract boolean isFull();

    protected abstract boolean isEmpty();

    protected void isEmptyQueue()
    {
        if (isEmpty()) throw new IllegalArgumentException("PriorityQueue is empty!");
    }

    protected void isFullQueue()
    {
        if (isFull()) throw new IllegalArgumentException("PriorityQueue is full!");
    }

}
