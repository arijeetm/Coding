package GoldenProbs;

import java.util.HashSet;
import java.util.Set;

public class InterLeavingStrings {

	public static void main(String[] args) {
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}
	public static boolean isInterleave(String s1, String s2, String s3) {
		int len1=s1.length(), len2=s2.length(), len3=s3.length();
		if(len1+len2!=len3) return false;
		Set<String> points= new HashSet();
		return isInterleaveUtil(s1, s2, s3, 0, 0, points);
	}
	private static boolean isInterleaveUtil(String s1, String s2, String s3, int i, int j, Set<String> points) {
		if(i+j==s3.length()) return true; //complete match
		String p= i+""+j;
		if(points.contains(p)) return false; //already traversed -- prune
		points.add(p);
		boolean m1= i<s1.length() && s3.charAt(i+j)==s1.charAt(i) ? true: false;
		boolean m2= j<s2.length() && s3.charAt(i+j)==s2.charAt(j) ? true: false;
		if(m1 && m2)
			return isInterleaveUtil(s1,s2,s3, i+1, j, points) || isInterleaveUtil(s1,s2,s3, i, j+1, points);
		if(m1)
			return isInterleaveUtil(s1,s2,s3, i+1, j, points);
		if(m2)
			return isInterleaveUtil(s1,s2,s3, i, j+1, points);
		return false;
	}
}
