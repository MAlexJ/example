package com.malex.lecture_13_collection_api.task_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The base example of using the util Collections class
 */
public class App_09_Collections {

	/**
	 * Run
	 */
	public static void main(String[] args) {

		// #1 method: nCopies(...)
		methodNCopies(new Case("bla bla bal"), "Passed parameter is object.", 4);

		// #2 method: nCopies(...)
		// Passed parameter is null.
		methodNCopies(null, "Passed parameter is null.", 10);

		// #3 method: fill(...)
		methodFill(new Case("bla bla bal"), "NEW NAME", "method fill:", 3);

	}

	/**
	 * Use the method Collections.fill()
	 *
	 * @param ob      the entity's object
	 * @param newName the new name entity
	 * @param text    the text for displayed message
	 * @param countOb the count a new Objects in the list
	 */
	private static void methodFill(Case ob, String newName, String text, int countOb) {

		// #1 create a new list of the object
		List<Case> caseList = methodNCopies(ob, text, countOb);

		// #2 fill new objects to the list
		Collections.fill(caseList, new Case(newName));

		// #3 Print list
		System.out.println(text + "  " + caseList);
	}

	/**
	 * The method Collections.nCopies
	 */
	private static List<Case> methodNCopies(Case cases, String text, int countObj) {

		// #1 create a new list and fill it
		List<Case> list = new ArrayList<>(Collections.nCopies(countObj, cases));

		// #1 print the list
		System.out.println(text + "  " + list);

		return list;
	}


	/**
	 * Entity class
	 */
	static class Case {

		private String name;

		Case(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Case{" +
					  "name='" + name + '\'' +
					  '}';
		}
	}

}
