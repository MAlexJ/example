package lecture_01_exeption_syntax.example_06_Area_Rect;


public class TestAreaRect_04 {

    public static void main(String[] args) {
        area(-10, 20);
    }

    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            // у вас плохие аргументы, извините
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        } else {
            return width * height;
        }
    }


}
