package com.malex.lecture_15_Thread.example_14_thread;

import java.util.ArrayList;
import java.util.List;

import com.malex.utils.AbstractUtils;

public abstract class AbstractProgram extends AbstractUtils {

  protected List<Integer> firstList = List.of(1, 2, 3, 4, 5, 6, 7);
  protected List<Integer> secondList = List.of(12, 32, 53, 75, 34, 67);

  protected List<Integer> result = new ArrayList<>();
}
