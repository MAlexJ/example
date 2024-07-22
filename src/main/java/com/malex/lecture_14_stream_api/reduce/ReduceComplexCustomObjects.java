package com.malex.lecture_14_stream_api.reduce;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.junit.Test;

public class ReduceComplexCustomObjects extends AbstractUtils {

  @Test
  public void test() {
    User john = new User("John", 30);


  }
}

record User(String name, int age, Rating rating) {
  public User(String name, int age) {
    this(name, age, new Rating());
  }
}

/* Review */
record Review(int points, String review) {}

/* Rating */
class Rating {

  @Getter private double average;
  private final List<Review> reviews;

  public Rating() {
    this.reviews = new ArrayList<>();
  }

  void addReview(Review review) {
    reviews.add(review);
    average = calculateAverage();
  }

  private double calculateAverage() {
    Integer total = reviews.stream().map(Review::points).reduce(0, Integer::sum);
    return total / reviews.size();
  }
}
