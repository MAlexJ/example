package example_02;

import java.util.StringTokenizer;

/**
 * Created by alex on 15.06.15.
 */
public class Task_02_split_coma {

    public static void main(String[] args) {

        String str = "This is String , split by StringTokenizer, created by mkyong";
        StringTokenizer st = new StringTokenizer(str, ",");

        System.out.println("---- Split by coma ------");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }


    }
}
