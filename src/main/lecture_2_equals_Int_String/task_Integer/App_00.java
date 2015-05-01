package task_Integer;

/**
 * Вывод: нельзя стравнивать ссылочные переменные ==, только equals()
 */
public class App_00 {

    public static void main(String[] args) {

        Integer i1 = 100;
        Integer i2 = 100;


        //А теперь что быдет ?????????????
        //Integer i1 = 200;
        // Integer i2 = 200;

        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        //Integer in = Integer.valueOf(100);
        //static final int low = -128;
        // static final int high = 127;

        // public static Integer valueOf(int i) {
        //    if (i >= IntegerCache.low && i <= IntegerCache.high)
        //        return IntegerCache.cache[i + (-IntegerCache.low)];
        //   return new Integer(i);
        // }




    }
}
