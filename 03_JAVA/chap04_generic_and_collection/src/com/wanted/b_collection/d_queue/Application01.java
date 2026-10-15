package com.wanted.b_collection.d_queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Application01 {
    public static void main(String[] args) {

        Queue queue = new PriorityQueue();

        queue.offer(30);
        queue.offer(10);
        queue.offer(20);
        queue.offer(5);
        queue.offer(27);

        System.out.println(queue);


    }
}
