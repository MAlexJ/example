package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.flatmap;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * The flatMap() operation has the effect of applying a one-to-many transformation to the elements of the stream,
 * and then flattening the resulting elements into a new stream.
 *
 * This is an intermediate operation.
 */
public class Flatmap_method extends AbstractUtils {

  @Test
  public void run() {
    var numbers = List.of(List.of(1, 2), List.of(3), List.of(4, 5, 6, 7));
    var resultFlatmap =
        numbers.stream() //
            .flatMap(
                list -> {
                  println("element:", list);
                  return list.stream();
                }) //
            .toList();

    println("result:", resultFlatmap);
    assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), resultFlatmap);
  }

  private static final String FILE_NAME;

  static {
    ClassLoader classLoader = Flatmap_method.class.getClassLoader();
    URL resource = classLoader.getResource("source/source.txt");
    FILE_NAME = resource.getFile();
  }

  @Test
  public void flattening() throws IOException {
    var path = new File(FILE_NAME).toPath();

    /*
     * line 1: Source file
     * line 2: new line in a file
     */
    Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);

    /*
     * flattening: get all words
     */
    Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));

    words.forEach(this::println);
  }

  @Test
  public void flatteningObject() {
    var companies = List.of(new Company("ERAT"), new Company("LOH_SOFT"));

    // find all employees
    List<Employee> employees =
        companies.stream().flatMap(company -> company.employees().stream()).toList();
    employees.forEach(this::println);
  }

  private record Company(String name, List<Employee> employees) {

    public Company(String name) {
      this(
          name,
          List.of(
              new Employee(name + "_Cat"),
              new Employee(name + "_Dave"),
              new Employee(name + "_John")));
    }
  }

  private record Employee(String name) {}
}
