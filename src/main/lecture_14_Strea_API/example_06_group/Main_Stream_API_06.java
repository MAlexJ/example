package example_06_group;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static util.StreamAPIUtil.print;

/**
 * A simple example of using the method 'group' of Stream API
 */
public class Main_Stream_API_06 {

	public static void main(String[] args) {
		//example_01
		use_collect_grouping_by(
				  new Phone("iPhone 6 S", "Apple", 600),
				  new Phone("Lumia 950", "Microsoft", 500),
				  new Phone("iPhone 5 S", "Apple", 450),
				  new Phone("Lumia 640", "Microsoft", 200)
		);

	}

	private static void use_collect_grouping_by(Phone... phones) {
		print("Example_01");

		Stream<Phone> phoneStream = Stream.of(phones);

		Map<String, List<Phone>> phonesByCompany = phoneStream.collect(
				  Collectors.groupingBy(Phone::getCompany));

		for (Map.Entry<String, List<Phone>> item : phonesByCompany.entrySet()) {

			System.out.println(item.getKey());
			for (Phone phone : item.getValue()) {

				System.out.println(phone.getName());
			}
			System.out.println("");
		}

		print();
	}

	private static class Phone {

		private String name;
		private String company;
		private int price;

		Phone(String name, String comp, int price) {
			this.name = name;
			this.company = comp;
			this.price = price;
		}

		String getName() {
			return name;
		}

		int getPrice() {
			return price;
		}

		String getCompany() {
			return company;
		}
	}
}
