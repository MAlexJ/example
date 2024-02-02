package com.malex.lecture_9_oop_base.inheritance.lecture_01_stream;

public class Circle extends Figure {
	int r;

	public Circle(int x, int y, int r) {
		super(x, y);
		this.r = r;

	}

	public void print() {
		System.out.println("Circle: " + x + "  " + y + "  " + r);
	}

}
