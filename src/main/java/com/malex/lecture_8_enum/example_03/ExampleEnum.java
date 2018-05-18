package com.malex.lecture_8_enum.example_03;

import java.io.Closeable;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Set;

/**
 * @author malex
 */
public class ExampleEnum
{

    public static void main(String[] args)
    {
        ThreadStatesEnum running = ThreadStatesEnum.RUNNING;
        System.out.println(running);

        ThreadStatesEnum start = ThreadStatesEnum.START;
        System.out.println(start);

        System.out.println("`````````````````````````````");
        usingEnumMap();
    }

    /**
     * The usingEnumMap () method shows the use of java.util.EnumMap,
     *  which was introduced in the Java 1.5 Collections Framework.
     *  EnumMap is an implementation of Map.
     *  ll keys in EnumMap must be of the same type, either explicitly or implicitly,
     *  When the card is created.
     * We can not use null as the key for EnumMap.
     */
    private static void usingEnumMap()
    {
        EnumMap<ThreadStatesEnum, String> enumMap = new EnumMap<>(ThreadStatesEnum.class);
        enumMap.put(ThreadStatesEnum.START, "The thread started work");
        enumMap.put(ThreadStatesEnum.RUNNING, "The thread is waiting");
        enumMap.put(ThreadStatesEnum.WAITING, "The thread works");
        enumMap.put(ThreadStatesEnum.CLOSE, "The thread is dead");

        Set<ThreadStatesEnum> keySet = enumMap.keySet();
        for (ThreadStatesEnum key : keySet)
        {
            System.out.println("key = " + key.toString() + " :: value = " + enumMap.get(key));
        }
    }


    private enum ThreadStatesEnum implements Closeable
    {
        START(1)
                {
                    @Override
                    public String toString()
                    {
                        return "  @Override -> START";
                    }
                },
        RUNNING(2),
        WAITING(3),
        CLOSE(4);

        // Enum's constants  implicitly static and final
        private int priority;

        //Enum's constructor should always be private.
        private ThreadStatesEnum(int priority)
        {
            priority = priority;
        }

        // The Enum may be methods
        public int getPriority()
        {
            return this.priority;
        }

        // Enum's constants are final, but you can change it.
        public void setPriority(int p)
        {
            this.priority = p;
        }


        @Override
        public void close() throws IOException
        {
            System.out.println("Close stream!");
        }

        @Override
        public String toString()
        {
            return "Standard implementation ThreadStatesConstructors. Priority : " + getPriority();
        }
    }
}
