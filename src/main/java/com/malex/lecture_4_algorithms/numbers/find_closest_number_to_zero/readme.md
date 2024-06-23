### Find the Closest Number to Zero in a Java Array

* link: https://www.baeldung.com/java-array-find-nearest-zero

#### 1. The Brute Force Approach

This method involves a straightforward iteration through the array, calculating the absolute difference between each
element and zero, and keeping track of the minimum difference encountered so far.  <br>
If two numbers have the same absolute difference from zero, the method prioritizes the positive number to ensure a
consistent and predictable result.

```java
 private int findClosestNumberToZero(int[] array) {
    int first = array[0];
    for (int i = 1; i < array.length; i++) {
        if (Math.abs(array[i]) < Math.abs(first)) {
            first = array[i];
        }
    }
    return first;
}
```

#### 2. Approach Using Sorting and Binary Search

This approach begins by sorting the array, simplifying the problem by arranging elements in ascending order of their
absolute values. After sorting, a binary search algorithm is applied to efficiently locate the element closest to zero.

```java
```

#### 3. Approach Using Priority Queue

An alternative technique involves utilizing a priority queue to efficiently find the closest number to zero without
sorting the entire array. It finds the closest number to zero by adding each number to the queue and keeping only the
smallest number based on its absolute value.

```java


```