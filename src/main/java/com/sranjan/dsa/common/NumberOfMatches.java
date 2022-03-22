package com.sranjan.dsa.common;

public class NumberOfMatches {

	public static void main(String[] args) {
		System.out.println(numberOfMatches(7));
	}

	public static int numberOfMatches(int n) {
		// TODO edge cases
		if (n == 1) {
			return 0; // If there is only 1 team, no matches need to be played
		}
		if (n == 2) {
			return 1;
		}

		int numOfMatchesPlayed = 0;
		int numOfQualifyingTeams = 0;

		while (n > 2) {
			if (isEven(n)) {
				numOfMatchesPlayed += n / 2;
				numOfQualifyingTeams = n / 2;
			} else {
				numOfMatchesPlayed += (n - 1) / 2;
				numOfQualifyingTeams = ((n - 1)/2) + 1;
			}
			n = numOfQualifyingTeams;
		}
		return numOfMatchesPlayed + 1;

	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
	}
}
