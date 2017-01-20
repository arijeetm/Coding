package GoldenProbs;

public class ScrambleString {

	public static void main(String[] args) {
		System.out.println(isScramble("a", "a"));
	}
	public static boolean isScramble(String s1, String s2) {
		if(s1==null || s2==null) return false;
		if(s1.equals(s2)) return true;
		int count[]= new int[26];
		int l1=s1.length(), l2=s2.length();
		if(l1!=l2) return false;
		for(int i=0; i<l1; i++){
			count[s1.charAt(i)-'a']++;
			count[s2.charAt(i)-'a']--;
		}
		for(int i=0; i<l1; i++){
			if(count[i]!=0) return false;
		}
		for(int p=1; p<l1; p++){
			if(isScramble(s1.substring(0, p), s2.substring(0, p)) && isScramble(s1.substring(p), s2.substring(p))) return true;
			if(isScramble(s1.substring(0, p), s2.substring(l1-p)) && isScramble(s1.substring(p), s2.substring(0, l1-p))) return true;
		}
		return false;
	}
}
