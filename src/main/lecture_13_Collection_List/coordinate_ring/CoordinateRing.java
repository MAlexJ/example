package coordinate_ring;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.junit.Test;
import remove_consecutive_duplicates.RemoveConsecutiveDuplicates;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CoordinateRing {

    private static final int NUM = 3;

    private List<List<Integer>> findMultiRing(List<CoordinatePoint> coordinates) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= NUM; i++) {
            result.add(findArea(coordinates));
            if (coordinates.stream().noneMatch(coordinatePoint -> coordinatePoint.isAddedToList)) {
                return result;
            }
        }
        return result;
    }

    private List<Integer> findArea(List<CoordinatePoint> coordinates) {

        if (coordinates.isEmpty())
            return new ArrayList<>();

        coordinates.sort(Comparator.comparing(CoordinatePoint::getStart));
        List<CoordinatePoint> coordinatePoints = findCoordinates(coordinates);

        return RemoveConsecutiveDuplicates.noConsecutiveDuplicates(fillingList(coordinatePoints));
    }

    private List<CoordinatePoint> findCoordinates(List<CoordinatePoint> coordinates) {

        LinkedList<CoordinatePoint> coordinatePoints = new LinkedList<>();

        CoordinatePoint startPoint = coordinates.get(0);
        startPoint.isAddedToList = false;
        coordinatePoints.add(startPoint);

        for (CoordinatePoint point : coordinates) {
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

        return coordinatePoints;
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

    }

    @Test
    public void testToEndAndStart() {

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
