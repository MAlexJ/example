package example_17_Join_String;

public class JoinStringEx01 {

	public static void main(String[] args) {

		/*
		 * CharSequence delimiter, CharSequence... elements
		 */
		String join = String.join("/", "a", "b", "c", "d", "e", "f");
		System.out.println(join);

		System.out.println();

		join = String.join("=", "java", null);
		System.out.println(join);


		System.out.println();

		try {

			String.join(null, "java", null);

		} catch (RuntimeException ex) {
			System.out.println("NPE : " + ex.getMessage());
		}

	}

}
