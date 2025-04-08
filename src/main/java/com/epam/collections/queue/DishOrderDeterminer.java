package com.epam.collections.queue;

import java.util.*;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            queue.offer(i);
        }
        List<Integer> dishOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int k =1;
            while(k < everyDishNumberToEat) {
                if(!queue.isEmpty()) {
                    queue.offer(queue.poll());
                    k++;
                } else{
                    break;
                }
            }
            dishOrder.add(queue.poll());
        }
        return dishOrder;
    }
}

