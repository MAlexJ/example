package com.malex.lecture_13_collection_api.coordinate_ring;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CoordinateRing {

    private static final int NUM = 4;

    private List<List<Integer>> findMultiRing(List<CoordinatePoint> coordinates) {
        List<List<Integer>> result = new ArrayList<>();
        coordinates.sort(Comparator.comparing(CoordinatePoint::getStart));

        for (int i = 0; i <= NUM; i++) {
            List<Integer> area = findArea(coordinates);
            if (!area.isEmpty()) {
                result.add(area);
            }
        }

        return result;
    }

    private List<Integer> findArea(List<CoordinatePoint> coordinates) {

        coordinates.sort(Comparator.comparing(CoordinatePoint::getStart)); // TODO <<< REMOVE IT <<< FOR TEST ONLY !!!

        List<CoordinatePoint> coordinatePoints = findCoordinates(coordinates);
        List<Integer> result = fillingList(coordinatePoints);

        return noConsecutiveDuplicates(result);
    }

    private List<CoordinatePoint> findCoordinates(List<CoordinatePoint> coordinates) {
        LinkedList<CoordinatePoint> coordinatePoints = new LinkedList<>();
        for (CoordinatePoint point : coordinates) {
            if (coordinatePoints.isEmpty()) {
                if (point.isAddedToList && point.isFull) {
                    point.isAddedToList = false;
                    coordinatePoints.add(point);
                }
            } else {
                if (point.isAddedToList && point.isFull && coordinatePoints.getLast().getEnd().equals(point.getStart())) {
                    point.isAddedToList = false;
                    coordinatePoints.addLast(point);
                } else if (point.isAddedToList && point.isFull && coordinatePoints.getLast().getEnd().equals(point.getEnd())) {
                    point.isAddedToList = false;
                    point.reverseCoordinate();
                    coordinatePoints.addLast(point);
                } else if (point.isAddedToList && point.isFull && coordinatePoints.getFirst().getStart().equals(point.getEnd())) {
                    point.isAddedToList = false;
                    coordinatePoints.addFirst(point);
                } else if (point.isAddedToList && point.isFull && coordinatePoints.getFirst().getStart().equals(point.getStart())) {
                    point.isAddedToList = false;
                    point.reverseCoordinate();
                    coordinatePoints.addFirst(point);
                }
            }
        }
        return coordinatePoints;
    }

    private List<Integer> fillingList(List<CoordinatePoint> coordinatePoints) {
        List<Integer> result = new ArrayList<>();
        for (CoordinatePoint point : coordinatePoints) {
            if (point.getStart() != null) {
                result.add(point.getStart());
            }
            if (point.getEnd() != null) {
                result.add(point.getEnd());
            }
        }
        return result;
    }

    private List<Integer> noConsecutiveDuplicates(List<Integer> input) {
        ArrayList<Integer> newList = new ArrayList<>();
        if (input.isEmpty()) {
            return newList;
        }
        newList.add(input.get(0));
        for (int i = 1; i < input.size(); i++) {
            if (!input.get(i - 1).equals(input.get(i))) {
                newList.add(input.get(i));
            }
        }
        return newList;
    }

    @Test
    public void testList() {
        List<List<Integer>> multiRing = findMultiRing(Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 1, 6),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 4, 5)));
        assertEquals(1, multiRing.size());
        assertEquals(Lists.newArrayList(6, 1, 2, 3, 4, 5), multiRing.get(0));

        multiRing = findMultiRing(Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 1, 6),
                new CoordinatePoint(true, true, 7, 8),
                new CoordinatePoint(true, true, 9, 8),
                new CoordinatePoint(true, true, 9, 10),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 4, 5)));
        assertEquals(2, multiRing.size());
        assertEquals(Lists.newArrayList(6, 1, 2, 3, 4, 5), multiRing.get(0));
        assertEquals(Lists.newArrayList(7, 8, 9, 10), multiRing.get(1));

        multiRing = findMultiRing(Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 1, 6),
                new CoordinatePoint(true, true, 7, 8),
                new CoordinatePoint(true, true, 9, 8),
                new CoordinatePoint(true, true, 9, 10),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 42, 43),
                new CoordinatePoint(true, true, 43, 44),
                new CoordinatePoint(true, true, 45, 44),
                new CoordinatePoint(true, true, 45, null),
                new CoordinatePoint(true, true, 4, 5)));
        assertEquals(3, multiRing.size());
        assertEquals(Lists.newArrayList(6, 1, 2, 3, 4, 5), multiRing.get(0));
        assertEquals(Lists.newArrayList(7, 8, 9, 10), multiRing.get(1));
        assertEquals(Lists.newArrayList(42, 43, 44, 45), multiRing.get(2));


        multiRing = findMultiRing(Lists.newArrayList(
//                new CoordinatePoint(true, true, 43, 52),
                new CoordinatePoint(true, true, 53, 58),
                new CoordinatePoint(true, true, 56, 58),
//                new CoordinatePoint(true, true, 55, 42),
//                new CoordinatePoint(true, true, 52, 39),
//                new CoordinatePoint(true, true, 42, 43),
                new CoordinatePoint(true, true, 50, 56),
                new CoordinatePoint(true, true, 35, 46),
                new CoordinatePoint(true, true, 46, 51),
//                new CoordinatePoint(true, true, 55, 37),
                new CoordinatePoint(true, true, 45, 34),
//                new CoordinatePoint(true, true, 37, 39),
                new CoordinatePoint(true, true, 34, 35),
                new CoordinatePoint(true, true, 50, 51),
                new CoordinatePoint(true, true, 53, 45))
        );
        assertEquals(2, multiRing.size());
        System.out.println();
    }

    @Test
    public void testToEndAndStart() {



        assertPoint(Lists.newArrayList(6, 1, 2, 3, 4, 5), Lists.newArrayList(
                //                new CoordinatePoint(true, true, 43, 52),
//                new CoordinatePoint(true, true, 53, 58),
                new CoordinatePoint(true, true, 56, 58),
//                new CoordinatePoint(true, true, 55, 42),
//                new CoordinatePoint(true, true, 52, 39),
//                new CoordinatePoint(true, true, 42, 43),
                new CoordinatePoint(true, true, 50, 56),
                new CoordinatePoint(true, true, 35, 46),
                new CoordinatePoint(true, true, 46, 51),
//                new CoordinatePoint(true, true, 55, 37),
                new CoordinatePoint(true, true, 45, 34),
//                new CoordinatePoint(true, true, 37, 39),
                new CoordinatePoint(true, true, 34, 35),
                new CoordinatePoint(true, true, 50, 51),
                new CoordinatePoint(true, true, 53, 45))
        );

        assertPoint(Lists.newArrayList(6, 1, 2, 3, 4, 5), Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 1, 6),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 4, 5)));

        assertPoint(Lists.newArrayList(7, 6, 1, 2, 3, 4, 5), Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 6, 1),
                new CoordinatePoint(true, true, 7, 6),
                new CoordinatePoint(true, true, 4, 5)));

        assertPoint(Lists.newArrayList(7, 6, 1, 2, 3, 4, 5), Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 7, 6),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 6, 1),
                new CoordinatePoint(true, true, 4, 5)));
    }

    @Test
    public void testToStart() {
        assertPoint(Lists.newArrayList(6, 5, 4, 3, 2, 1), Lists.newArrayList(
                new CoordinatePoint(true, true, 2, 1),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 4, 3),
                new CoordinatePoint(true, true, 5, 4),
                new CoordinatePoint(true, true, 6, 5)));
        assertPoint(Lists.newArrayList(6, 5, 4, 3, 2, 1), Lists.newArrayList(
                new CoordinatePoint(true, true, 2, 1),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 4, 3),
                new CoordinatePoint(true, true, 4, 5),
                new CoordinatePoint(true, true, 6, 5)));
        assertPoint(Lists.newArrayList(6, 5, 4, 3, 2, 1), Lists.newArrayList(
                new CoordinatePoint(true, true, 2, 1),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 4, 5),
                new CoordinatePoint(true, true, 6, 5)));
        assertPoint(Lists.newArrayList(6, 5, 4, 3, 2, 1), Lists.newArrayList(
                new CoordinatePoint(true, true, 2, 1),
                new CoordinatePoint(true, true, 2, 3),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 4, 5),
                new CoordinatePoint(true, true, 5, 6)));
    }

    @Test
    public void testToEnd() {
        assertPoint(Lists.newArrayList(1, 2, 3, 4, 5, 6), Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 2, 3),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 4, 5),
                new CoordinatePoint(true, true, 5, 6)));
        assertPoint(Lists.newArrayList(1, 2, 3, 4, 5, 6), Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 4, 5),
                new CoordinatePoint(true, true, 5, 6)));
        assertPoint(Lists.newArrayList(1, 2, 3, 4, 5, 6), Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 5, 4),
                new CoordinatePoint(true, true, 5, 6)));
        assertPoint(Lists.newArrayList(1, 2, 3, 4, 5, 6), Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 5, 4),
                new CoordinatePoint(true, true, 6, 5)));

        assertPoint(Lists.newArrayList(1, 2, 3, 4, 5, 6), Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 5, 4),
                new CoordinatePoint(true, true, 6, 5),
                new CoordinatePoint(true, false, 6, -1)));

        assertPoint(Lists.newArrayList(1, 2, 3, 4, 5, 6), Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 5, 4),
                new CoordinatePoint(true, true, 6, 5),
                new CoordinatePoint(true, false, 1, -1)));

        assertPoint(Lists.newArrayList(1, 2, 3, 4, 5, 6), Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 5, 4),
                new CoordinatePoint(true, true, 6, 5),
                new CoordinatePoint(true, false, 3, -1),
                new CoordinatePoint(true, false, 6, -1),
                new CoordinatePoint(true, false, 1, -1)));

        assertPoint(Lists.newArrayList(1, 2, 3, 4, 5, 6), Lists.newArrayList(
                new CoordinatePoint(true, true, 1, 2),
                new CoordinatePoint(true, true, 3, 2),
                new CoordinatePoint(true, true, 3, 4),
                new CoordinatePoint(true, true, 5, 4),
                new CoordinatePoint(true, true, 6, 5),
                new CoordinatePoint(true, false, 3, -1),
                new CoordinatePoint(true, false, 6, -1),
                new CoordinatePoint(true, false, 1, -1)));
    }

    private void assertPoint(List<Integer> expectedList, List<CoordinatePoint> points) {
        assertEquals(expectedList, findArea(points));
    }

    @Test
    public void testReverseCoordinate() {
        CoordinatePoint cp = new CoordinatePoint(true, true, 1, 2);
        assertEquals(new CoordinatePoint(true, true, 1, 2), cp);

        cp.reverseCoordinate();
        assertEquals(new CoordinatePoint(true, true, 2, 1), cp);

        cp.reverseCoordinate();
        assertEquals(new CoordinatePoint(true, true, 1, 2), cp);

        cp = new CoordinatePoint(true, true, 0, 1234);
        assertEquals(new CoordinatePoint(true, true, 0, 1234), cp);

        cp.reverseCoordinate();
        assertEquals(new CoordinatePoint(true, true, 1234, 0), cp);

        cp = new CoordinatePoint(false, false, -123, 0);
        assertEquals(new CoordinatePoint(false, false, -123, 0), cp);

        cp.reverseCoordinate();
        assertEquals(new CoordinatePoint(false, false, 0, -123), cp);
    }

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode
    private static class CoordinatePoint {
        private boolean isAddedToList;
        private boolean isFull;
        private Integer start;
        private Integer end;

        void reverseCoordinate() {
            Integer temp = this.start;
            this.start = this.end;
            this.end = temp;
        }
    }
}
