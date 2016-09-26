package example_01;

import java.util.Arrays;

/**
 * Simple example enum
 *
 * @author malex
 */
public class Main_App_Enum_01 {

    public static void main(String[] args) {
        /*
        EXAMPLE #1
         */
        System.out.println(ThreadStatesEnum_01.START);
        System.out.println(ThreadStatesEnum_01.DEAD + "\n");

        /*
        EXAMPLE #2
        Enum.valueOf(String name);
        */
        String str = "WAITING";
        System.out.println(ThreadStatesEnum_01.valueOf(str) + "\n");

        /*
        EXAMPLE #3
        Incorrect name -> Enum.valueOf(String name);
        */
        try {
            String st = "THE END";
            ThreadStatesEnum_01.valueOf(st);
        } catch (IllegalArgumentException ex) {
            System.out.println(" >>>> " + ex.getMessage() + "\n");
        }

        /*
        EXAMPLE #4
        Array -> Enum.values();
        */
        ThreadStatesEnum_01[] values = ThreadStatesEnum_01.values();
        System.out.println(Arrays.toString(values) + "\n");

         /*
        EXAMPLE #5
        Enum -> ordinal();
        */
        System.out.println(ThreadStatesEnum_01.RUNNING + " ordinal:" + ThreadStatesEnum_01.RUNNING.ordinal());
        System.out.println(ThreadStatesEnum_01.WAITING + " ordinal:" + ThreadStatesEnum_01.WAITING.ordinal() + "\n");

    }
}


