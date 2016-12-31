package Google;

public class shortestPalindromeProb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(shortestPalindrome("abcd"));
	}
	public static String shortestPalindrome(String s) {
        int len= s.length();
        int i=0, j=len-1;
        while(j>=0){
        	if(s.charAt(i)==s.charAt(j)) i++; //start index of deviation from palindrome
        	j--;
        }
        if(i==len) return s; //already a palindrome
        String after= s.substring(i); 
        String before= new StringBuilder(after).reverse().toString(); // manage non palindrome part
        String mid=  shortestPalindrome(s.substring(0, i));
        return before+mid+after;
    }

}
