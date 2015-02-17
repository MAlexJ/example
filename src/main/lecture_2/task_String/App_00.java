package task_String;

public class App_00 {


    public static void main(String[] args) {

        // Create new Object -> "Hello"
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        String s3 = s1;

        System.out.print("s1 == s2 -> ");
        System.out.println(s1 == s2);

        System.out.print("s1.equals(s2) -> ");
        System.out.println(s1.equals(s2));

        System.out.print("s1 == s3 -> ");
        System.out.println(s1 == s3);

        System.out.print("s1.equals(s3) -> ");
        System.out.println(s1.equals(s3));


    }

}
