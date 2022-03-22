package com.sranjan.dsa.facebook;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerConverter {
	public static void main(String...args) {
		
		RomanToIntegerConverter converter = new RomanToIntegerConverter();
		System.out.println(converter.romanToInt3("IV"));
		System.out.println(converter.integerToRoman(3999));
		
	}
	
    public int romanToInt(String s) {
    	Map<Character,Integer> map = new HashMap<>(7);
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	int result = 0;
    	for(int i=s.length();i>0;i--) {
    		char ch = s.charAt(i);
    		switch (ch) {
			case 'I': result += result>=5?-1:1;
				break;
			case 'V': result += 5; 
				
				break;
			case 'X': result+= result>=50? -10: 10;
				
				break;
			case 'L':
				
				break;
			case 'C':
				
				break;
			case 'D':
				
				break;
				
			case 'M':
				
				break;	
				
			}
    		
    		
    		
    	}
    	return result;
    }

	
	public int romanToInt3(String s) {
	    
	    Map<Character, Integer> roman = new HashMap<>();
	    roman.put('I', 1);
	    roman.put('V', 5);
	    roman.put('X', 10);
	    roman.put('L', 50);
	    roman.put('C', 100);
	    roman.put('D', 500);
	    roman.put('M', 1000);
	    
	    int result = 0;
	    for (int i = 0; i < s.length(); i++) {
	        if ((i+1) < s.length() && roman.get(s.charAt(i)) < roman.get(s.charAt(i+1))) {
	            result -= roman.get(s.charAt(i));
	        } else {
	            result += roman.get(s.charAt(i));   
	        }
	    }
	    
	    return result;
	}
	
	
    
    public int romanToInt2(String s) {
        int sum = 0;
        
        int n = s.length();
        for (int i = n-1; i>=0; i--){
            char ch = s.charAt(i);
            switch (ch){
                case 'I': sum += sum>=5?-1: 1; break;
                case 'V': sum += 5;break;
                case 'X': sum += sum>=50?-10: 10;break;
                case 'L': sum += 50;break;
                case 'C': sum += sum>=500? -100: 100;break;
                case 'D': sum += 500;break;
                case 'M': sum += 1000;break;
                
            }
        }
        
        return sum;
    }
	
    public String integerToRoman(int num) {
    	
    	if (num < 1 || num > 3999) return "";
    	
    	StringBuilder result = new StringBuilder();
    	
    	String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    	int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    	
    	int i = 0;
                //iterate until the number becomes zero, NO NEED to go until the last element in roman array
    	while (num >0) {
    		while ( num >= values[i]) {
    			num -= values[i];
    			result.append(roman[i]);
    		}
    		i++;
    	}
    	return result.toString();
    }
    
    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
