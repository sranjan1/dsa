package com.sranjan.dsa.common;

import java.util.Arrays;

public class SortedArray {

	private static int[] sortedArray = {-7,-3,2,3,11};

	public static void main(String[] args) {
		Timer.startTimer();
		int[] result = new SortedArray().sortedSquares(sortedArray);
		Timer.stopTimer();
		for(int squareNumber : result) {
			System.out.println(squareNumber);
		}
		System.out.println("Result took "+Timer.getDurationInMicros()+ " micros");
		
		Timer.startTimer();
		int[] result2 = new SortedArray().sortedSquaresWithoutCopy(sortedArray);
		Timer.stopTimer();
		for(int squareNumber : result2) {
			System.out.println(squareNumber);
		}
		System.out.println("Result took "+Timer.getDurationInMicros()+ " micros");
	}

	public int[] sortedSquares(int[] A) {
		int[] squareArray = new int[A.length];
		for (int i=0; i<A.length-1; i++) {
			int square = A[i] * A[i];
			squareArray[i] = square;
		}
		Arrays.sort(squareArray);
		return squareArray;
	}
	
	public int[] sortedSquaresWithoutCopy(int[] A) {
		for (int i=0; i<A.length-1; i++) {
			A[i] *= A[i];
		}
		Arrays.sort(A);
		return A;
	}

}
