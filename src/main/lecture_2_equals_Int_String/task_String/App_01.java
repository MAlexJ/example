package task_String;

public class App_01 {

    public static void main(String[] args) {
        //create -> String Pool
        String s4 = "Hello";
        String s5 = "Hello";
        String s6 = s4;

        System.out.print("s4 == s5 -> ");
        System.out.println(s4 == s5);

        System.out.print("s4.equals(s5): ");
        System.out.println(s4.equals(s5));

        System.out.print("s4 == s6 -> ");
        System.out.println(s4 == s6);

        System.out.print("s4.equals(s6): ");
        System.out.println(s4.equals(s6));

    }
}
