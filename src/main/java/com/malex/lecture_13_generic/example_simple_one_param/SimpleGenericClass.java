package com.malex.lecture_13_generic.example_simple_one_param;

/**
 * The simple example of using generic with one parameter
 */
public class SimpleGenericClass
{
    public static void main(String[] args)
    {
        // example #1:
        // use of the Integer type
        Gen<Integer> iOb = new Gen<>(192);
        System.out.println("Gen<Integer> iOb: " + iOb.getObj());
        iOb.printType();

        // example #2
        // use of the String type
        Gen<String> sOb = new Gen<>("This is string.");
        System.out.println("Gen<String> sOb: " + sOb);
        sOb.printType();
    }

    /**
     * A simple generic class
     */
    private static class Gen<T>
    {
        private T value;

        Gen(T value)
        {
            this.value = value;
        }

        T getObj()
        {
            return this.value;
        }

        void printType()
        {
            System.out.println("Type: " + this.value.getClass().getName() + "\n");
        }
    }
}
