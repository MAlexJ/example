package com.malex.lecture_1_object_peferences;

import static junit.framework.TestCase.*;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

/**
 * info: https://www.youtube.com/watch?v=5HC8qVHQPi8
 */
public class StrongReferenceApp extends AbstractUtils {

  @Test
  public void simple() {
    Object obj = new Object();
    assertNotNull(obj);

    obj = null;
    assertNull(obj);
  }

  @Test
  public void collections() {
    Object obj = new Object();

    List<Object> list = new ArrayList<>();
    list.add(obj);
    obj = null;
    assertNull(obj);

    Object objFromList = list.getFirst();
    objFromList = null;
    assertNull(objFromList);

    assertNotNull(list.getFirst());
  }

  @Test
  public void objReferences() {
    // 1. init object
    var user = new Usr("Alex");

    // 2. init array
    Usr[] users = new Usr[1];
    users[0] = user;
    var usrFromArray = users[0];

    // 3. verify
    // ==
    assertSame(usrFromArray, user);
    assertSame(usrFromArray, users[0]);

    // equals
    assertEquals(usrFromArray, user);
  }

  @Test
  public void objReferencesNull() {
    // 1. init object
    var user = new Usr("Alex");

    // 2. init array
    Usr[] users = new Usr[1];
    users[0] = user;

    // 3. change exist object
    user.setName("Anna");
    user = null;

    // 4. get object ref from array
    var usrFromArray = users[0];
    users = null;

    println(usrFromArray);
    assertEquals("Anna", usrFromArray.getName());
  }

  @Test
  public void objReferencesAddToCollections() {
    // 1. init object
    var user = new Usr("Alex");

    // 2. put object to collections
    var list = List.of(user);
    var set = Set.of(user);
    var map = Map.of("first", user);
    Usr mapUser = map.get("first");
    mapUser = null;
    println("map:", map);

    // 3. change reference
    set.iterator().next().setName("Anna");

    // 4. verify user
    assertEquals("Anna", list.getFirst().getName());
  }

  @Test
  public void objReferencesMethod() {
    // 1. init object
    var user = new Usr("Alex");

    // 2. put object to collections
    Usr changedUser = changeUserToNull(user, "New");

    // 3. verify user
    assertNotNull(user);
    assertEquals("New", user.getName());

    // 4. verify user reference
    assertNull(changedUser);
  }

  private Usr changeUserToNull(Usr user, String name) {
    user.setName(name);
    println("hashCode", user.hashCode());
    user = null;
    return user;
  }

  @ToString
  @Setter
  @Getter
  private static class Usr {

    private String name;

    private Usr(String name) {
      this.name = name;
      printlnString("hashCode:", Integer.toString(this.hashCode()));
    }
  }
}
