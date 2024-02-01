package com.malex.lecture_9_oop.inheritance.lecture_01_stream;

public class Figure {
	int x;
	int y;

	public Figure(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public void print() {
		System.out.println("Figure: " + x + "  " + y);
	}
}
