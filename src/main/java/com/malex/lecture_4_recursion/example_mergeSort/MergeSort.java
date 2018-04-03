package com.malex.lecture_4_recursion.example_mergeSort;

public class MergeSort {

    public static void main(String[] args) {

        // #1 init
        DArray arr = new DArray(100);
        arr.insert(64);
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(108);
        arr.insert(36);

        // #2 display items
        arr.display();

        // #3 merge sort the array
        arr.mergeSort();

        // #4 display items again
        arr.display();
    }

    private static class DArray {
        // ref to array theArray
        private long[] theArray;
        // number of data items
        private int nElements;

        DArray(int max) {
            theArray = new long[max];
            nElements = 0;
        }

        /**
         * put element into array
         */
        public void insert(long value) {
            theArray[nElements] = value;
            nElements++;
        }

        /**
         * displays array contents
         */
        private void display() {
            for (int j = 0; j < nElements; j++)
                System.out.print(theArray[j] + " ");
            System.out.println("");
        }

        //-----------------------------------------------------------
        private void mergeSort() {
            long[] workSpace = new long[nElements];
            recMergeSort(workSpace, 0, nElements - 1);
        }

        //-----------------------------------------------------------
        private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
            if (lowerBound == upperBound)            // if range is 1,
                return;                              // no use sorting
            else {                                    // find midpoint
                int mid = (lowerBound + upperBound) / 2;
                // sort low half
                recMergeSort(workSpace, lowerBound, mid);
                // sort high half
                recMergeSort(workSpace, mid + 1, upperBound);
                // merge them
                merge(workSpace, lowerBound, mid + 1, upperBound);
            }  // end else
        }  // end recMergeSort()

        //-----------------------------------------------------------
        private void merge(long[] workSpace, int lowPtr,
                           int highPtr, int upperBound) {
            int j = 0;                             // workspace index
            int lowerBound = lowPtr;
            int mid = highPtr - 1;
            int n = upperBound - lowerBound + 1;       // # of items

            while (lowPtr <= mid && highPtr <= upperBound)
                if (theArray[lowPtr] < theArray[highPtr])
                    workSpace[j++] = theArray[lowPtr++];
                else
                    workSpace[j++] = theArray[highPtr++];

            while (lowPtr <= mid)
                workSpace[j++] = theArray[lowPtr++];

            while (highPtr <= upperBound)
                workSpace[j++] = theArray[highPtr++];

            for (j = 0; j < n; j++)
                theArray[lowerBound + j] = workSpace[j];
        }
    }
}
