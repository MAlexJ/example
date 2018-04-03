package com.malex.lecture_2_equals.equals_and_hachcode.override_only_equals;

import java.util.Arrays;

public class MouseObject {

	private int id;

	private String name;

	private int[] params;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getParams() {
		return params;
	}

	public void setParams(int[] params) {
		this.params = params;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MouseObject that = (MouseObject) o;

		if (id != that.id) return false;

		if (name != null ? !name.equals(that.name) : that.name != null) return false;

		return Arrays.equals(params, that.params);
	}

}
