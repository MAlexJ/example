package lecture_01_exeption_syntax.task_01;

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
