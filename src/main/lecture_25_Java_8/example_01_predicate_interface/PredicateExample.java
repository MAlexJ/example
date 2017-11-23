package example_01_predicate_interface;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Predicate represents a predicate, which is boolean-valued function, of one argument.
 * Source: http://www.java2s.com/Tutorials/Java/java.util.function/Predicate/index.htm
 */
public class PredicateExample {

    private static final String TEMPLATE_FORMAT = "The string `%s` is contains char `j` or 'J' : %s \n";
    private static final String TEMPLATE_FORMAT_UPPERCASE = "%S";

    public static void main(String[] args) {

        // example #1
        simpleExample();

        // example #2
        createPredicate();

        // example #3
        showToReturnPredicate();
    }

    /**
     * Example #3
     * The following code shows how to return Predicate.
     */
    private static void showToReturnPredicate() {

    }

    /**
     * Example #2
     * The following code shows how to create Predicate from method reference and lambda.
     */
    private static void createPredicate() {

    }

    /**
     * Example #1
     * The following example shows how to use Predicate
     */
    private static void simpleExample() {
        String condition = "j";
        Stream<String> stringStream = Stream.of("Java", "JS", "Bootstrap", "Node", "js script");

        Predicate<String> predicate =
                (str) ->
                        str.contains(condition) ||
                                str.contains(String.format(TEMPLATE_FORMAT_UPPERCASE, condition));
        stringStream
                .forEach(str -> System.out.printf(TEMPLATE_FORMAT, str, predicate.test(str)));
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    private class Box {
        private int weight;
        private String color;
    }

}
