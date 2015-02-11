package task_0.test;

/*
 * Что выведет на экран следующий код?
 *
 * public class Test {
 *   private Integer k;
 *   private int z;
 *   private int i;
 *
 *  public void method() {
 *      i = k + z;                 // 1
 *  }
 *
 *  public static void main(String[] args) {
 *      Test t = new Test();
 *      t.method();
 *      System.out.println(t.i); // 2
 *  }
 * }
 *
 * Answer:
 *
 * 1. Произойдет ошибка компиляции в строке 1
 * 2. Произойдет ошибка компиляции в строке 2
 * 3. Напечатает 0
 * 4. Ошибка выполнения java.lang.NullPointerException
 * 5. Ошибка выполнения java.lang.ClassCastException
 *
 */
public class Test_02 {
    private Integer k;
    private int z;
    private int i;

    public void method() {
        i = k + z;                 // 1
    }

    public static void main(String[] args) {
        Test_02 t = new Test_02();
        t.method();
        System.out.println(t.i); // 2
    }
}

/*
* Пояснение:
* Переменные "i", "z" проинициализируются как 0, т.к. являются примитивными типами.
* А "k" является объектом поэтому будет проинициализирована как null,
* в итоге операции с null дадут ошибку выполнения NullPointerException.
 */