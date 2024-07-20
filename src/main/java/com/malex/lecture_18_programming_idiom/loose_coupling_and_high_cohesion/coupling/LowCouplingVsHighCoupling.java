package com.malex.lecture_18_programming_idiom.loose_coupling_and_high_cohesion.coupling;

import java.util.List;

/**
 * Coupling is the degree of interdependence between software modules. A module could be a class or
 * a package or even a microservice.
 *
 * <p>Effectively, the coupling is about how changing one thing required change in another.
 */
public class LowCouplingVsHighCoupling {

  /**
   * Tight coupling (or high coupling)
   *
   * <p>Two modules have high coupling (or tight coupling) if they are closely connected.
   *
   * <p>For example, two concrete classes storing references to each other and calling each other’s
   * methods. As shown in classes below, Customer and Order are tightly coupled to each other. <br>
   * The Customer is storing the list of all the orders placed by a customer, whereas the Order is
   * storing the reference to the Customer object.
   */
  private class HighCoupling {
    /* Customer and Order are tightly coupled to each other */
    private record Customer(int id, String name, List<Order> orders) {}

    private record Order(int id, String description, Customer customer) {}
  }

  /**
   * Loose coupling (or low coupling)
   *
   * <p>Modules with low coupling among them work mostly independently of each other.
   *
   * <p>Every time the customer places a new order, we need to add it to the order list present
   * inside the Customer. This seems an unnecessary dependency. Also, Order only needs to know the
   * customer identifier and does need a reference to the Customer object.
   */
  private class LowCoupling {
    private record Customer(int id, String name) {}

    private record Order(int id, String description, int customerId) {}
  }
}
