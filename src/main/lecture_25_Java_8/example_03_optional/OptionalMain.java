package example_03_optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalMain {

	@Test
	public void test() {

		Optional<String> fullName = Optional.ofNullable(null);
		System.out.println("Full Name is set? " + fullName.isPresent());
		System.out.println("Full Name: " + fullName.orElseGet(() -> ">>? none <<<"));
		System.out.println(fullName
				  .map(s -> "Hey " + s + "!")
				  .orElse("Hey Stranger!"));

	}

}