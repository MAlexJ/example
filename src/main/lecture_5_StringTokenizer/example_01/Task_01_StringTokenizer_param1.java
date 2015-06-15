package example_01;

import java.util.StringTokenizer;

public class Task_01_StringTokenizer_param1 {

    public static void main(String[] args) {
        String s = "Строка, которую мы хотим разобрать на слова";
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            // Получаем слово и что-нибудь делаем с ним, например,
            // просто выводим на экран
            System.out.println(st.nextToken()) ;
        }
    }
}
