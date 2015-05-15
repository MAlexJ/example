package entity;

import java.util.List;


public class Board extends AbstractEntity {

    private int id;
    private String name;
    private User user;
    private List<Context> contextList;
    private String text;
    private String date;

    public Board() {
    }

    public Board(int id, String name, int id1, String name1, User user, List<Context> contextList, String text, String date) {
        super(id, name);
        this.user = user;
        this.contextList = contextList;
        this.text = text;
        this.date = date;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Context> getContextList() {
        return contextList;
    }

    public void setContextList(List<Context> contextList) {
        this.contextList = contextList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
