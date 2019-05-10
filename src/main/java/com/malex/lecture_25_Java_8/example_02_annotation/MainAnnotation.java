package com.malex.lecture_25_Java_8.example_02_annotation;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Supplier;

public class MainAnnotation {

	@NewValue("test_queue value")
	private String value;

	@NewValue("test_queue value")
	public String getValue() {
		return value;
	}

	@NewValue("test_queue value")
	public void setValue(String value) {
		this.value = value;
	}

	private static MainAnnotation create(Supplier<MainAnnotation> supplier) {
		return supplier.get();
	}

	@Override
	public String toString() {
		return "MainAnnotation{" +
				  "value='" + value + '\'' +
				  '}';
	}

	@Test
	public void test() {
		MainAnnotation annotation = MainAnnotation.create(MainAnnotation::new);
		System.out.println(annotation);
	}

}

@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface NewValue {
	String value();
}
