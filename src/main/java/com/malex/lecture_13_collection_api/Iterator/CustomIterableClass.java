package com.malex.lecture_13_collection_api.Iterator;

import static junit.framework.TestCase.assertNotNull;

import java.util.*;
import lombok.*;
import org.junit.Test;

public class CustomIterableClass {

  private final Student alex = new Student(23, "Alex");
  private final Student root = new Student(30, "Root");

  private final List<Student> students =
      List.of(
          new Student(21, "Mike"), //
          new Student(20, "Anna"), //
          alex, //
          new Student(24, "Olga"), //
          new Student(20, "Misha") //
          );

  @Test
  public void iterableClassSample() {
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

  private record Student(int age, String name) {}

  private record Group(List<Student> list) implements Iterable<Student> {

    private Group {
      Objects.requireNonNull(list);
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
  }
}
