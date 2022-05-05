package com.malex.lecture_13_collection.task_Iterable;

import lombok.*;
import lombok.extern.java.Log;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertNotNull;

@Log
public class ClassImplIterableSample {

    @Test
    public void iterableClassSample() {
        Student alex = new Student(23, "Alex");
        Student root = new Student(30, "Root");
        List<Student> students = Arrays.asList( //
                new Student(21, "Mike"), //
                new Student(20, "Anna"), //
                alex, //
                new Student(24, "Olga"), //
                new Student(20, "Misha") //
        );

        Group group = new Group(new ArrayList<>(students));
        group.addStudent(root);

        for (Student student : group) {
            assertNotNull(student);
        }

        Iterator<Student> iterator = group.iterator();
        while (iterator.hasNext()) {
            assertNotNull(iterator.next());
        }

        Group secondGroup = new Group(new LinkedList<>(students));
        secondGroup.addStudent(root);
        secondGroup.removeStudent(alex);

        for (Student student : secondGroup) {
            assertNotNull(student);
        }
    }

    @Getter
    @AllArgsConstructor
    @RequiredArgsConstructor
    @EqualsAndHashCode
    @ToString
    private static class Student {
        int age;
        String name;
    }


    @Getter
    @AllArgsConstructor
    private static class Group implements Iterable<Student> {

        private List<Student> list;

        public void addStudent(Student stud) {
            list.add(stud);
        }

        public void removeStudent(Student stud) {
            list.remove(stud);
        }

        @Override
        public Iterator<Student> iterator() {
            return Optional.ofNullable(list)  //
                    .map(List::iterator) //
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
