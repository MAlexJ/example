package task_03_problem;

import java.io.Serializable;

public class Employee implements Serializable {
    private String firstName;
    private String lastName;
    private String age;
    private String appointment;



    public Employee(){}

    public Employee(String firstName, String lastName, String age, String appointment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.appointment = appointment;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", appointment='" + appointment + '\'' +
                '}';
    }
}
