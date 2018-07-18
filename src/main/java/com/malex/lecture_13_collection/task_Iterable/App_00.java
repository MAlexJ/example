package com.malex.lecture_13_collection.task_Iterable;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class App_00 {
    private static final Logger LOG = Logger.getLogger(App_00.class);

    public static void main(String[] args) {
        LOG.debug("start main");

        Student student_1 = new Student(21, "Mike");
        Student student_2 = new Student(20, "Anna");
        Student student_3 = new Student(23, "Alex");
        Student student_4 = new Student(24, "Olga");
        Student student_5 = new Student(20, "Misha");
        Student student_6 = new Student();
        student_6.setAge(30);
        student_6.setName("Root");

        Group group = new Group();
        group.setList(new ArrayList<>(Arrays.asList(student_1, student_2, student_3, student_4, student_5)));
        group.addStudent(student_6);

        for (Student iter : group) {
            LOG.debug(iter);
        }

        System.out.println();

        Group group_2 = new Group();
        group_2.setList(new LinkedList<>(Arrays.asList(student_1, student_2, student_3, student_4, student_5)));
        group_2.addStudent(student_6);
        group_2.removeStudent(student_3);


        for (Student iter : group_2) {
            LOG.debug(iter);
        }
    }
}
