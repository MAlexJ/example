package chapter_4_stack.test_stack;

import chapter_4_stack.impl.MyStack;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class MyStackTest
{
    @Test
    public void test()
    {
        simpleTest(new MyStack(10));

    }

    private void simpleTest(MyStack stack)
    {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        for (int i = 0; i < 9; i++)
        {
            stack.push(i);
        }
        assertFalse(stack.isEmpty());
        assertTrue(stack.isFull());
    }

}