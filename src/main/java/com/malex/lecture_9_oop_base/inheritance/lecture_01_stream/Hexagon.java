package com.malex.lecture_9_oop_base.inheritance.lecture_01_stream;

public class Hexagon extends Rectangle {
	int x3;
	int y3;

	public Hexagon(int x, int y, int x2, int y2, int x3, int y3) {
		super(x, y, x2, y2);
		this.x3 = x3;
		this.y3 = y3;
	}

	public void print() {
		System.out.println("Hexagon: " + x + "  " + y + "  " + w + "  " + h
				+ "  " + x3 + "  " + y3);
	}

}
