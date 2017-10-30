package example_05_consumer_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer ( java.util.function.Consumer ) is a functional interface
 * that has one abstract method and one default method declared in it.
 * <p>
 * URL: http://codedestine.com/java-8-consumer-interface/
 * <p>
 * Consumer Interface :-
 * Consumer ( java.util.function.Consumer ) is a functional interface that has one abstract method and one default method declared in it.
 * <p>
 * Abstract method :- void  accept ( T t ) :- The abstract method accept ( T t ) is a functional method.
 * It accepts one parameter as an argument and return no value,
 * it performs the operation defined by the Consumer interface ( usually a lambda expression passed as an argument ).
 * <p>
 * Default method :- default  Consumer<T>  andThen ( Consumer<? super T > after ) :-
 * It returns a consumer that performs two operation in sequence,
 * first the operation of the consumer on which method is called followed by the operation of the consumer passed as an argument.
 * <p>
 * <p>
 * Stream API have few methods where Java 8 Consumer interface are used as an argument, they are as follows :-
 * <p>
 * Stream<T>  peek ( Consumer<? super T> action )
 * void  forEach ( Consumer<? super T> action )
 * void  forEachOrdered ( Consumer<? super T> action )
 */
public class ConsumerInterface {

	public static void main(String[] args) {

		// ************************** EXAMPLE 1 *******************************

		// #1:  void accept(T t);
		exampleAccept();

		// #2: default Consumer<T> andThen(Consumer<? super T> after)
		exampleAndThen();

		// #3: andThen .. andThen... andThen
		exampleAndThenWIthAction();


		// ************************** EXAMPLE 2 *******************************

		example2();

	}

	private static void exampleAccept() {

		System.out.println(">>> Example 1 <<<<<");

		Consumer<String> consumer = System.out::println;
		consumer.accept(" #1 Print some string");

		newLinePrint();
	}

	private static void exampleAndThen() {

		Consumer<String> consumer1 = System.out::println;
		consumer1.accept(" #2.1: consumer1 -> accept");

		Consumer<String> consumer2 = System.out::println;
		consumer2.accept(" #2.2:  consumer2 -> accept");

		consumer1.andThen(consumer2);

		newLinePrint();
	}

	private static void exampleAndThenWIthAction() {

		Consumer<String> consumer1 = System.out::println;
		consumer1.accept(" #2.1: consumer1 -> accept");

		Consumer<String> consumer2 = System.out::println;
		consumer2.accept(" #2.2:  consumer2 -> accept");

		Consumer<String> consumer3 = System.out::println;
		consumer3.accept(" #2.3:  consumer2 -> accept");

		consumer1
				  .andThen(consumer2)
				  .andThen(consumer3)
				  .accept(" END ");

		newLinePrint();
	}

	private static void newLinePrint() {
		System.out.println();
	}


	private static void example2(){

		System.out.println(">>> Example 2 <<<");

		Consumer<String> consumer = (x) -> System.out.print( x + "\n");

		List<String> names = new ArrayList<>();
		names.add("Robert");
		names.add("Martin");
		names.add("Jack");
		names.add("Anil");

		names.forEach(consumer);

	}

}