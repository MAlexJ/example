package com.malex.lecture_18_programming_idiom.loose_coupling_and_high_cohesion.coupling;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * Loose coupling
 *
 * <p>Note: Coupling is the degree of interdependence between software modules. A module could be a
 * class or a package or even a microservice. Effectively, the coupling is about how changing one
 * thing required change in another.
 *
 * <p>In simple words, loose coupling means they are mostly independent. If the only knowledge that
 * class A has about class B, is what class B has exposed through its interface, then class A and
 * class B are said to be loosely coupled.
 *
 * <p>In order to over come from the problems of tight coupling between objects, spring framework
 * uses dependency injection mechanism with the help of POJO/POJI model and through dependency
 * injection its possible to achieve loose coupling.
 *
 * <p>Example : If you change your shirt, then you are not forced to change your body – when you can
 * do that, then you have loose coupling. When you can’t do that, then you have tight coupling. The
 * examples of Loose coupling are Interface, JMS.
 */
public class LooseCoupling extends AbstractUtils {

  @Test
  public void test() {
    var myFirstTopic = new Topic("");
    var subject = new Subject(myFirstTopic);
    subject.startReading();
  }

  private interface ISubject {}

  private interface ITopic {
    void understand();
  }

  private record Topic(String message) implements ITopic {
    @Override
    public void understand() {
      printlnString(message);
    }
  }

  private record Subject(ITopic topic) implements ISubject {
    public void startReading() {
      topic.understand();
    }
  }
}
