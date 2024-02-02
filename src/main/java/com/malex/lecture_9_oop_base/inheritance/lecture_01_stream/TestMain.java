package com.malex.lecture_9_oop_base.inheritance.lecture_01_stream;

public class TestMain {
	public static void main(String[] args) {
		Figure figure = new Figure(2, 5);
		figure.print();
		
		Rectangle rectangle = new Rectangle(2, 3, 4, 5);
		rectangle.print();
		
		Circle circle = new Circle(2, 6, 5);
		circle.print();
		
		Hexagon hexagon = new Hexagon(1, 2, 3, 4, 5, 6);
		hexagon.print();
		
	}
}
