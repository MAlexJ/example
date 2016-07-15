package lecture_01_exeption_syntax.task_01;

public class Employee {
    String name = "Anna";
    int age = 25;
    double salary = 2000.00;

    void accrueSalary(double salary){
        this.salary = salary;
    }

    void viewSalary(){
        System.out.println("salary ->"+this.salary);
    }


}
