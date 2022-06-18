package com.akm.intready.heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargestElement(int[] nos, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int n : nos) {
            if (minHeap.size() == k) {
                minHeap.add(n);
                minHeap.remove();
            } else {
                minHeap.add(n);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 8, 9, 1, 7};
        KthLargestElementInAnArray findSolution = new KthLargestElementInAnArray();
        int n=findSolution.findKthLargestElement(arr, 4);
        System.out.println("kth largest element is : " + n);
    }
}
