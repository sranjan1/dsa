package com.sranjan.dsa.facebook;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

	public static void main(String[] args) {
		System.out.println(fractionToDecimal(2,3));
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("Divide by Zero");
		}
		StringBuilder result = new StringBuilder();
		String sign = (numerator < 0) ^ (denominator < 0) ? "-" : "";
		result.append(sign);

		long num =  Math.abs((long)numerator);
		long den =  Math.abs((long)denominator);
		result.append(num / den);
		num %= den;
		if (num  == 0) {
			return result.toString();
		}
		result.append(".");
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		map.put(num, result.length());
		while (num != 0) {
			num *= 10;
			result.append(num / den);
			num %= den;
			if (map.containsKey(num)) {
				int index = map.get(num);
				result.insert(index, "(");
				result.append(")");
				break;
			} else {
				map.put(num, result.length());
			}
		}

		return result.toString();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
