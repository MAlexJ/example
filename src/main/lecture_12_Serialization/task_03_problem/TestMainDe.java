package task_03_problem;

/**
 * Created by Alex on 06.03.2015.
 */
public class TestMainDe {

    public static void main(String[] args) {

        Company company = (Company)SerializationManadger.deserializationObject("company","ser");

        System.out.println(company);

    }

}
