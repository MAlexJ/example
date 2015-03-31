package entity;

// Entity_1

import java.io.Serializable;

public class Discipline implements Serializable {
    private Integer id;
    private String name;

    public Discipline() {
    }

    public Discipline(String name) {
        this.name = name;
    }

    public Discipline(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "entity.Discipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
