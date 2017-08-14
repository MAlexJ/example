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
		System.out.println("  >>> add a new element: " + arrayList.add(12));
		System.out.println("dest: " + arrayList + "; size: " + arrayList.size() + "; capacity: " + getCapacity(arrayList));


		// #3 remove the element from the list
		System.out.println();
		System.out.println("src: " + arrayList + ";  size: " + arrayList.size() + "; capacity: " + getCapacity(arrayList));
		Integer num = 12;
		System.out.println("  >>> remove the element " + num + " from array: " + arrayList.remove(num));
		System.out.println("dest: " + arrayList + "; size: " + arrayList.size() + "; capacity: " + getCapacity(arrayList));
		num = 222;
		System.out.println("  >>> remove no such " + num + " element: " + arrayList.remove(num));
		System.out.println("dest: " + arrayList + "; size: " + arrayList.size() + "; capacity: " + getCapacity(arrayList));


		// #4 create a new arraylist with capasity
		ArrayList<String> strings = new ArrayList(25);
		System.out.println();
		System.out.println("src: " + strings + ";  size: " + strings.size() + "; capacity: " + getCapacity(strings));


		// #5 new element add to middle
		System.out.println();
		System.out.println("src: " + arrayList + ";  size: " + arrayList.size() + "; capacity: " + getCapacity(arrayList));
		System.out.println("  >>> add a new element '1000' in middle of the array list");
		arrayList.add(4, 1000);
		System.out.println("dest: " + arrayList + "; size: " + arrayList.size() + "; capacity: " + getCapacity(arrayList));


		// #6 trimToSize()
		System.out.println();
		System.out.println("src: " + arrayList + ";  size: " + arrayList.size() + "; capacity: " + getCapacity(arrayList));
		arrayList.trimToSize();
		System.out.println("  >>> trimToSize() to array list");
		System.out.println("dest: " + arrayList + "; size: " + arrayList.size() + "; capacity: " + getCapacity(arrayList));

		// #7 add to start and end
		System.out.println();
		System.out.println("src: " + arrayList + ";  size: " + arrayList.size() + "; capacity: " + getCapacity(arrayList));
		arrayList.add(0, 2222);
		arrayList.add(arrayList.size(), 33333);
		System.out.println("dest: " + arrayList + "; size: " + arrayList.size() + "; capacity: " + getCapacity(arrayList));

		// #8 add to >>>>>
		try {
			System.out.println();
			arrayList.add(234, 2222);
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Exception: " + ex.getClass().getSimpleName() + ", message: " + ex.getMessage());
		}

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