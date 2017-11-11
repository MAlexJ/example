package example_07_map.example_03_list_to_map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap_2 {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		map.put(10, "apple");
		map.put(20, "orange");
		map.put(30, "banana");
		map.put(40, "watermelon");
		map.put(50, "dragonfruit");

		System.out.println("Export Map Key to List...");
		System.out.println("Map: " + map + "\n");

		List<Integer> keys = map.entrySet()
				  .stream()
				  .map(Map.Entry::getKey)
				  .collect(Collectors.toList());
		System.out.println("List of keys: \n" + keys + "\n");

		List<String> values = map.entrySet()
				  .stream()
				  .map(Map.Entry::getValue)
				  .collect(Collectors.toList());
		System.out.println("List of values: \n" + values);

	}

}
