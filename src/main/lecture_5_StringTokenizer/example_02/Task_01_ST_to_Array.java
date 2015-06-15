package example_02;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Task_01_ST_to_Array {

    public static void main(String[] args) {

        String str = "Вася:23:4?546:21?Оля:3";
        StringTokenizer stk = new StringTokenizer(str,":,?");

        String []ar = new String[stk.countTokens()];
        for(int i = 0; i<ar.length; i++)
        {
            ar[i] = stk.nextToken();
        }

        System.out.println(Arrays.toString(ar));

    }

}
