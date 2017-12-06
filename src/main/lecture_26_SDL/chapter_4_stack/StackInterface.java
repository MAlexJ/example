package chapter_4_stack;

public interface StackInterface
{
    // insert a new element
    void push(int num);

    // remove and get the element from the stack
    int pop();

    // read the element from top
    int peek();

    boolean isEmpty();

    boolean isFull();
}
