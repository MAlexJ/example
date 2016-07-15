package lecture_01_exeption_syntax.task_01;


import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class TestMain_01 {


    public static void main(String[] args) {

        //%s - String
        //%d - integer type number
        //%f - double type number
        // /n - new line


        try (Formatter formatter = new Formatter("src//main//lecture_5_String_format//resources//format.txt");
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Write to file -> ");
            System.out.println("Student first name");
           /// scanner.
            System.out.println("Student last name");

            System.out.println("Student age");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
