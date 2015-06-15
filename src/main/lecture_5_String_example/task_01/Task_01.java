package task_01;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Task_01 {

    public static void main(String[] args) {

        String str = "1:23:4:546:21:0:3";

        StringTokenizer stk = new StringTokenizer(str, ":");

        String[] ar = new String[stk.countTokens()];

        for (int i = 0; i < ar.length; i++) {
            ar[i] = stk.nextToken();
        }

        System.out.println(Arrays.toString(ar));

    }

}
