package CompetitiveProgramming;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int getMaxAnagramLength(String s1, String s2){
		if(s1==null || s1.length()==0 || s2==null|| s2.length()==0) return 0;
		Map<Integer, Integer> freq= new HashMap();
		int len1= s1.length(), len2=s2.length();
		if(len1<len2) {
			//swap len1 & len2 
			int t=len1; len1=len2; len2=t;
			String temp=s1; s1=s2; s2=temp;
		}
		for(Character c: s1.toCharArray()) freq.put(c-'a', freq.getOrDefault(c-'a', 0)+1);
		int dp[][]= new int[len2][len2]; //dp[i][j]-> max length from i..j
		for(int )
		
	}
}
