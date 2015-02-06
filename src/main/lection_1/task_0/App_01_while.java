package task_0;

/**
 * Created by Alex on 06.02.2015.
 */
public class App_01_while {

    public static void main(String[] args) {
        int i = 0;
        boolean flag = true;
        Cat cat = null;

        while (flag) {
            cat = new Cat(7);
            if (i > 1) {
                flag = false;
            }
            System.out.println("while() -> " + cat + "; flag: " + flag);
            i++;
            System.out.println();
        }

        System.out.println("End main -> " + cat);

    }

}

class Cat {
    private static int count = 1;
    private int number;

    public Cat(int number) {
        this.number = number;
        System.out.println("Object Cat create: " + count++);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "number=" + number +
                '}';
    }
}
