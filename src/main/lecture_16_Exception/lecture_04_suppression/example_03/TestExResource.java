package lecture_04_suppression.example_03;


import lecture_04_suppression.example_00.ExResource;

public class TestExResource {

    public static void main(String[] args) {
        try (ExResource ex = new ExResource("0")) {
            //  ex.calc(10, 0);
            throw new RuntimeException("try");
        }
    }

}
