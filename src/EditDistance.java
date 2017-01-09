
public class EditDistance {

	public static void main(String[] args) {
		System.out.println(minDistance("","a"));
	}
	
	public static int minDistance(String word1, String word2) {
		int m= word1.length(), n=word2.length();
		int dp[][]= new int[m+1][n+1];//dp[i][j]-> min dist from word1[0...i] to word2[0...j]
		for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++){
				if(i==0) dp[i][j]=j; //all insert
				else if(j==0) dp[i][j]=i; // all remove
				else if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]= dp[i-1][j-1];
				else{
					dp[i][j]= 1+ Math.min(dp[i-1][j-1], //replace
							Math.min(dp[i-1][j], //remove
									dp[i][j-1])); //insert
				}
			}
		}
		return dp[m][n];
	}
}
