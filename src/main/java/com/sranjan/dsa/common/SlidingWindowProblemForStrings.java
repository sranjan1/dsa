package com.sranjan.dsa.common;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowProblemForStrings {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
//		String answer = minWindow(s, t);
//		System.out.println(answer);
		String result = minWindowUsingArrays(s, t);
		System.out.println(result);
	}
	
	public static String minWindow(String s, String t) {
		if (t.length() > s.length())
			return "";
		Map<Character, Integer> tMap = new HashMap<>();
		for (char c : t.toCharArray()) {
			tMap.put(c, tMap.getOrDefault(c, 0) + 1);
		}
		int counter = tMap.size();

		int left = 0, right = 0;
		int head = 0;
		int len = Integer.MAX_VALUE;

		while (right < s.length()) {
			char c = s.charAt(right);
			if (tMap.containsKey(c)) {
				tMap.put(c, tMap.get(c) - 1);
				if (tMap.get(c) == 0)
					counter--;
			}
			right++;

			while (counter == 0) {
				char tempc = s.charAt(left);
				if (tMap.containsKey(tempc)) {
					tMap.put(tempc, tMap.get(tempc) + 1);
					if (tMap.get(tempc) > 0) {
						counter++;
					}
				}
				if (right - left < len) {
					len = right - left;
					head = left;
				}
				left++;
			}

		}
		if (len == Integer.MAX_VALUE)
			return "";
		return s.substring(head, head + len);
	}
	
	
	public static String minWindowUsingArrays(String s, String t) {
		int sLength = s.length();
		char[] arr = s.toCharArray();
		char[] map = new char[256];
		int counter = 0, min = sLength + 1, idx = 0;
		for (char c : t.toCharArray()) {
			System.out.println("Char is " + c + " and map[c] = " + map[c]);
			if (map[c] == 0) {
				counter++;
			}
			map[c]++;
		}
		int left = 0, right = 0;

		while (right < sLength) {
			char c = arr[right];
			if (map[c] == 1) {
				counter--;

			}
			map[c]--;
			right++;

			while (counter == 0) {
				char c1 = arr[left];
				if (min > (right - left)) {
					min = right - left;
					idx = left;
				}
				left++;
				// min = Math.min(min, end-start);
				map[c1]++;
				if (map[c1] == 1) {
					counter++;
				}
			}
		}

		return min == sLength + 1 ? "" : s.substring(idx, idx + min);
	}
	
	
}
