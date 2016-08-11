package lecture_01_exeption_syntax.task_01;


import java.util.Arrays;
import java.util.List;

public class Main_Stream_01 {

    public static void main(String[] args) {
        List<String> mList = Arrays.asList("aa1", "cc2", "cc1", "aa2", "bb1");
        mList
                .stream()
                .filter(list -> list.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
