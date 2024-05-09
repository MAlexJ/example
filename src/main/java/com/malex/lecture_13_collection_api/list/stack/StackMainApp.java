package com.malex.lecture_13_collection_api.list.stack;

import java.util.Stack;

/**
 * Example of using a class Stack
 *
 * @author malex
 */
public class StackMainApp {

	/**
	 * Start the app
	 */
	public static void main(String[] args) {

		// #1 create a new stack
		createStack(1, 20, 3, 4, 5);

		// #2 add new elements to the top of the stack
		pushNewElementToStack(132, 50, 35, 14, 5);

		// #3 Returns the top element without removing it from the stack
		//    method: peek();
		Stack<Integer> stack = getStack(132, 50, 35, 14, 5);
		System.out.println(" \n method: peek()  ");
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());


		// #4 Removes the top element by removing it from the stack.
		//    method: pop();
		System.out.println(" \n method: pop()  ");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		// #5 Serves to check the stack for the presence of elements
		System.out.println(" \n method: empty()  ");
		System.out.println(stack.empty());
		System.out.println(stack.isEmpty());

		// #6 push() and peek();
		System.out.println(" \n method: push() and peek() ");
		System.out.println("push: " + stack.push(46) + "; peek: " + stack.peek());
		System.out.println("push: " + stack.push(9999) + "; peek: " + stack.peek());

		// #7 search(element el)
		System.out.println(" \n   search(element el)    ");
		System.out.println("search: " + stack.search(46) + "; capacity: " + stack.capacity());

	}


	/**
	 * Returns the stack with data
	 *
	 * @return stack with elements
	 */
	private static Stack<Integer> getStack(int... elements) {

		Stack<Integer> stack = new Stack<>();

		for (int elem : elements) {
			stack.add(elem);
		}

		return stack;
	}


	/**
	 * create a new stack
	 */
	private static void createStack(int... elements) {

		Stack<Integer> stack = new Stack<>();

		for (int elem : elements) {
			stack.add(elem);
		}

		System.out.println(stack);

	}


	/**
	 * Add new elements to the top of the stack
	 *
	 * @param elements numbers
	 */
	private static void pushNewElementToStack(int... elements) {

		Stack<Integer> stack = new Stack<>();

		for (int elem : elements) {
			stack.push(elem);
		}

		System.out.println(stack);

	}

}