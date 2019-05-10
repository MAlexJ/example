package com.malex.lecture_25_Java_8.example_01_default_method_interface;

import java.util.function.Supplier;

/**
 * Main class
 */
class DefaultMain {

	public static void main(String[] args) {

		// #1
		System.out.println(new Defaulable() {
		}.notRequired());

		// #2
		Defaulable defaulable = DefaultFactory.create(DefaultableImpl::new);
		System.out.println(defaulable.notRequired());

		// #3
		defaulable = DefaultFactory.create(OverrideDefaultImpl::new);
		System.out.println(defaulable.notRequired());
	}
}

/**
 * Example of using the default method
 */
interface Defaulable {

	/**
	 * This is the default method
	 *
	 * @return some string
	 */
	default String notRequired() {
		return ">>> Default implementation";
	}
}

/**
 * Factory
 */
interface DefaultFactory {

	static Defaulable create(Supplier<Defaulable> supplier) {
		return supplier.get();
	}
}

/**
 * Class B
 */
class DefaultableImpl implements Defaulable {
}

/**
 * Cass A
 */
class OverrideDefaultImpl implements Defaulable {
	@Override
	public String notRequired() {
		return ">>> new implementation";
	}
}