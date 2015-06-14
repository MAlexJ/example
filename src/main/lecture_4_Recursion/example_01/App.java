package example_01;

public class App {
    public static void main(String[] args) {
        System.out.println("10 - нечетное число odd: " + isOdd(1));
        System.out.println("10 - четное число even:   " + isEven(1));
    }

    // проверка на четность
    public static boolean isEven(int k) {
        if (k == 0) {
            return true; // 0 - четное число
        } else {
            return isOdd(k - 1);
        }
    }

    // проверка на Ќ≈четность
    public static boolean isOdd(int k) {
        if (k == 0) {
            return false; // 0 - Ќ≈ Ќ≈четное число
        } else {
            return isEven(k - 1);
        }
    }
}

