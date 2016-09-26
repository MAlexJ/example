package example_03;

import java.io.Closeable;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author malex
 */
public class Main_App_Enum_03 {
    public static void main(String[] args) {
        ThreadStatesEnum running = ThreadStatesEnum.RUNNING;
        System.out.println(running);

        ThreadStatesEnum start = ThreadStatesEnum.START;
        System.out.println(start);



        System.out.println("`````````````````````````````");
        usingEnumMap();
    }

    /**
     * Метод usingEnumMap() показывает использование java.util.EnumMap,
     * который ввелся в Java 1.5 Collections Framework.
     * EnumMap является реализацией Map.
     * Все ключи в EnumMap должны быть одного типа, указанного явно или неявно,
     * когда карта будет создана.
     * Мы не можем использовать null в качестве ключа для EnumMap.
     */
    private static void usingEnumMap() {
        EnumMap<ThreadStatesEnum, String> enumMap = new EnumMap<>(ThreadStatesEnum.class);
        enumMap.put(ThreadStatesEnum.START, "Поток начал работу");
        enumMap.put(ThreadStatesEnum.RUNNING, "Поток ждет");
        enumMap.put(ThreadStatesEnum.WAITING, "Поток работает");
        enumMap.put(ThreadStatesEnum.CLOSE, "Поток умер");

        Set<ThreadStatesEnum> keySet = enumMap.keySet();
        for (ThreadStatesEnum key : keySet) {
            System.out.println("ключ = " + key.toString() + " :: значение = " + enumMap.get(key));
        }

    }


    private enum ThreadStatesEnum implements Closeable {
        START(1) {
            @Override
            public String toString() {
                return "  @Override -> START";
            }
        },
        RUNNING(2),
        WAITING(3),
        CLOSE(4);

        // Enum константы неявно static и final
        private int priority;

        //Enum конструкторы должны всегда быть private.
        private ThreadStatesEnum(int priority) {
            priority = priority;
        }

        // У Enum могут быть методы
        public int getPriority() {
            return this.priority;
        }

        // Enum константы являются final, но ее можно изменять.
        public void setPriority(int p) {
            this.priority = p;
        }


        @Override
        public void close() throws IOException {
            System.out.println("Close stream!");
        }

        @Override
        public String toString() {
            return "Стандартная реализация ThreadStatesConstructors. Приоритет : " + getPriority();
        }
    }
}
