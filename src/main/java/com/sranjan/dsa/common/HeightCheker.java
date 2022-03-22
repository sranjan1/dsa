package com.sranjan.dsa.common;

/**
 * 
 * Input: heights = [1,1,4,2,1,3]
   Output: 3
   Explanation: 
   Current array : [1,1,4,2,1,3]
   Target array  : [1,1,1,2,3,4]
   On index 2 (0-based) we have 4 vs 1 so we have to move this student.  
   On index 4 (0-based) we have 1 vs 3 so we have to move this student.
   On index 5 (0-based) we have 3 vs 4 so we have to move this student.
 * 
 * 
 * 
 * @author sumit
 *
 */
public class HeightCheker {

	public static void main(String[] args) {
		int[] heights = {1,1,4,2,1,3};
		new HeightCheker().heightChecker(heights);
		for (int height: heights) {
			System.out.println(height);
		}
	}

	public int heightChecker(int[] heights) {
    	int anchor = 0;
    	for(int explorer=0; explorer< heights.length; explorer++) {
    		if(heights[explorer] < heights[anchor]) {
    			int temp = heights[explorer];
    			heights[explorer] = heights[anchor];
    			heights[anchor] = temp;
    			anchor++;
    		}
    		
    	}
        
    	return anchor;
    }
}
