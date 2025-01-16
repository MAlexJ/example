package com.malex.lecture_13_collection_api.algoritms.joins;

import static junit.framework.TestCase.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.Test;

/*
 * SQL joins allow us to combine information from multiple tables based on a related column.
 * link: https://medium.com/@adilsaid64/understanding-sql-joins-a-quick-guide-with-examples-b0985419ea85
 *
 * In this article, we go through:
 * 1. Inner Joins
 * 2. Outer Joins (Left, Right and Full)
 * 3. Cross Joins
 * 4. Self Joins
 */
public class ListJoins {

  /*
   * Inner Join
   *
   * This is the simplest join.
   * Inner joins return the records that have matching values in both tables.
   * This is a symmetrical joint.
   * This means you get the same result if you join table A with table B or table B with table A.
   *
   * SELECT Employees.*, Departments.*
   * FROM Employees
   * INNER JOIN Departments
   * ON Employees.EmployeeID = Departments.EmployeeID;
   */
  public static <E> List<E> innerJoin(List<E> list1, List<E> list2) {
    var tempSet = new HashSet<E>(list2);
    return list1.stream().filter(tempSet::contains).toList();
  }

  @Test
  public void innerJoin_test() {
    assertEquals(List.of(), innerJoin(List.of(), List.of()));
    assertEquals(List.of(), innerJoin(List.of(2), List.of(1)));
    assertEquals(List.of(1), innerJoin(List.of(1), List.of(1)));
    assertEquals(List.of(2), innerJoin(List.of(1, 2, 3, 4), List.of(2, -3, -4, 5, 6)));
    assertEquals(List.of(2, 3, 4), innerJoin(List.of(1, 2, 3, 4), List.of(2, 3, 4, 5, 6)));
  }

  /*
   * Left Outer Join
   *
   * A left outer join returns all rows from the left table and the matched rows from the right table.
   * If there is no match it returns a NULL in the right table.
   *
   * SELECT Employees.*, Departments.*
   * FROM Employees
   * LEFT JOIN Departments
   * ON Employees.EmployeeID = Departments.EmployeeID;
   */
  public static <E> Map<E, E> leftOuterJoin(List<E> left, List<E> right) {

    // Example matching condition: equality of elements
    HashMap<E, Optional<E>> map =
        left.stream()
            .collect(
                Collectors.toMap(
                    leftElement -> leftElement, // key: element from left list
                    leftElement ->
                        right.stream()
                            .filter(leftElement::equals) // matching condition
                            .findFirst(),
                    (e1, e2) -> e1
                        , // merge function (not used since keys are unique)
                    HashMap::new // collect into a HashMap
                    ));

    // Convert Optional<E> back to E, allowing null values
    var resultMap = new HashMap<E, E>();
    map.forEach((key, value) -> resultMap.put(key, value.orElse(null)));
    return resultMap;
  }

  @Test
  public void leftOuterJoin_test() {
    assertEquals(Collections.emptyMap(), leftOuterJoin(List.of(), List.of()));
    assertEquals(
        new HashMap<>() {
          {
            put(1, null);
          }
        },
        leftOuterJoin(List.of(1), Collections.emptyList()));
    assertEquals(
        new HashMap<>() {
          {
            put(1, 1);
          }

          {
            put(2, null);
          }
        },
        leftOuterJoin(List.of(1, 2), List.of(1)));
    assertEquals(
        new HashMap<>() {
          {
            put(1, 1);
          }

          {
            put(2, null);
          }
        },
        leftOuterJoin(List.of(1, 2), List.of(1, 3, 4)));
  }

  /*
   * Right Outer Join
   */
  public <E> List<E> rightOuterJoin(List<E> list1, List<E> list2) {
    return null;
  }

  /*
   * Full Outer Join
   */
  public <E> List<E> fullOuterJoin(List<E> list1, List<E> list2) {
    return null;
  }

  /*
   * Self Joins
   */
  public <E> List<E> selfJoins(List<E> list1, List<E> list2) {
    return null;
  }
}
