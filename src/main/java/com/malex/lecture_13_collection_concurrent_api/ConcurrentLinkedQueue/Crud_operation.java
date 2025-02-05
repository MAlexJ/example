package com.malex.lecture_13_collection_concurrent_api.ConcurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.Test;

/*
* An unbounded thread-safe queue based on linked nodes.
* This queue orders elements FIFO (first-in-first-out).
* The head of the queue is that element that has been on the queue the longest time.
* The tail of the queue is that element that has been on the queue the shortest time.
*
* New elements are inserted at the tail of the queue, and the queue retrieval operations obtain elements
* at the head of the queue.
*
* A ConcurrentLinkedQueue is an appropriate choice when many threads will share access to a common collection.
* Like most other concurrent collection implementations, this class does not permit the use of null elements.
*  This implementation employs an efficient non-blocking algorithm based on one described in Simple, Fast,
* and Practical Non-Blocking and Blocking Concurrent Queue Algorithms by Maged M. Michael and Michael L. Scott.
 */
public class Crud_operation {

    @Test
    public void run(){
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();


    }
}
