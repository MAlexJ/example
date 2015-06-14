package task_03_Obj;


public class User_2 {

    private String name;
    private int age;

    public User_2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User_2 user_2 = (User_2) o;
        //equals -> age
        return this.age == user_2.age;

    }

    @Override
    public String toString() {
        return "User_2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                "}   ->" + getClass();
    }
}
