package task_0.test;

/**
 *
 * Какой результат выполнения следующего кода:

public class MainClass {
    public static void main(String args[]){
        System.out.println((-(byte)128)>>>1 == 128 >>> 1);
    }
}

Answer:

1. true
2. false
3. Ошибка компиляции

 */
public class Test_01 {
    public static void main(String args[]) {
        System.out.println((-(byte) 128) >>> 1 == 128 >>> 1);
    }
}

/* Пояснение:
Число 128 имеет двоичное представление 00000000 00000000 00000000 10000000.
После преобразования в byte получается 10000000 – но в типе byte это двоичное представление соответствует числу –128.
–(–128) даёт 128, а 128>>>1 разумеется будет равно 128>>>1.
* */