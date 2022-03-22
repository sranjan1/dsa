package com.sranjan.dsa.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindowProblem {

	public static void main(String[] args) {
		int[] nums = { 4, 2, 0, 5, 1, 8, 1, 2, 8, 1, 0 };
		int k = 3;
		int targetSum = 8;
//		System.out.println(findMaxSumSubarrayOfSizeK(nums, k));
//		int[][] answer = minSubArraysWithTargetSum(nums, targetSum);
		String str = "wordgoodgoodgoodbestword";
		String[] newWords = {"word","good","best","good"};
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String[] words = { "foo", "bar" };
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> answer = groupAnagrams(strs);
		System.out.println(answer);
	}

	public static int findMaxSumSubarrayOfSizeK(int[] nums, int k) {
		int currentRunningSum = 0;
		int maxSum = 0;
		for (int i = 0; i < nums.length; i++) {
			System.out.println("i = " + i + " currentRunningSum = " + currentRunningSum + " maxSum = " + maxSum);
			currentRunningSum += nums[i];
			if (i >= k - 1) {
				maxSum = Math.max(maxSum, currentRunningSum);
				currentRunningSum -= nums[i - (k - 1)];
			}
		}
		return maxSum;
	}

	public static int[][] allSubArraysWithTargetSum(int[] nums, int targetSum) {
		List<int[]> result = new ArrayList<>();
		int currentRunningSum = 0;
		int left = 0;
		int right = 0;
		while (right < nums.length) {
			currentRunningSum += nums[right];
			if (currentRunningSum < targetSum) {
				right++;
				continue;
			} else if (currentRunningSum > targetSum) {
				currentRunningSum = 0;
				left++;
				right = left;
			} else if (currentRunningSum == targetSum) {
				int[] temp = new int[right - left + 1];
				int tempLeft = left;
				int i = 0;
				while (tempLeft <= right) {
					temp[i++] = tempLeft++;
				}
				result.add(temp);
				left++;
				right = left;
				currentRunningSum = 0;
			}
		}
		return result.toArray(new int[result.size()][]);
	}

	public static int[][] minSubArraysWithTargetSum(int[] nums, int targetSum) {
		List<int[]> result = new ArrayList<>();
		int currentRunningSum = 0;
		int left = 0;
		int right = 0;
		while (right < nums.length) {
			currentRunningSum += nums[right];
			if (currentRunningSum < targetSum) {
				right++;
				continue;
			} else if (currentRunningSum > targetSum) {
				currentRunningSum = 0;
				left++;
				right = left;
			} else if (currentRunningSum == targetSum) {
				int[] temp = new int[right - left + 1];
				int tempLeft = left;
				int i = 0;
				while (tempLeft <= right) {
					temp[i++] = tempLeft++;
				}
				if (!result.isEmpty()) {
					for (int counter = 0; counter < result.size(); counter++) {
						if (result.get(counter).length > temp.length) {
							result.remove(counter);
						}
					}
				}
				result.add(temp);
				left++;
				right = left;
				currentRunningSum = 0;
			}
		}
		return result.toArray(new int[result.size()][]);
	}

	public static String minWindow2(String s, String t) {
		if (t.length() > s.length()) {
			return "";
		}
		String answer = "";
		int left = 0, right = 0;
		Map<Character, Integer> tMap = new HashMap<>();
		initializeMap(t, tMap);
		int counter = initializeCounter(tMap);
		while (right < s.length() && counter > 0) {
			Character c = s.charAt(right);
			if (tMap.containsKey(c)) {
				tMap.put(c, tMap.getOrDefault(c, 0) - 1);
				if (tMap.get(c) == 0)
					tMap.remove(c);
				counter--;
			}
			right++;

			if (counter == 0 && tMap.isEmpty()) {
				if (answer == "") {
					answer = s.substring(left, right);
				} else {
					answer = s.substring(left, right).length() < answer.length() ? s.substring(left, right) : answer;
				}
				initializeMap(t, tMap);
				left++;
				right = left;
				counter = initializeCounter(tMap);
			}
		}
		return answer;
	}

	private static void initializeMap(String t, Map<Character, Integer> tMap) {
		for (Character c : t.toCharArray()) {
			tMap.put(c, tMap.getOrDefault(c, 0) + 1);
		}
	}

	private static int initializeCounter(Map<Character, Integer> tMap) {
		int counter = 0;
		for (Integer value : tMap.values()) {
			counter += value;
		}
		return counter;
	}


	public static String minWindowWithoutUsingMaps(String s, String t) {
		if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
			return "";
		}

		int left = 0;
		int right = 0;

		int[] Tmap = new int[256];
		int[] Smap = new int[256];

		for (int k = 0; k < t.length(); k++) {
			Tmap[t.charAt(k)]++;
		}

		int found = 0;
		int length = Integer.MAX_VALUE;
		String answer = "";
		while (right < s.length()) {
			if (found < t.length()) {
				if (Tmap[s.charAt(right)] > 0) {
					Smap[s.charAt(right)]++;
					if (Smap[s.charAt(right)] <= Tmap[s.charAt(right)]) {
						found++;
					}
				}
				right++;
			}
			while (found == t.length()) {
				if (right - left < length) {
					length = right - left;
					answer = s.substring(left, right);
				}
				if (Tmap[s.charAt(left)] > 0) {
					Smap[s.charAt(left)]--;
					if (Smap[s.charAt(left)] < Tmap[s.charAt(left)]) {
						found--;
					}
				}
				left++;
			}
		}
		return answer;
	}



	public List<Integer> findAnagrams(String s, String t) {
		List<Integer> result = new ArrayList<>();
		if (t.length() > s.length())
			return result;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int counter = map.size();
		int left = 0, right = 0;

		while (right < s.length()) {
			char c = s.charAt(right);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					counter--;
			}
			right++;
			while (counter == 0) {
				char tempc = s.charAt(left);
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);
					if (map.get(tempc) > 0) {
						counter++;
					}
				}
				if (right - left == t.length()) {
					result.add(left);
				}
				left++;
			}
		}
		return result;
	}

	public List<Integer> findAnagramsWithoutMaps(String s, String p) {
		int[] count = new int[26];
		for (char c : p.toCharArray()) {
			count[c - 'a']++;
		}

		List<Integer> list = new ArrayList<>();
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			count[c - 'a']--;
			if (count[c - 'a'] < 0) {
				while (count[c - 'a'] < 0) {
					count[s.charAt(start++) - 'a']++;
				}
			} else if (count[c - 'a'] == 0 && (i - start + 1 == p.length())) {
				list.add(start);
				count[s.charAt(start++) - 'a']++;
			}
		}

		return list;
	}

	public static List<Integer> findAnagramsWithDescription(String s, String p) {

		/*
		 * follow this template for window problems in strings: 1-make a hash array to
		 * store count 2-if any char of s is found in p then we substract the count by 1
		 * and expand the window if window is right-left==p.length means we found the
		 * anagram else part:- when we found the char of s which is not present in p
		 * then all previous char of s are incremented to hash from left to right
		 */
		int hash[] = new int[26];
		List<Integer> ans = new ArrayList<>();
		for (char ch : p.toCharArray()) {
			hash[ch - 'a']++;
		}
		int left = 0, right = 0;
		while (right < s.length() && left < s.length()) {
			char ch1 = s.charAt(right);
			char ch2 = s.charAt(left);
			if (hash[ch1 - 'a'] > 0) {
				hash[ch1 - 'a']--;
				right++;
			} else {
				hash[ch2 - 'a']++;
				left++;
			}
			if (right - left == p.length())
				ans.add(left);
		}
		return ans;
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Integer> lookupMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			lookupMap.put(s.charAt(i), lookupMap.getOrDefault(s.charAt(i), 0) + 1);
			lookupMap.put(t.charAt(i), lookupMap.getOrDefault(t.charAt(i), 0) - 1);
		}
		for (char c : lookupMap.keySet()) {
			if (lookupMap.get(c) != 0) {
				return false;
			}
		}

		return true;
	}

	public static List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> answer = new ArrayList<>();
		// TODO FIXME Edge Cases return empty list

		Map<String, Integer> wordMap = new HashMap<>();
		for (String word : words) {
			wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
		}
		int counter = wordMap.size();
		int left = 0;
		int right = 0;
		int head = 0;
		StringBuilder tempString = new StringBuilder();
		while (right < s.length() && left < s.length()) {
			char c = s.charAt(right);
			tempString.append(c);
			if (wordMap.containsKey(tempString.toString())) {
				wordMap.put(tempString.toString(), wordMap.get(tempString.toString()) - 1);
				counter--;
				tempString = new StringBuilder();
			}
			right++;
			if (counter == 0) {
				answer.add(left);
				char ch = s.charAt(left);
				tempString.append(ch);
				if (wordMap.containsKey(tempString.toString())) {
					wordMap.put(tempString.toString(), wordMap.get(tempString.toString()) + 1);
					counter++;
					tempString = new StringBuilder();
				}
			}
			left++;
		}
		return answer;

	}

	public static List<Integer> findSubstring5(String s, String[] words) {
		if (s == null || words == null || s.length() == 0 || words.length == 0) {
			return new ArrayList<>();
		}
		Map<String, Integer> counts = new HashMap<>();
		for (String word : words) {
			counts.put(word, counts.getOrDefault(word, 0) + 1);
		}

		List<Integer> result = new ArrayList<>();
		int stringLength = s.length();
		int arrayWordsLength = words.length;
		int wordLength = words[0].length();
		for (int counter = 0; counter < stringLength - arrayWordsLength * wordLength + 1; counter++) {
			String sub = s.substring(counter, counter + arrayWordsLength * wordLength);
			if (isConcat4(sub, counts, wordLength)) {
				result.add(counter);
			}
		}
		return result;
	}

	/**
	 * */
	private static boolean isConcat4(String substr, Map<String, Integer> counts, int wordLen) {
		Map<String, Integer> seen = new HashMap<>();
		for (int i = 0; i < substr.length(); i += wordLen) {
			String sWord = substr.substring(i, i + wordLen);
			seen.put(sWord, seen.getOrDefault(sWord, 0) + 1);
		}
		return seen.equals(counts);
	}

	/*
	 * A time & space O(n) solution Run a moving window for wordLen times. Each time
	 * we keep a window of size windowLen (= wordLen * numWord), each step length is
	 * wordLen. So each scan takes O(sLen / wordLen), totally takes O(sLen / wordLen
	 * * wordLen) = O(sLen) time.
	 * 
	 * One trick here is use count to record the number of exceeded occurrences of
	 * word in current window
	 */
	public static List<Integer> findSubstring4(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (words == null || words.length == 0 || s.length() == 0)
			return res;
		int wordLen = words[0].length();
		int numWord = words.length;
		int windowLen = wordLen * numWord;
		int sLen = s.length();
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words)
			map.put(word, map.getOrDefault(word, 0) + 1);

		for (int i = 0; i < wordLen; i++) { // Run wordLen scans
			HashMap<String, Integer> curMap = new HashMap<>();
			for (int j = i, count = 0, start = i; j + wordLen <= sLen; j += wordLen) { // Move window in step of wordLen
				// count: number of exceeded occurences in current window
				// start: start index of current window of size windowLen
				if (start + windowLen > sLen)
					break;
				String word = s.substring(j, j + wordLen);
				if (!map.containsKey(word)) {
					curMap.clear();
					count = 0;
					start = j + wordLen;
				} else {
					if (j == start + windowLen) { // Remove previous word of current window
						String preWord = s.substring(start, start + wordLen);
						start += wordLen;
						int val = curMap.get(preWord);
						if (val == 1)
							curMap.remove(preWord);
						else
							curMap.put(preWord, val - 1);
						if (val - 1 >= map.get(preWord))
							count--; // Reduce count of exceeded word
					}
					// Add new word
					curMap.put(word, curMap.getOrDefault(word, 0) + 1);
					if (curMap.get(word) > map.get(word))
						count++; // More than expected, increase count
					// Check if current window valid
					if (count == 0 && start + windowLen == j + wordLen) {
						res.add(start);
					}
				}
			}
		}
		return res;
	}
	
	
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		int arrayLength = words.length;
		int wordLength = words[0].length();
		int stringLength = s.length();
		
		if (stringLength < wordLength * arrayLength) {
			return result;
		}
		Map<String, Integer> wordMap = new HashMap<>();
		for(String word: words) {
			wordMap.put(word, wordMap.getOrDefault(word, 0)+1);
		}
		for (int counter = 0; counter < stringLength - arrayLength * wordLength + 1; counter++) {
			String sub = s.substring(counter, counter + arrayLength * wordLength);
			if (isConcat(sub, wordMap, wordLength)) {
				result.add(counter);
			}
		}
		return result;
    }

	private static boolean isConcat(String substr, Map<String, Integer> wordMap, int wordLength) {
		Map<String, Integer> seenMap = new HashMap<>();
		for(int i=0; i< substr.length(); i+=wordLength) {
			String str = substr.substring(i, i+wordLength);
			seenMap.put(str, seenMap.getOrDefault(str, 0)+1);
		}
		return seenMap.equals(wordMap);
	}


    public static List<List<String>> groupAnagramsUsingSorting(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }	
    
    public static List<List<String>> groupAnagrams(String[] strs){
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
    
    
    public static String minWindow(String s, String t) {
    	if(t.length() > s.length()) {
    		return "";
    	}
    	
    	int counter = 0;
    	int left = 0;
    	int right = 0;
    	int minWindow = s.length() + 1;
    	
    	char[] hash = new char[128];
    	for(char c: t.toCharArray()) {
    		if(hash[c] == 0) {
    			counter++;
    		}
    		hash[c]++;
    	}
    	while(right < s.length() && left < s.length()) {
    		char ch = s.charAt(right);
    		
    		
    	}
    	
    	
    	return null;
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
