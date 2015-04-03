package task_05_access_modifiers;

import task_5_mod.Student;

public class TestMain {
    public static void main(String[] args) {
        Student student = new Student();
        student.lastName = "Ivanov";
        System.out.println(student);


        Employee employee = new Employee();
        employee.salary =3000;
        employee.age=26;
        employee.lastName="Sidorov";
       // employee.print();
        System.out.println(employee);

    }
}
