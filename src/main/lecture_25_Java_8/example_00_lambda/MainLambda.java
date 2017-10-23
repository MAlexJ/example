package example_00_lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.stream.Stream;

public class MainLambda {

	private String field = "field";

	private String getField() {
		return field;
	}

	private void setField(String field) {
		this.field = field;
	}

	private static MainLambda create(Functional<MainLambda> functional, String name) {
		MainLambda lambda = functional.get();
		if (name != null) {
			lambda.setField(name);
		}
		return lambda;
	}

	@Override
	public String toString() {
		return "MainLambda{" +
				  "field='" + field + '\'' +
				  '}';
	}

	@Test
	public void test() {

		String separator = "\n";
		Stream
				  .of("a", "b")
				  .peek(e -> System.out.print(separator))
				  .forEach(System.out::print);
	}

	@Test
	public void test2() {
		Stream
				  .of("w", "c", "a", "b")
				  .sorted()
				  .forEach(System.out::print);

	}

	@Test
	public void test3() {
		MainLambda l1 = MainLambda.create(MainLambda::new, "new name");
		MainLambda l2 = MainLambda.create(MainLambda::new, "old name");
		MainLambda l3 = MainLambda.create(MainLambda::new, null);

		Stream
				  .of(l1, l2, l3)
				  .sorted(Comparator.comparing(MainLambda::getField))
				  .forEach(System.out::println);
	}

}

/**
 * This it functional interface
 *
 * @param <T> - generic
 */
@FunctionalInterface
interface Functional<T> {

	T get();
}