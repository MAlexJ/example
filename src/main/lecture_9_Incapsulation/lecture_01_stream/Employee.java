package lecture_01_stream;

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
