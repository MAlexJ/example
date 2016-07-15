package lecture_02_add_and_remove_first_symbol;

/**
 * Created by malex on 15.07.16.
 */
public class Main {


    public static void main(String[] args) {
        replaceString();
        System.out.println();

        System.out.println(replaceCharAt("oiu88y",4,'w'));
        System.out.println();

        System.out.println();


    }

    // Чтобы заменить все вхождения данного символа:
    private static void replaceString() {
        String myString = "Replace ' by * ";
        String tmpString = myString.replace('\'', '*');
        System.out.println("Original = " + myString);
        System.out.println("Result   = " + tmpString);
    }

    // Чтобы заменить символ в указанной позиции:
    private static String replaceCharAt(String s, int pos, char c) {
        return s.substring(0, pos) + c + s.substring(pos + 1);
    }

    // Для удаления символа:
    private static String removeChar(String s, char c) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) r += s.charAt(i);
        }
        return r;
    }

    // Чтобы удалить символ в указанной позиции:
    private static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

}
