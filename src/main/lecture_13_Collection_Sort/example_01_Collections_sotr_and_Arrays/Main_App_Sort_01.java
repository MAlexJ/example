package example_01_Collections_sotr_and_Arrays;

import java.util.*;

/**
 * Sorted using the method sort();
 *
 * @author malex
 */
public class Main_App_Sort_01 {

	public static void main(String[] args) {

    /*
        If you want sort the collection need to use the method Collections.sort(…)
     */
		List<Entity> entities = new ArrayList<>();
		entities.add(new Entity("Alex", 24));
		entities.add(new Entity("Xena", 29));
		entities.add(new Entity("Max", 20));
		System.out.println("List of entity before sorting :" + entities);

		Collections.sort(entities, new Comparator<Entity>() {
			@Override
			public int compare(Entity o1, Entity o2) {
				int sort = o1.getName().compareTo(o2.getName());
				return (sort == 0) ? -1 : sort;
			}
		});
		/*
		 >>>>> In java 8 <<<<<<
        entities.sort((o1, o2) -> {
            int sort = o1.getName().compareTo(o2.getName());
            return (sort == 0) ? -1 : sort;
        });
       */
		System.out.println("List of entity after sorting :" + entities + "\n");


    /*
        If you want sort the array need use the method Arrays.sort(...)
     */
		Entity[] entitiesArr = new Entity[]{new Entity("Anna", 24), new Entity("Eleena", 19), new Entity("Zak", 36)};
		System.out.println("Array before sorting: " + Arrays.toString(entitiesArr));

		Arrays.sort(entitiesArr, new Comparator<Entity>() {
			@Override
			public int compare(Entity o1, Entity o2) {

				if (o1.getCount() == o2.getCount()) {
					return 0;
				}

				if (o1.getCount() < o2.getCount()) {
					return -1;
				} else {
					return 1;
				}

			}
		});

		/*
		>>>>> In java 8 <<<<<<
		Arrays.sort(entitiesArr, (o1, o2) -> Integer.compare(o1.getCount(), o2.getCount()));
		*/
		System.out.println("Array after sorting: " + Arrays.toString(entitiesArr));
	}

}

class Entity {

	private String name;
	private int count;

	Entity(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Entity{" +
				  "name='" + name + '\'' +
				  ", count=" + count +
				  '}';
	}
}
