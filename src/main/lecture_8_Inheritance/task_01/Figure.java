package task_01;

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
