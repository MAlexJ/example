package linkedlist;

import java.util.LinkedList;

/**
 * @author malex
 */
public class LinkedListMain {

	public static void main(String[] args) {

		// #1 create a new LinkedList
		createLinkedList(1, 2, 3, 4, 5);

	}

	/**
	 * Create a new LinkedList
	 *
	 * @param elements are simple numbers
	 */
	private static void createLinkedList(int... elements) {

		LinkedList<Integer> result = new LinkedList<>();

		for (int element : elements) {
			result.add(element);
		}

		System.out.println(result);
	}

}