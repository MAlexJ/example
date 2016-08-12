package lecture_02_stream_primitive;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main_Stream_02_Primitive {

    public static void main(String[] args) {

        // Кроме регулярных объектов потоков Java 8, еще предоставляются особые виды потоков
        // для работы с примитивными типами данных int, long и double.
        // IntStream , LongStream и DoubleStream .
        IntStream.range(5, 8).forEach(System.out::println);

        System.out.println("\n~~~~~~~~~~~~~~~~~\n");

        IntStream.of(1, 1, 2, 3).forEach(System.out::println);

        System.out.println("\n~~~~~~~~~~~~~~~~~\n");

        // примитивные потоки поддерживают дополнительные терминальные операции sum() и average():
        Arrays.stream(new int[]{1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);

        System.out.println("\n~~~~~~~~~~~~~~~~~\n");

        // Иногда это полезно преобразовать поток объекта к примитивному потоку или наоборот.
        // Для этой цели потоки объектов поддерживают специальные операций картирования mapToInt(), mapToLong() и mapToDouble() :
        Stream.of("c1", "c2", "c3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        System.out.println("\n~~~~~~~~~~~~~~~~~\n");

        // Примитивные потоки могут быть преобразованы в объектные потоки с помощью метода mapToObj()
        IntStream.range(1, 4)
                .mapToObj(i -> "с" + i)
                .forEach(System.out::println);

        System.out.println("\n~~~~~~~~~~~~~~~~~\n");

        // Вот комбинированный пример: поток с double сначала преобразуется в int’овый поток и затем в объектный поток строк:
        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "с" + i)
                .forEach(System.out::println);

    }
}
