package example_01;

import java.util.StringTokenizer;

public class Task_01_StringTokenizer_param1_param2 {

    public static void main(String[] args) {
        String s = "Строка, которую мы хотим разобрать на слова...";
        StringTokenizer st = new StringTokenizer(s, " \t\n\r,.");
        while (st.hasMoreTokens()) {
            // Получаем слово и что-нибудь делаем с ним
            String s1 = st.nextToken();
            System.out.println(s1);
        }
    }
}
