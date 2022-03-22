package com.sranjan.dsa.facebook;

public class MathOperations {

	public static void main(String[] args) {
		int x = 8;
		int n = 10;
		System.out.println(isPerfectSquare(16));
	}

	public static double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == Integer.MIN_VALUE) {
			x = x * x;
			n = n / 2;
		}
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
	
    public static int mySqrt(int x) {
    	long result = x;
    	while(result * result > x) {
    		result = (result + x/result)/2;
    	}
    	return (int) result;
    }
	
    public static boolean isPerfectSquare(int num) {
    	if(num == 0 || num == 1) {
    		return true;
    	}
        long result = num;
        while(result * result > num) {
        	result = (result + num/result)/2;
        }
        return result * result == num;
    }
	
	
	
	
	
	
	
}
