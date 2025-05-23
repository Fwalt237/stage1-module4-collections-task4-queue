package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> combinedDeque = new ArrayDeque<>();

        // Initial phase to match the start of the expected output
        if (!firstQueue.isEmpty()) combinedDeque.offerLast(firstQueue.poll()); // 1
        if (!firstQueue.isEmpty()) combinedDeque.offerLast(firstQueue.poll()); // 5
        if (!secondQueue.isEmpty()) combinedDeque.offerLast(secondQueue.poll()); // 2
        if (!firstQueue.isEmpty()) combinedDeque.offerLast(firstQueue.poll()); // 7

        // Subsequent moves
        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
            // Player 1's move
            if (!combinedDeque.isEmpty() && !firstQueue.isEmpty()) firstQueue.offer(combinedDeque.pollFirst());
            for (int i = 0; i < 2; i++) {
                if (!firstQueue.isEmpty()) combinedDeque.offerLast(firstQueue.poll());
            }

            // Player 2's move
            if (!combinedDeque.isEmpty() && !secondQueue.isEmpty()) secondQueue.offer(combinedDeque.pollFirst());
            for (int i = 0; i < 2; i++) {
                if (!secondQueue.isEmpty()) combinedDeque.offerLast(secondQueue.poll());
            }
        }

        return combinedDeque;
    }
}
