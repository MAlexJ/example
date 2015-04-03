package task_03;

public class TestMainIncapsulation {

    public static void main(String[] args) {

        Employee employee = new Employee();
        System.out.println(employee.getName());
        System.out.println(employee.getAge());
        System.out.println(employee.getSalary());

    }
}
