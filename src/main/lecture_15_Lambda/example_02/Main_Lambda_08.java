package example_02;

/**
 * Links to the constructor
 *
 * @author malex
 */
public class Main_Lambda_08 {

    public static void main(String[] args) {
        UserBuilder builder = User::new;

        User alex = builder.createUser(21, "Alex");
        System.out.println(alex + "\n");

        User max = builder.createUser(20, "Max");
        System.out.println(max);

    }
}

/**
 * Functional interface
 */
interface UserBuilder {

    User createUser(int age, String name);
}

/**
 * Entity class
 */
class User {
    private int age;
    private String name;

    User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}