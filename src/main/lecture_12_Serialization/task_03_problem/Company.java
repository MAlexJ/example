package task_03_problem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 06.03.2015.
 */
public class Company implements Serializable{
    private List<Employee> listEmployee = new ArrayList<>();

    public boolean addEmployee(Employee empl) {
        if (empl == null) {
            return false;
        }
        return this.listEmployee.add(empl);
    }

    public boolean removeEmployee(Employee empl) {
        return this.listEmployee.remove(empl);
    }

    public void printEmployee(){
        for(Employee iter:this.listEmployee){
            System.out.println(iter);
        }

    }

    @Override
    public String toString() {
        return "Company{" +
                "listEmployee=" + listEmployee +
                '}';
    }
}
