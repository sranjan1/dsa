package com.sranjan.dsa.facebook;

public class NeedleHayStack {
	
	public static void main(String...args) {
		System.out.println(new NeedleHayStack().strStr("hello", "ll"));
		System.out.println(new NeedleHayStack().strStr("aaaaa", "bba"));		
		System.out.println(new NeedleHayStack().strStr("", ""));
		System.out.println(new NeedleHayStack().strStr("abc", "c"));
	}
	
	
	
	public int strstr(String haystack, String needle) {
		//edge cases
		if(haystack == "" && needle != "") {
			return -1;
		}
		
		if(needle.equals(haystack)) {
			return 0;
		}
		
		if(needle.length() > haystack.length()) {
			return -1;
		}
		
		int needleLength = needle.length();
		int hayStackLength = haystack.length();
		int threshold = hayStackLength - needleLength;
        for(int i=0;i<= threshold;i++) {
        	if(haystack.substring(i,i+needleLength).equals(needle)) {
        		return i;
        	}
        }
		return -1;
		
	}
	
    public int strStr(String str1, String str2) {
        int i=0, j=0;
        int strLength1 = str1.length();
        int strLength2 = str2.length();
        
        if(strLength1<strLength2) return -1;
        else if(strLength2 == 0 || strLength1 == 0) return 0;
        
        
        
/* if the first element of str2 is not present in first strLength1-strLength2 
characters of str1, then there is no use of searching further as it will not be completely present  */      
        for(i=0; i<=strLength1-strLength2; i++)
        {
            for(j=0; j<strLength2; j++)
            {
                if(str1.charAt(i+j)!=str2.charAt(j))
                    break;
            }
                if(j==strLength2)
                    return i;
        }
        return -1;
    }	
	

}
