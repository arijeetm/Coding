package GoldenProbs;

public class DistinctSubsequences {

	public static void main(String[] args) {
		System.out.println(numDistinct("ccc", "c"));
	}
	public static int numDistinct(String s, String t) {
		int slen=s.length(), tlen=t.length();
		if(slen<tlen) return 0;
		int dp[][]= new int[tlen+1][slen+1]; // dp[i][j]-> number of distinct between s[0..j] and t[0..i]
		for(int i=0; i<=slen; i++) dp[0][i]=1; //empty string is substring for all
		//for(int i=1; i<=tlen; i++) dp[i][0]=0; //empty string cannot match any non empty string
		for(int i=1; i<=tlen; i++){ //pattern
			for(int j=1; j<=slen; j++){ //text
				if(s.charAt(j-1)==t.charAt(i-1)) dp[i][j]= dp[i-1][j-1] + dp[i][j-1];
				else dp[i][j]= dp[i][j-1];
			}
		}
		return dp[tlen][slen];
	}
}
