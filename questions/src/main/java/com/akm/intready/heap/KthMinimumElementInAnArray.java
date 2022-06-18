package com.akm.intready.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthMinimumElementInAnArray {

    public int findKthMinimumElement(int[] nos, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int n : nos) {
            if (maxHeap.size() == k) {
                maxHeap.add(n);
                maxHeap.remove();
            } else {
                maxHeap.add(n);
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 8, 9, 1, 7};
        KthMinimumElementInAnArray findSolution = new KthMinimumElementInAnArray();
        int n = findSolution.findKthMinimumElement(arr, 2);
        System.out.println("kth Minimum element is : " + n);
    }
}
