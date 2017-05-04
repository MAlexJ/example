package equals_and_hachcode.test;

/**
 * Test class
 *
 * @author malex
 */
public class TUser {

    /**
     * Base fields
     */
    private int id;
    private String name;

    public TUser() {
    }

    public TUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TUser tUser = (TUser) o;

        if (id != tUser.id) return false;
        if (name != null ? !name.equals(tUser.name) : tUser.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
