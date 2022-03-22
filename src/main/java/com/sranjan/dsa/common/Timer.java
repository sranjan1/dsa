package com.sranjan.dsa.common;

public class Timer {
	private static long startTime;
	private static long endTime;
	
	public static void startTimer() {
		startTime = System.nanoTime();
	}
	
	public static void stopTimer() {
		endTime = System.nanoTime();
	}
	
	public static long getDuration() {
		return endTime - startTime;
	}
	
	public static long getDurationInMicros() {
		return (endTime - startTime)/1000;
	}
	
	public static long getDurationInMillis() {
		return (endTime - startTime)/1000000;
	}
	
	
}
