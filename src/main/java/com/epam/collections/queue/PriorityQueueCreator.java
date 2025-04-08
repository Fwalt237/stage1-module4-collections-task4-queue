package com.epam.collections.queue;


import java.util.*;


public class PriorityQueueCreator {
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {
        PriorityQueue<String> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(firstList);
        queue.addAll(secondList);
        return queue;
    }
}





