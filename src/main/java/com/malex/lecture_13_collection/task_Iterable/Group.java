package com.malex.lecture_13_collection.task_Iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Group implements Iterable<Student> {
    private List<Student> list;

    public Group() {
        list = new ArrayList<>();
    }

    public void addStudent(Student stud) {
        list.add(stud);
    }

    public void removeStudent(Student stud) {
        list.remove(stud);
    }


    @Override
    public Iterator<Student> iterator() {
        return list.iterator();
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}
