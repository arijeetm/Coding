package Google;

public class GuessHighLow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMoneyAmount(2));
	}

	public static int getMoneyAmount(int n) {
		int dp[][]= new int[n+1][n+1]; //dp[i][j]-> cost from guess i to j
		for(int i=1; i<=n; i++){
			dp[i][i]=0;
		}
		for(int len=2 ;len<=n; len++){ //range
			for(int i=1; i+len-1<=n; i++){
				int j= i+len-1;
				dp[i][j]= i+ dp[i+1][j]; //boundary values
				dp[i][j] = Math.min(dp[i][j], j+ dp[i][j-1]); //boundary values
				for(int k=i+1; k<j; k++){
					dp[i][j]= Math.min( //choose best (least cost) from worst case scenerio
							dp[i][j], 
							k+ Math.max(dp[i][k-1], dp[k+1][j])); // worst case
				}
			}
		}
        return dp[1][n];
    }
}
