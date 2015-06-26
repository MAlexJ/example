package lecture_04_suppression.example_01;


import lecture_04_suppression.example_00.ExResource;

public class TestExResource {

    public static void main(String[] args) {
        try (lecture_04_suppression.example_00.ExResource ex = new ExResource("0")) {
          //  ex.calc(10, 0);
            throw new RuntimeException("try");
        }
    }

}
