package task_02;

import java.io.Serializable;

public class ProfileSerializ implements Serializable {
    private String firstName;
    private String midlName;
    private String lastName;

    public ProfileSerializ() {
    }

    public ProfileSerializ(String firstName, String midlName, String lastName) {
        this.firstName = firstName;
        this.midlName = midlName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidlName() {
        return midlName;
    }

    public void setMidlName(String midlName) {
        this.midlName = midlName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ProfileSerializ{" +
                "firstName='" + firstName + '\'' +
                ", midlName='" + midlName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

