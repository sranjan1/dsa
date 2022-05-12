package com.sranjan.dsa.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4,-2,44444, 556,-8,-6};
        int k = 2;
        System.out.println("Kth Largest element in the array using sorting is : "+new KthLargestElement().findKthLargest(nums, k));
        System.out.println("Kth Largest element in the array using MaxHeap is : "+new KthLargestElement().findKthLargesUsingMaxHeap(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargesUsingMaxHeap(int[] nums, int k) {
        PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k + 1);
        for(int num : nums) {
            largeK.add(num);
            if (largeK.size() > k) {
                largeK.poll();
            }
        }

        return largeK.poll();
    }
}
