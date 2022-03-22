package com.sranjan.dsa.math;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberOperations {

	public static void main(String[] args) {
		PrimeNumberOperations.sieveOfEratosthenes(31);
	}

	public static boolean isPrime(int number) {
		return false;
	}

	// Using Sieve of Eratosthenes print all prime numbers
	// smaller than given number
	public static void sieveOfEratosthenes(int number) {
		List<Integer> primeNumbers = new ArrayList<>();
		boolean[] prime = new boolean[number + 1];
		//By default everything is prime
		for(int i=0; i<prime.length; i++) {
			prime[i] = true;
		}
		
		for(int i=2; i<=Math.sqrt(number); i++) {
			if(true == prime[i]) {
				for(int j=i*i; j<=number;j=j+i) {
					prime[j]=false;					
				}
				
			}
		}
		
		for(int i=2; i<number;i++) {
			if(true == prime[i]) {
				System.out.println(i);
			}
		}
	}
}
