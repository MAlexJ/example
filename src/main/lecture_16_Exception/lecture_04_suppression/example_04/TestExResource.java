package lecture_04_suppression.example_04;


import lecture_04_suppression.example_00.ExResource;

public class TestExResource {

    public static void main(String[] args) {


        try (ExResource ex0 = new ExResource("0");
             ExResource ex1 = new ExResource("1");
             ExResource ex2 = new ExResource("2");
             ExResource ex3 = new ExResource("3"))
        {
            //  ex.calc(10, 0);
            throw new RuntimeException("try");
        }


    }

}
