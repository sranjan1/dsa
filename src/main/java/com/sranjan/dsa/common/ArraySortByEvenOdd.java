package com.sranjan.dsa.common;

/**
 * 
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * 
 * @author sumit
 *
 */

public class ArraySortByEvenOdd {

	public static void main(String[] args) {
		int[] A = {3,1,2,4};
		new ArraySortByEvenOdd().sortArrayByParity(A);
		for (int num: A) {
			System.out.println(num);
		}

	}
	
    public int[] sortArrayByParity(int[] A) {
    	int anchor = 0;    	
    	for(int explorer=0; explorer<A.length; explorer++) {
    		if(isEven(A[explorer])) {
    			int temp = A[explorer];
    			A[explorer] = A[anchor];
    			A[anchor] = temp;
    			anchor++;
    		}
    	}
    	return A;
    }
    
    private boolean isEven(int number) {
    	return (number & 1) == 0;
    }
}
