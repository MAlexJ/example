package entity;

public class Context extends AbstractEntity{

    private int id;
    private String name;

    public Context(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Context(int id, int id1, String name) {
        super(id);
        id = id1;
        this.name = name;
    }

    public Context(String name, int id, String name1) {
        super(name);
        this.id = id;
        name = name1;
    }

    public Context(int id, String name, int id1, String name1) {
        super(id, name);
        id = id1;
        name = name1;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
