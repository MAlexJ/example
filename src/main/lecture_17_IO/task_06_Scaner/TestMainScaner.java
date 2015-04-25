package task_06_Scaner;

import java.util.Scanner;

public class TestMainScaner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        int i = 2;
        System.out.print("Введите целое число: ");
        if (scanner.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
            i = scanner.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
            System.out.println(i * 2);
        } else {
            System.out.println("Вы ввели не целое число");
        }
    }
}