package lecture_04_Reusing_Streams;

import java.util.stream.Stream;

public class Main_Stream_04_Reusing_Streams {

    public static void main(String[] args) {
        Stream<String> stream =
                Stream.of("dd2", "aa2", "bb1", "bb3", "cc")
                        .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);    // операция выполнится успешно
        stream.noneMatch(s -> true);   // Вылетит Exception

    }
}
