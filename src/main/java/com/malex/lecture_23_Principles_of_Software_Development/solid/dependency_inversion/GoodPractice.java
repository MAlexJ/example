package com.malex.lecture_23_Principles_of_Software_Development.solid.dependency_inversion;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * The Dependency Inversion Principle in Java
 *
 * <p>link: https://www.baeldung.com/java-dependency-inversion-principle
 *
 * <p>The Dependency Inversion Principle (DIP) forms part of the collection of object-oriented
 * programming principles popularly known as SOLID.
 *
 * <p>At the bare bones, the DIP is a simple – yet powerful – programming paradigm that we can use
 * to implement well-structured, highly-decoupled, and reusable software components.
 *

 */
public class GoodPractice extends AbstractUtils {

  /**
   *  * <p>In other words, high-level modules should not depend directly on low-level modules but on
   *  * common abstractions
   */
  @Test
  public void controller() {
    // given
    var id = 123;

    // when
    UserRepository repository =
        new UserRepositoryImpl(); // it can be AdminRepository or DogRepository
    UserService service = new UserServiceImpl(repository); //

    // then
    service.findUserByCriteria("stefan", 10, id);
  }

  /*
  Abstraction
   */
  private interface UserService {
    void findUserByCriteria(String name, Integer age, int id);
  }

  /*
  Interface
   */
  private interface UserRepository {
    void findUserById(int id);
  }

  private record UserServiceImpl(UserRepository repository) implements UserService {
    @Override
    public void findUserByCriteria(String name, Integer age, int id) {
      printlnString("name = ", name, ", age = ", age.toString());
      repository.findUserById(id);
    }
  }

  private record UserRepositoryImpl() implements UserRepository {
    @Override
    public void findUserById(int id) {
      printlnString("findUserById: " + id);
    }
  }
}
