package example_01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExReplaceText {

    private static String text = "Мне очень нравится Тайланд. Таиланд это то место куда бы я поехал. тайланд - мечты сбываются!";

    public static void main(String[] args) {

//        System.out.println(text.replaceAll("[Тт]а[ий]ланд", "Украина"));
//
//        System.out.println(test_queue("rrrr"));

        // Pattern p = Pattern.compile("^[a-z]{0,}");
        Pattern p = Pattern.compile("^0.[0]+");
        Matcher m = p.matcher("0.0000");
        System.out.println(m.matches());


    }


    /*
    *Внутри символьных классов есть свои собственные метасимволы:

    ^ - логическое НЕ. Например [^ABC] - не A или B или C, но все остальные символы подходят.
    - -(дефис) интервал символов; так, выражение <H[1-6]> эквивалентно <H[123456]>
    * */

    public static boolean test(String testString) {
        //"^[a-z]+" = начало строки + любой символ в пределах a-z (abcdef...z) любое количество раз (от одного).
        // Pattern p = Pattern.compile("^[a-z]{0,}");
        Pattern p = Pattern.compile("^[a-z]+");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    public static boolean test1(String testString) {
        //"^[a-z]+" = начало строки + любой символ в пределах a-z (abcdef...z) любое количество раз (от одного).
        Pattern p = Pattern.compile("^[^a-z]+");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

}
