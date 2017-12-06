package chapter_4_queue;

public interface QueueInterface
{
    void insert(int item);

    int remove();

    int peekFront();

    boolean isEmpty();

    boolean isFull();

    int size();
}