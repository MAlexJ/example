package com.malex.lecture_25_Java_8.example_02_referens_method;

import org.junit.Test;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReferentsClazz {

	// field
	private String name = "default name";

	// referents method
	private static ReferentsClazz create(final Supplier<ReferentsClazz> supplier) {
		return supplier.get();
	}

	// Class::static_method
	private static void collide(final ReferentsClazz clazz) {
		System.out.println("Collided " + clazz.toString());
	}

	// instance::method
	private void follow(final ReferentsClazz another) {
		System.out.println("Following the " + another.toString());
	}

	private void repair() {
		System.out.println("Repaired " + this.toString());
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ReferentsClazz{" +
				  "name='" + name + '\'' +
				  '}';
	}

	@Test
	public void test() {

		// #1
		ReferentsClazz clazz = ReferentsClazz.create(ReferentsClazz::new);

		ReferentsClazz test = new ReferentsClazz();
		test.setName("new name");
		List<ReferentsClazz> list = Stream
				  .of(clazz, test)
				  .collect(Collectors.toList());

		// #2
		list.forEach(ReferentsClazz::collide);

		// #3
		list.forEach(ReferentsClazz::repair);

		// #4
		list.forEach(clazz::follow);
	}
}