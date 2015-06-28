package lecture_03_exception_java_7.example_04_try_two_exception;

/**
 * Created by Alex on 24.06.2015.
 */
public class TestResEx {

    public static void main(String[] args) {

        try (ResourseEx resourseEx_01 = new ResourseEx();
             ResourseEx resourseEx_02 = new ResourseEx()) {
            System.out.println("body");
        }
    }

}
