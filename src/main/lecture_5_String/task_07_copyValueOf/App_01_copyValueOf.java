package task_07_copyValueOf;

/**
 * Created by Alex on 06.03.2015.
 */
public class App_01_copyValueOf {

    public static void main(String args[]) {
        char[] str1 = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
        String str2 = "";

        //This method returns a String that contains the characters of the character array.
        str2 = str2.copyValueOf(str1);
        System.out.println("Returned String: " + str2);

        //This method returns a String that contains the characters of the character array.
        str2 = str2.copyValueOf(str1, 2, 6);
        System.out.println("Returned String: " + str2);

    }
}
