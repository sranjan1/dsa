package com.sranjan.dsa.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagram {

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> answer = new StringAnagram().findAnagrams(s, p);
		for (Integer num : answer) {
			System.out.println(num);
		}
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> answer = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() > s.length()) {
			return answer;
		}
		int[] phash = new int[26];
		int[] shash = new int[26];
		int window = p.length();
		int left = 0;
		int right = 0;

		while (right < window) {
			phash[p.charAt(right) - 'a']++;
			shash[s.charAt(right) - 'a']++;
			right++;
		}

		right--;
// for visibility, here is right - - 
		while (right < s.length()) {
			if (Arrays.equals(phash, shash)) {
				answer.add(left);
			}
			right++;
			if (right != s.length()) {
				shash[s.charAt(right) - 'a']++;
			}
			shash[s.charAt(left) - 'a']--;
			// for visibility, here is shash[s.charAt(left) - 'a'] - -
			left++;

		}
		return answer;
	}

}
