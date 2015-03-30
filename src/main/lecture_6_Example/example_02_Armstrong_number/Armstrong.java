package example_02_Armstrong_number;

/**
 * Created by Alex on 3/24/2015.
 */
public class Armstrong {

    public static void main(String args[]) {
        int num = 5;
        int n = num; //use to check at last time
        // what is "int check = 0, remainder;" ???
        int check = 0, remainder;
        while (num > 0) {
            remainder = num % 10;
            //Returns the value of the first argument raised to the power of the second argument.
            check = check + (int) Math.pow(remainder, 3);
            num = num / 10;
        }
        if (check == n)
            System.out.println(n + " is an Armstrong Number");
        else
            System.out.println(n + " is not a Armstrong Number");
    }

}
