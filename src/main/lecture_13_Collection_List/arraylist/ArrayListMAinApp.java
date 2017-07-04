package arraylist;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author malex
 */
public class ArrayListMAinApp {

	/**
	 * Start the app
	 */
	public static void main(String[] args) throws Exception {

		// #1 create a new ArrayList
		createArrayList(12, 23, 2, 4, 6, 7, 8, 9);

		// #2 add a new element into the ArrayList
		ArrayList<Integer> arrayList = getArrayList(2, 3, 6, 1, 2, 3, 4, 5, 6, 7);
		System.out.println();
		System.out.println("src: " + arrayList + ";  size: " + arrayList.size() + "; capacity: " + getCapacity(arrayList));
		System.out.println("    add a new element: " + arrayList.add(12));
		System.out.println("dest: " + arrayList + "; size: " + arrayList.size() + "; capacity: " + getCapacity(arrayList));

		// #3


	}

	/**
	 * Get capacity
	 *
	 * @param l is the ArrayList
	 * @return numbers of capacity
	 * @throws Exception if error
	 */
	private static int getCapacity(ArrayList<?> l) throws Exception {

		// reflection API
		Field dataField = ArrayList.class.getDeclaredField("elementData");
		// get the access to private field
		dataField.setAccessible(true);

		return ((Object[]) dataField.get(l)).length;
	}


	/**
	 * Create a new ArrayList
	 *
	 * @param elements are simple numbers
	 */
	private static void createArrayList(int... elements) {

		ArrayList<Integer> result = new ArrayList<>();

		for (int element : elements) {
			result.add(element);
		}

		System.out.println(result);
	}


	/**
	 * Get ArrayList with data
	 *
	 * @param elements are numbers
	 * @return ArrayList
	 */
	private static ArrayList<Integer> getArrayList(int... elements) {

		ArrayList<Integer> result = new ArrayList<>();

		for (int element : elements) {
			result.add(element);
		}

		return result;
	}

}