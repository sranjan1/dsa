package com.sranjan.dsa.common;

public class FindNumbersWithEvenNumberOfDigits {
	
	private static int[] randomArray = new int[10];

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			randomArray[i] = new java.util.Random().nextInt(100000);
		}
		for (int num : randomArray) {
			System.out.println(num);
		}
		
		int result = new FindNumbersWithEvenNumberOfDigits().findNumbers(randomArray);
		System.out.println("Output from findNumbers is :"+result);
	}
	
    public int findNumbers(int[] nums) {
    	int count = 0;//init
    	for (int number : nums) {
    		if (isEven(numberOfDigits(number))) {
    			count++;
    		}
    	}
    	return count;
    }
    
    public int numberOfDigits(int number) {
    	String str = String.valueOf(number);
    	return str.length();
    }
    
    public boolean isEven(int number) {
    	if (number % 2 == 0) {
    		return true;
    	}
    	return false;
    }
}
