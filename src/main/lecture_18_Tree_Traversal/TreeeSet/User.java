package TreeeSet;

public class User {

    public User() {
    }

    public User(int number, int age) {
        this.number = number;
        this.age = age;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return number == user.number;

    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", number=" + number +
                '}';
    }

    private   int age;

    private int number;


}
