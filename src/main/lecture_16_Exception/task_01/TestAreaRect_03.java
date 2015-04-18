package task_01;


public class TestAreaRect_03 {

    public static void main(String[] args) {
        area(-10, 20);
    }

    public static int area(int width, int height) {
        if (width < 0 || height < 0) {

            // у вас плохие аргументы, извините
            System.exit(0);

            return -1; // специальное "неправильное" значение площади
        } else {
            return width * height;
        }
    }


}
