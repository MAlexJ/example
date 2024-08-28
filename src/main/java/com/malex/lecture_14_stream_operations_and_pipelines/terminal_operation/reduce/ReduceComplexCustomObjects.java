package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.reduce;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import lombok.Getter;
import org.junit.Test;

/*
 * Task:
 * Suppose our User is part of a review website.
 * Each of our Users can possess one Rating, which is
 * averaged over many Reviews.
 *
 * <p>link: https://www.baeldung.com/java-stream-reduce
 */
public class ReduceComplexCustomObjects extends AbstractUtils {

  private final Review goodReview = new Review(5, "God");
  private final Review badReview = new Review(1, "Bad");
  private final Review notBadReview = new Review(3, "Not Bad");

  @Test
  public void test() {
    var rating = new Rating(List.of(goodReview, badReview)); // 5 and 1
    var john = new User("John", 30, rating);
    println("john, average rating - ", john.getAverage());

    var alex = new User("Alex", 12);
    alex.addReview(badReview); // 1
    alex.addReview(notBadReview); // 3
    println("alex, average rating - ", alex.getAverage());

    var max = new User("Max", 22);
    max.addReview(notBadReview); // 3
    println("max, average rating - ", max.getAverage());

    Rating averageAllUserRating =
        Stream.of(alex, max, john)
            .reduce(
                new Rating(),
                (accumulator, user) -> RatingUtils.average(accumulator, user.rating()),
                RatingUtils::average);

    println("averageAllUserRating - ", averageAllUserRating.getAverage());
    assertThat(averageAllUserRating.getAverage()).isEqualTo(2.6);
  }
}

record User(String name, int age, Rating rating) {
  public User(String name, int age) {
    this(name, age, new Rating());
  }

  void addReview(Review review) {
    this.rating.addReview(review);
  }

  double getAverage() {
    return this.rating.getAverage();
  }
}

/* Rating */
@Getter
class Rating {

  private double average;
  private final List<Review> reviews;

  public Rating() {
    this.reviews = new ArrayList<>();
  }

  public Rating(List<Review> review) {
    this.reviews = review;
    this.average = RatingUtils.calculateAverage(this.reviews);
  }

  void addReview(Review review) {
    this.reviews.add(review);
    this.average = RatingUtils.calculateAverage(this.reviews);
  }

  void addReviews(List<Review> reviews) {
    this.reviews.addAll(reviews);
    this.average = RatingUtils.calculateAverage(this.reviews);
  }
}

class RatingUtils {

  private RatingUtils() {}

  static double calculateAverage(List<Review> reviews) {
    int total = reviews.stream().map(Review::points).reduce(0, Integer::sum);
    return (total == 0) ? 0 : (double) total / reviews.size();
  }

  static Rating average(Rating r1, Rating r2) {
    var reviews = Stream.of(r1.getReviews(), r2.getReviews()).flatMap(Collection::stream).toList();
    return new Rating(reviews);
  }
}

/* Review */
record Review(int points, String review) {}
