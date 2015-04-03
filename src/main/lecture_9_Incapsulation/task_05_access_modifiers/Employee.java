package task_05_access_modifiers;

public class Employee {
    private String firstName;
    public String lastName;
    int age;
    protected double salary;

//    protected void print (){
//        System.out.println(salary);
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
