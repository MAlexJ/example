package example_02;


import java.util.StringTokenizer;

public class Task_03_split_space {

    public static void main(String[] args) {

        String str = "This is String , split by StringTokenizer, created by mkyong";
        StringTokenizer st = new StringTokenizer(str);

        System.out.println("---- Split by space ------");
        while (st.hasMoreTokens()) {

            System.out.println(st.nextToken());
        }


    }

}
