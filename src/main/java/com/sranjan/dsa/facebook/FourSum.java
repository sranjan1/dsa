package com.sranjan.dsa.facebook;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FourSum {

	public static void main(String... args) {
		FourSum obj = new FourSum();
		int nums[] = {1,0,-1,0,-2,2};
		int target = 0;
		List<List<Integer>> result = obj.fourSum(nums, target);
		System.out.println(result);
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		if(nums == null || nums.length < 4) {
			return Collections.emptyList();
		}
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0;i< nums.length - 3;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1;j< nums.length - 2;j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int twoSumTarget = target - nums[i] - nums[j];
                //The following 3 lines of code to calculate the min and max of twoSum
                int minTwoSum = nums[j+1] + nums[j+2];
                int maxTwoSum = nums[nums.length - 1] + nums[nums.length - 2];
                if(twoSumTarget < minTwoSum || twoSumTarget > maxTwoSum) continue;
                for(int m = j+1,n= nums.length-1;m < n;){
                    int twoSum = nums[m] + nums[n];
                    if(twoSum < twoSumTarget){
                        while(m < n && nums[m] == nums[m+1]) m++;
                        m++;
                    }else if(twoSum > twoSumTarget){
                        while(m < n && nums[n] == nums[n-1]) n--;
                        n--;
                    }else{
                        List<Integer> tempList = new LinkedList<>(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        list.add(tempList);
                        while(m < n && nums[m] == nums[m+1]) m++;
                        m++;
                        while(m < n && nums[n] == nums[n-1]) n--;
                        n--;
                    }
                }
            }
        }
        return list;
        
	}
}
	
	
	
