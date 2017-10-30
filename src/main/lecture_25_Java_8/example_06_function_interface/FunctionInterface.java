package example_06_function_interface;

import org.junit.Test;

import java.util.function.Function;

/**
 * Function ( java.util.function.Function ) is a functional interface that has one abstract method
 * and two default method declared in it.
 * It represents an algorithm where input parameter of one type is used
 * to produce return value of same or another type.
 * <p>
 * URL: http://codedestine.com/java-8-function-interface/
 * <p>
 * METHODS:
 * R  apply ( T t )
 * :- The abstract method apply ( T t ) is a functional method.
 * <p>
 * default  <V>  Function<T,R>   andThen ( Function <? super R, ? extends V> after )
 * :- It returns a function that performs two operation in sequence, first the operation of a function on which method is called,
 * this operation will take one parameter of type T as an argument and return one parameter of type R as a return value.
 * <p>
 * default  <V>  Function<R,V>   compose ( Function <? super T, ? extends R> after )
 * :- It returns a function that performs two operation in sequence, first the operation of a function passed as an argument in compose method,
 * this operation will take one parameter of type T as an argument and return one parameter of type R as a return value.
 * <p>
 * static <T> Function<T,T> identity() :- It returns a function that always returns its input argument
 */
public class FunctionInterface {

	/**
	 * test method #1
	 */
	@Test
	public void composeMethod() {

		Function<Integer, Integer> functionOne = e -> e + 2;
		Function<Integer, Integer> functionTwo = e -> e + e;

		// the compose function executes the caller last and the parameter first
		Integer num = functionOne
				  .compose(functionTwo)
				  .compose(functionOne)
				  .compose(functionOne)
				  .apply(4);
		// Returns 32
		System.out.println("number : " + num);
	}

	/**
	 * test method #2
	 */
	@Test
	public void andThenMethod() {

		Function<Integer, Integer> functionOne = e -> e + 2;
		Function<Integer, Integer> functionTwo = e -> e + e;

		// the andThen executes the caller first and the parameter last.
		Integer num = functionOne
				  .andThen(functionTwo)
				  .apply(4);
		// Returns 32
		System.out.println("number : " + num);
	}

	@Test
	public void testMyFunctionInterface() {
		MyFunction<Integer, Integer> function = t -> t + t;
		Integer apply = function.apply(5);
		System.out.println(apply);
	}

	@Test
	public void testIdentity() {
		MyFunction<Integer, Integer> id = MyFunction.identity();
		System.out.println(id.apply(3));

	}

	@FunctionalInterface
	public interface MyFunction<T, R> {

		R apply(T t);

		static <T> MyFunction<T, T> identity() {
			System.out.println("inside : identity()");
			return t -> t;
		}
	}

}