package task_03_problem;

import javax.swing.*;

/**
 * Created by Alex on 06.03.2015.
 */
public class TestMain {

    public static void main(String[] args) {
        Company company = new Company();
        Employee employee = new Employee();

        employee.setLastName(JOptionPane.showInputDialog(null, "Введите LastName"));
        employee.setFirstName(JOptionPane.showInputDialog(null, "Введите FirstName"));
        employee.setAge(JOptionPane.showInputDialog(null, "Введите Age"));
        employee.setAppointment(JOptionPane.showInputDialog(null, "Введите Appointment"));

        /*Employee employee_1 = new Employee("Вася","Никитин",20,"Директор");
        Employee employee_2 = new Employee("Коля","Михалков",22,"Бугалтер");
        Employee employee_3 = new Employee("Оля","Фанаскова",19,"Инженер");
        company.addEmployee(employee_1);
        company.addEmployee(employee_2);
        company.addEmployee(employee_3);*/

        SerializationManadger.serializationObject("company", "ser", company);
    }

}
