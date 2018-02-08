package triangle_strip;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import remove_consecutive_duplicates.RemoveConsecutiveDuplicates;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TriangleStrip {

    private static final int NUM = 10;

    public static void main(String[] args) {

        ArrayList<Integer> positionVertexList =
                Lists.newArrayList(16, 5, 17, 8, 8, 1, 1, 18, 3, 19, 19, 7, 7, 20, 1, 18, 18, 20, 20, 7, 16, 5, 5, 11, 11, 21, 8, 17, 17, 21, 21, 11, 19, 3, 3, 3);
        List<Integer> positionVertexBottom = Lists.newArrayList(16, 17, 18, 19, 20, 21);

        //*********************** CASE :1 ********************************

        List<TriangleVertex> triangleList = new ArrayList<>();
        for (int position = 0; position < positionVertexList.size(); position++) {
            if (position < positionVertexList.size() - 2) {
                int p1 = positionVertexList.get(position);
                int p2 = positionVertexList.get(position + 1);
                int p3 = positionVertexList.get(position + 2);
                if (p1 != p2 && p2 != p3 && p1 != p3)
                    triangleList.add(new TriangleVertex(false, p1, p2, p3));
            }
        }

        LinkedList<TriangleVertex> triangleStripping = new LinkedList<>();
        TriangleVertex triangleVertex = triangleList.get(0);
        triangleVertex.isAddedToList = true;
        triangleStripping.add(triangleVertex);

        for (int i = 0; i < NUM; i++) {
            for (TriangleVertex triangle : triangleList) {
                TriangleVertex triangleLast = triangleStripping.getLast();
                if (!triangle.isAddedToList && triangleLast.isIntersect(triangle)) {
                    triangle.isAddedToList = true;
                    triangleStripping.addLast(triangle);
                }
            }
        }

        for (int i = 0; i < NUM; i++) {
            for (TriangleVertex triangle : triangleList) {
                TriangleVertex triangleLast = triangleStripping.getFirst();
                if (!triangle.isAddedToList && triangleLast.isIntersect(triangle)) {
                    triangle.isAddedToList = true;
                    triangleStripping.addFirst(triangle);
                }
            }
        }

        System.out.println(triangleStripping);


        // ************************ CASE : 2 ***************************************

        List<Integer> realPositionBottom = new ArrayList<>();
        for (TriangleVertex triangleV : triangleStripping) {
            if (positionVertexBottom.contains(triangleV.p1)) {
                realPositionBottom.add(triangleV.p1);
            } else if (positionVertexBottom.contains(triangleV.p2)) {
                realPositionBottom.add(triangleV.p2);
            } else if (positionVertexBottom.contains(triangleV.p3)) {
                realPositionBottom.add(triangleV.p3);
            }
        }

        System.out.println(realPositionBottom);
        realPositionBottom = RemoveConsecutiveDuplicates.noConsecutiveDuplicates(realPositionBottom);
        System.out.println(realPositionBottom);
    }

    @Getter
    @AllArgsConstructor
    private static class TriangleVertex {
        private boolean isAddedToList;
        private int p1;
        private int p2;
        private int p3;

        boolean isIntersect(TriangleVertex triangle) {
            if (Sets.difference(Sets.newHashSet(p1, p2, p3), Sets.newHashSet(triangle.p1, triangle.p2, triangle.p3)).size() == 1) {
                int temp;
                if (this.p2 == triangle.p3) {
                    temp = triangle.p3;
                    triangle.p3 = triangle.p1;
                    triangle.p1 = temp;
                }
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "[p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
        }
    }
}
