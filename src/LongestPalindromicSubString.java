
public class LongestPalindromicSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private String longestPalindromeUtil(String s, int low, int high){
		int maxlen=0, start=0, l;
		while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
			l= high-low+1;
			if(maxlen<l){
				maxlen=l;
				start=low;
			}
			low--; high++;
		}
		return s.substring(start, start+ maxlen);
	}
	
	public String longestPalindrome(String s) {
		if(s==null || s.length()==0) return s;
		int len= s.length();
		if(len==1) return s;
		int maxlen=0;
		String res=null;
		for(int i=1; i<len; i++){
			String evenPalindrome= longestPalindromeUtil(s, i-1, i);
			if(maxlen< evenPalindrome.length()){
				maxlen= evenPalindrome.length();
				res= evenPalindrome;
			}
			String oddPalindrome= longestPalindromeUtil(s, i-1, i+1);
			if(maxlen< oddPalindrome.length()){
				maxlen= oddPalindrome.length();
				res= oddPalindrome;
			}
			
		}
		if(res.isEmpty() && s.charAt(0)==s.charAt(s.length()-1)) return s.substring(0, 1);
			
		return res;
	}
}
