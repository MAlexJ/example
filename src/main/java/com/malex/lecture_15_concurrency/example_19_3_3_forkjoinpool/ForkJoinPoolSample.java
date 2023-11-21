package com.malex.lecture_15_concurrency.example_19_3_3_forkjoinpool;

import com.malex.lecture_15_concurrency.AbstractThreadSample;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * Tutorial - https://www.youtube.com/watch?v=c2n-mjlLqrs&list=PLQ9NkV1-BDZ_WNhVqR_2uqfvt1dXy7Cgx&index=163
 */
public class ForkJoinPoolSample extends AbstractThreadSample {

    public static void main(String[] args) {
        javaStatistic();
        int[] ints = listWithRandomNumbers(1000000000);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        RecursiveTask<Integer> mainNode = new FindMax(0, ints.length, ints);
        Integer maxElement = forkJoinPool.invoke(mainNode);
        print("max element :", maxElement);
        javaStatistic();

        print("verification max element :", testFindMaxElement(ints));
        javaStatistic();
    }

    static class FindMax extends RecursiveTask<Integer> {
        int left;
        int right;
        int[] list;

        FindMax(int left, int right, int[] list) {
            this.left = left;
            this.right = right;
            this.list = list;
        }

        @Override
        protected Integer compute() {
            if (right - left < 1000) {
                int result = list[left];
                for (int i = left; i < right; i++) {
                    result = Math.max(result, list[i]);
                }
                return result;
            } else {
                int mid = (left + right) / 2;
                RecursiveTask<Integer> leftNode = new FindMax(left, mid, list);
                RecursiveTask<Integer> rightNode = new FindMax(mid, right, list);
                leftNode.fork();
                rightNode.fork();
                return Math.max(leftNode.join(), rightNode.join());
            }
        }
    }

    private static int[] listWithRandomNumbers(int arraySize) {
        Random random = new Random();
        int origin = random.nextInt(0, 100);
        int bound = random.nextInt(origin, 10000000);
        return IntStream.range(0, arraySize) //
                .map(i -> (int) (Math.random() * random.nextInt(origin, bound))) //
                .toArray();
    }


    private static int testFindMaxElement(int[] array) {
        return Arrays.stream(array) //
                .boxed() //
                .max(Integer::compareTo) //
                .orElseThrow(() -> new IllegalArgumentException("Can't find max element!"));
    }
}