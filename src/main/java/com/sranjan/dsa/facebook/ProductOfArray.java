package com.sranjan.dsa.facebook;

import java.util.Arrays;

public class ProductOfArray {

	public static void main(String[] args) {
		int[] nums = {1,0,-2,-3};
		int[] answer = new ProductOfArray().productExceptSelf(nums);
		for(int n : answer) {
			System.out.println(n);
		}

	}
	
    public int[] productExceptSelf(int[] nums) {
    	int[] answer = new int[nums.length];
    	Arrays.fill(answer, 1);
    	int left = 1;
    	for(int i=1;i<nums.length;i++) {
    		left *= nums[i-1];
    		answer[i] = left;
    	}
    	
    	int right = 1;
    	for(int i=nums.length - 2;i >= 0;i--) {
    		right *= nums[i+1];
    		answer[i] *= right;
    	}
    	return answer;
    }
}
