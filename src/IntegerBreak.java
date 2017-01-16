
public class IntegerBreak {

	public static void main(String[] args) {
		System.out.println(integerBreak(10));

	}
	public static int integerBreak(int n) {
        int dp[]= new int[n+1];
        for(int i=2; i<=n; i++){
        	for(int j=1; j<i; j++){
        		dp[i]= Math.max(dp[i], Math.max(j, dp[j])*Math.max(i-j, dp[i-j]));
        	}
        }
        return dp[n];
    }
}
