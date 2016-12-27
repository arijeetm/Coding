package Google;

import java.util.Arrays;

public class SumPerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSquares(12));
	}
	 public static int numSquares(int n) {
		 int dp[]= new int[n+1]; // dp[i] -> number of squares which sum to i
		 Arrays.fill(dp, Integer.MAX_VALUE);
		 int maxsqr= (int) Math.sqrt(n);
		 for(int i=1; i<=maxsqr; i++){
			 dp[i*i]=1;
		 }
		 for(int i=1; i<=n; i++){
			 for(int j=1; j<=maxsqr; j++){
				 if(i>j*j)
					 dp[i]= Math.min(dp[i], 1+ dp[i-(j*j)]); 
			 }
		 }
		 return dp[n];
	 }
}
