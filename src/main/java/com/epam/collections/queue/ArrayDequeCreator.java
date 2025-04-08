package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> combinedDeque = new ArrayDeque<>();

        if (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
            combinedDeque.offerLast(firstQueue.poll());
        }
        if (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
            combinedDeque.offerLast(firstQueue.poll());
        }
        if (!secondQueue.isEmpty() && !firstQueue.isEmpty()) {
            combinedDeque.offerLast(secondQueue.poll());
        }
        if (!secondQueue.isEmpty() && !firstQueue.isEmpty()) {
            combinedDeque.offerLast(secondQueue.poll());
        }

        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
            verifyEmpty(firstQueue, combinedDeque);
            verifyEmpty(secondQueue, combinedDeque);
        }
        return combinedDeque;
    }

    private void verifyEmpty(Queue<Integer> secondQueue, ArrayDeque<Integer> combinedDeque) {
        if (!combinedDeque.isEmpty() && !secondQueue.isEmpty()) {
            secondQueue.offer(combinedDeque.pollFirst());
        }
        if (!secondQueue.isEmpty()) {
            combinedDeque.offerLast(secondQueue.poll());
        }
        if (!secondQueue.isEmpty()) {
            combinedDeque.offerLast(secondQueue.poll());
        }
    }
}
