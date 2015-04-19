package task_04;

public class TestMainIncapsulation {

    public static void main(String[] args) {
        Employee employee_01 = new Employee();
        employee_01.setName("Anna");
        employee_01.setAge(26);
        employee_01.setSalary(2000.00);
        System.out.println(employee_01);

        Employee employee_02 = new Employee("Vasya",25,3000.00);
        System.out.println(employee_02);
    }
}
