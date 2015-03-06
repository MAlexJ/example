package task_05_charAt;

/**
 * Created by Alex on 06.03.2015.
 */
public class App_01 {
    public static void main(String[] args) {
        String s = "Strings are immutable";
        char result = s.charAt(8);
        System.out.println("s.charAt(8) -> " + result);

        char result1 = s.charAt(12);
        System.out.println("s.charAt(12) -> " + result1);
    }
}
