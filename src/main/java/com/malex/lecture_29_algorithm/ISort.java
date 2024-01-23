package com.malex.lecture_29_algorithm;

public interface ISort {

  void swapElement(int[] array, int startIndex, int endIndex);

  int indexLowest(int[] array, int startIndex);

  int[] selectionSort(int[] array);
}
