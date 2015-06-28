package lecture_01_exeption_syntax.task_02;

import java.io.Serializable;

public class BulletinBoard implements Serializable {

    private Integer id;
    private String name;
    private String context;
    private String title;
    private String text;

    public BulletinBoard() {
    }


    public BulletinBoard(Integer id, String name, String context, String title, String text) {
        this.id = id;
        this.name = name;
        this.context = context;
        this.title = title;
        this.text = text;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "BulletinBoard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", context='" + context + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

