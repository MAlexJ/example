package lecture_01_exeption_syntax.task_01;


public class TestMainIncapsulation {

    public static void main(String[] args) {

        Employee employee = new Employee();
        System.out.println(employee.name);
        System.out.println(employee.age);
        System.out.println(employee.salary);

        employee.accrueSalary(3000);
        employee.viewSalary();

        System.out.println(employee.salary);
        employee.salary=2;
        System.out.println(employee.salary);
    }

}
