package task_05_contains;

public class App_02 {

    public static void main(String[] args) {
        String num_01 = "12346757";
        System.out.println(num_01.contains("."));

        String num_02 = "123.46757";
        System.out.println(num_02.contains("."));

        String num_03 = "123.467.57";
        System.out.println(num_03.contains("."));
    }
}
