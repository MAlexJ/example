package task_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The base example of using the util Collections class
 */
public class App_09_Collections {

	public static void main(String[] args) {

		// #1 method: nCopies
		methodNCopies();
	}

	/**
	 * The methodCollections.nCopies
	 */
	private static void methodNCopies() {

		// #1 create Entity
		Case cases = new Case("bla bla bal");

		// #2 create a new list and fill it
		List<Case> list = new ArrayList<>(Collections.nCopies(4, cases));

		// #3 print the list
		System.out.println(list);

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
