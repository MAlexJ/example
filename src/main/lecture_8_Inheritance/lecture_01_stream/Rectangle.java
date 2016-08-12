package lecture_01_stream;

public class Rectangle extends Figure {

	int w;
	int h;

	public Rectangle(int x, int y, int x2, int y2) {
		super(x, y);
		this.w = x2;
		this.h = y2;
	}

	public void print() {
		System.out.println("Rectangle: " + x + "  " + y + "  " + w + "  " + h);
	}

}
