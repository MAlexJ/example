package lecture_04_suppression.example_04;


import lecture_04_suppression.example_00.ExResource;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestExResource {

    public static void main(String[] args) {


        try (ExResource ex0 = new ExResource("0");
             ExResource ex1 = new ExResource("1");
             ExResource ex2 = new ExResource("2");
             ExResource ex3 = new ExResource("3"))
        {
            //  ex.calc(10, 0);

            throw new RuntimeException("try");

        } catch (Throwable e){

            System.out.println(e);

            Throwable[] suppressed = e.getSuppressed();
            for (Throwable iter:suppressed) {
                System.out.println(iter);

                Set<String> set = new TreeSet<>();

            }

        }


    }

}
