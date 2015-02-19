package task_1;

import org.apache.log4j.Logger;

/**
 * Created by admin on 29.01.2015.
 * <p>
 * Exchange values through an additional variable
 */
public class App {
    private final static Logger LOG = Logger.getLogger(App.class);

    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        LOG.debug("a = " + a);
        LOG.debug("b = " + b);

        LOG.debug("********************");
        int tmp = a;
        a = b;
        b = tmp;

        LOG.debug("a = " + a);
        LOG.debug("b = " + b);

        LOG.debug("********************");

        Dog mike = new Dog(2,"mike");
        Dog hootDog = new Dog(3,"hootDog");

        LOG.debug("mike = " + mike);
        LOG.debug("hootDog = " + hootDog);
        LOG.debug("********************");

        //mike = hootDog;
        //hootDog=mike;

        Dog temp = mike;
        mike = hootDog;
        hootDog = temp;

        LOG.debug("mike = " + mike);
        LOG.debug("hootDog = " + hootDog);

    }
}

class Dog {
    private int age;
    private String name;

    public Dog(int age, String name) {
        this.age = age;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
