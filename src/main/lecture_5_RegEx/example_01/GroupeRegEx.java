package example_01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 01.07.15.
 */
public class GroupeRegEx {

    public static void main(String[] args) {

//        Pattern p = Pattern.compile("(якороль).+(\\1)");
//        Matcher m = p.matcher("регулярные выражения это круто регулярные выражения это круто регулярные выражения это круто якороль Я СЕГОДНЯ ЕЛ БАНАНЫ якороль регулярные выражения это круто" );
//        if(m.find()){
//            System.out.println(m.group());
//        }

        Pattern p = Pattern.compile("(<h1>).+(\\1)");
        //На месте первой группы (якороль) могло содержаться более сложное выражение,
        // тогда обратная ссылка \\1 значительно сократила
        // бы размер регулярного выражения.
        Matcher m = p.matcher("<hjejej>   <h1> ffffff <h1> sdsff<h2>addda <h12> ggggg <h12>");
        if (m.find()) {
            System.out.println(m.group());
        }
    }
}
