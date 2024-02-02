package com.malex.lecture_18_programming_idiom.covariance_contravariance_and_invariance;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.Test;

/**
 * Topic: Covariance, Invariance and Contravariance
 *
 * <p>link: https://www.youtube.com/watch?v=2yeFSrcTQh8 *
 *
 * <p>link:https://stackoverflow.com/questions/8481301/covariance-invariance-and-contravariance-explained-in-plain-english
 *
 * <p>That is, if A and B are types, f is a type transformation, and ≤ the subtype relation(i.e. A ≤
 * B means that A is a subtype of B), we have
 *
 * <p>1. f is covariant if A ≤ B implies that f(A) ≤ f(B)
 *
 * <p>2. f is contravariant if A ≤ B implies that f(B) ≤ f(A)
 *
 * <p>3. f is invariant if neither of the above holds
 */
public class CovarianceContravarianceInvarianceApp extends AbstractUtils {

  /** Hierarchy: Fruit <- Citrus <- Orange <- BigRoundOrange */
  @Test
  public void general() {}

  /**
   * An IS-A relationship is inheritance. The classes which inherit are known as sub classes or
   * child classes. On the other hand, HAS-A relationship is composition.
   *
   * <p>In OOP, IS-A relationship is completely inheritance. This means, that the child class is a
   * type of parent class. For example, an orange is a fruit. So you will extend fruit to get orange
   *
   * <p>Hierarchy: Fruit <- Citrus <- Orange <- BigRoundOrange
   */
  @Test
  public void invarianceIsaRelationship() {
    Fruit fruit = new Fruit();
    Citrus citrus = new Citrus();
    Orange orange = new Orange();
    BigRoundOrange bigRoundOrange = new BigRoundOrange();

    fruit = citrus;
    fruit = orange;
    fruit = bigRoundOrange;

    // wrong!
    //    bigRoundOrange = orange;
    //    citrus = fruit

    // it's Invariance
    List<Fruit> fruitList = new ArrayList<>();
    List<Orange> orangeList = List.of(new Orange());

    // wrong!
    //    fruitList = citrusList;

    Orange newOrange = orangeList.getFirst();
    Citrus newCitrus = orangeList.getFirst();
    Fruit newFruit = orangeList.getFirst();

    print("Is a Fruit:", newFruit instanceof Fruit);
    print("Is a Citrus:", newFruit instanceof Citrus);
    print("Is a Orange:", newFruit instanceof Orange);
  }

  @Test
  public void covariant() {
    var orangeList = List.of(new Orange(1), new Orange(2), new Orange(3));
    assertEquals(6, totalWeight(orangeList));

    var citrusList = List.of(new Citrus(1), new Citrus(2), new Citrus(3));
    assertEquals(6, totalWeight(citrusList));

    var bigRoundOrangeList =
        List.of(new BigRoundOrange(1), new BigRoundOrange(2), new BigRoundOrange(3));
    assertEquals(6, totalWeight(bigRoundOrangeList));
  }

  public int totalWeight(List<? extends Citrus> list) {
    return list.stream().mapToInt(Fruit::getWeight).sum();
  }

  @Test
  public void contravariant() {
    List<Citrus> citruses = new ArrayList<>();
    addNew(citruses);
    print(citruses.size());

    List<Orange> oranges = new ArrayList<>();
    addNew(oranges);
    print(oranges.size());
  }

  private void addNew(List<? super Orange> citruses) {
    // Hierarchy: Fruit <- Citrus <- Orange <- BigRoundOrange
    //  wrong:  citruses.add(new Fruit(1));
    //  wrong:  citruses.add(new Citrus(1));
    citruses.add(new Orange(1));
    citruses.add(new BigRoundOrange(2));
  }

  @Getter
  @Setter
  @NoArgsConstructor
  static class Fruit {
    private int weight;

    public Fruit(int weight) {
      this.weight = weight;
    }
  }

  @Getter
  @NoArgsConstructor
  static class Citrus extends Fruit {

    public Citrus(int weight) {
      this.setWeight(weight);
    }
  }

  @Getter
  @NoArgsConstructor
  static class Orange extends Citrus {
    int color;

    public Orange(int weight) {
      this.setWeight(weight);
    }
  }

  @Getter
  @NoArgsConstructor
  static class BigRoundOrange extends Orange {

    public BigRoundOrange(int weight) {
      this.setWeight(weight);
    }
  }
}
