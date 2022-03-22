package com.sranjan.dsa.math;

public class SameNumberFinder {

	public static void main(String[] args) {
		int[] nums = {1,2,1,2,4};
		int bitAnswer = singleNumberUsingBitOperations(nums);
		System.out.println("BitWise Answer is "+bitAnswer);
		int bruteForceAnswer = singleNumberUsingBruteForce(nums);
		System.out.println("Brute Force answer is "+bruteForceAnswer);
	}
	
    public static int singleNumberUsingBruteForce(int[] nums) {
        for(int i=0; i<nums.length; i++){
             for(int j=i+1; j<nums.length; j++) {
            	 if(nums[j] == nums[i]) {
            		 break;
            	 }
             }
             return i;
        }
        throw new IllegalArgumentException("No solution possible");
    }

    public static int singleNumberUsingBitOperations(int[] nums) {
        int result = 0;
        for(int i=0; i<nums.length; i++){
                result^= nums[i];
        }
        return result;
    }
	
	public static int applyXor(int x, int y) {
		return x^y;
	}
	
}
