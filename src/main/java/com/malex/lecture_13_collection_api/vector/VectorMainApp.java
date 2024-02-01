package vector;

import java.util.Vector;

/**
 * @author malex
 */
public class VectorMainApp {

	/**
	 * Start the app
	 */
	public static void main(String[] args) {

		// #1 create a new vector
		createVector(1, 2, 3, 4, 5, 6, 6, 7, 8, 88, 9);

		// #2 add a new element into the vector
		System.out.println("");
		System.out.println(">>> Vector creates an empty vector of size 10 and with capacityIncrement = 0 ");
		Vector<Integer> vector = getVector(123, 34, 5, 57, 3, 8, 2, 3, 4, 4);
		System.out.println("src: " + vector + "; capacity: " + vector.capacity());
		vector.add(12);
		System.out.println("dest: " + vector + "; capacity: " + vector.capacity());

		// #3 remove delete one element
		System.out.println("");
		System.out.println(">>> remove element index[10]: " + vector.remove(10));
		System.out.println("dest: " + vector + "; capacity: " + vector.capacity());

		// #4 get first element
		System.out.println();
		System.out.println(">>>> get first element: " + vector.firstElement());

		// #5 get last element
		System.out.println();
		System.out.println(">>>> get last element: " + vector.lastElement());

	}

	/**
	 * @param elements are simple numbers
	 */
	private static void createVector(int... elements) {

		Vector<Integer> result = new Vector<>();

		for (int element : elements) {
			result.add(element);
		}

		System.out.println(result);

	}

	/**
	 * Get the vector
	 *
	 * @param elements are simple integer numbers
	 * @return the vector with data
	 */
	private static Vector<Integer> getVector(int... elements) {

		Vector<Integer> result = new Vector<>();

		for (int element : elements) {
			result.add(element);
		}

		return result;
	}

}