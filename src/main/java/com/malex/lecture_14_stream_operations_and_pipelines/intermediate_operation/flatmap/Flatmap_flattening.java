package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.flatmap;

import com.malex.utils.AbstractUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

public class Flatmap_flattening extends AbstractUtils {

  private static final String FILE_NAME;

  static {
    var classLoader = Flatmap_method.class.getClassLoader();
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
