package task_01_length;

import java.util.Date;

public class BulletinBoard {

    private int id;
    private String account;
    private Date date;
    private String category;
    private String title;
    private String text;

    public BulletinBoard() {
    }

    public BulletinBoard(int id, String account, Date date, String category, String title, String text) {
        this.id = id;
        this.account = account;
        this.date = date;
        this.category = category;
        this.title = title;
        this.text = text;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
                ", account='" + account + '\'' +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
