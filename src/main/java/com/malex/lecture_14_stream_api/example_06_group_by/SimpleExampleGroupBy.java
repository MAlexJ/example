package com.malex.lecture_14_stream_api.example_06_group_by;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.malex.lecture_14_stream_api.example_06_group_by.SimpleExampleGroupBy.Position.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class SimpleExampleGroupBy {

    /**
     * Test: groupingBy(Function<? super T, ? extends K> classifier)
     */
    @Test
    public void groupWorkersByPosition() {
        // when:
        Map<Position, List<Worker>> workers = initWorkers().stream()
                .collect(Collectors.groupingBy(Worker::getPosition));

        // then:
        assertEquals(workers.keySet().size(), 4);
        assertEquals(workers.get(CAT).size(), 1);
        assertNull(workers.get(DOG));
    }


    /**
     * groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)
     */
    @Test
    public void groupWorkersByPositionUseSet() {
        // when:
        Map<Position, Set<Worker>> workers = initWorkers().stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toSet()));

        // then:
        assertEquals(workers.keySet().size(), 4);
        assertEquals(workers.get(CAT).size(), 1);
        assertNull(workers.get(DOG));
    }

    /**
     * Group workers by position and cont of worker that have this position
     * aggregation function: counting
     * <p>
     * groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)
     */
    @Test
    public void groupWorkersByPositionAndContWorkerThatHavePosition() {
        // when:
        Map<Position, Long> workers = initWorkers().stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));

        // then:
        assertEquals(workers.get(DEVELOPER).longValue(), 2);
        assertEquals(workers.get(MANAGER).longValue(), 1);
    }

    /**
     * Apply to group by:
     * mapping(Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream)
     */
    @Test
    public void groupWorkersByPositionAndWorkerNames() {
        // when:
        Map<Position, List<String>> workers = initWorkers().stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.mapping(Worker::getName, Collectors.toList())));

        // then:
        assertEquals(workers.get(DEVELOPER), Lists.newArrayList("Alex", "Vlad"));
    }


    @Test
    public void groupByPositionAndAverageSalary() {
        // when:
        Map<Position, Double> workers = initWorkers().stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
//   # case 2:c         Collectors.averagingDouble(worker -> Integer.valueOf(worker.getSalary()).doubleValue())));
                        Collectors.averagingDouble(w -> (double) w.getSalary())));

        // then
        assertEquals(workers.get(DEVELOPER), 1050.00, 0.001);
    }

    @Getter
    @Setter
    @Builder
    static class Worker {
        private String name;
        private int age;
        private int salary;
        private Position position;

        public Worker(String name, int age, int salary, Position position) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.position = position;
        }
    }

    enum Position {
        DEVELOPER, QA, MANAGER, CAT, DOG
    }

    public List<Worker> initWorkers() {
        return Lists.newArrayList(
                Worker.builder()
                        .name("Alex")
                        .age(21)
                        .salary(1000)
                        .position(DEVELOPER)
                        .build(),
                Worker.builder()
                        .name("Vlad")
                        .age(28)
                        .salary(1100)
                        .position(DEVELOPER)
                        .build(),
                Worker.builder()
                        .name("Anna")
                        .age(20)
                        .salary(900)
                        .position(QA)
                        .build(),
                Worker.builder()
                        .name("Dog")
                        .age(7)
                        .salary(100)
                        .position(QA)
                        .build(),
                Worker.builder()
                        .name("Max")
                        .age(25)
                        .salary(300)
                        .position(MANAGER)
                        .build(),
                Worker.builder()
                        .name("Stefan")
                        .age(5)
                        .salary(10)
                        .position(CAT)
                        .build()
        );
    }
}
