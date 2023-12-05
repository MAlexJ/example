package com.malex.lecture_2_statements.ExpressionStatements.lecture_2_equals.equals_and_hachcode.override_only_equals;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestMainEquals {

	@Test
	public void test() {
		// #1 create a first object
		MouseObject m1 = new MouseObject();
		m1.setId(1);

		// #2 create a second object
		MouseObject m2 = new MouseObject();
		m2.setId(1);

		// #3 assert these objects
		assertEquals(m1, m2);
		assertTrue(m1.hashCode() != m2.hashCode());
	}
}
