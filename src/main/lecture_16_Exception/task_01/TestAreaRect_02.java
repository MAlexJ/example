package task_01;


public class TestAreaRect_02 {


    public static void main(String[] args) {
        area(-10, 20);
    }

    public static int area(int width, int height) {
        if (width < 0 || height < 0) {

            // у вас плохие аргументы, извините
            System.out.println("Bad ...");

            return -1; // специальное "неправильное" значение площади
        } else {
            return width * height;
        }
    }

}

