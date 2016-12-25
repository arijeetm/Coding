package Google;

public class integerReplacementProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(integerReplacement(65535));
	}

	public static int integerReplacement(int n) {
		if(n<2) return 0;
		if(n==2147483647) return 32;
		if(n%2==0) return 1+integerReplacement(n/2);
		else return 1 + Math.min(integerReplacement(n-1), integerReplacement(n+1));	
    }
	
	/*int dp[] = new int[n+1];
	//for(int i=2; i<=n; i++) dp[i] = Integer.MAX_VALUE;
	dp[0]=0; dp[1]=0; dp[2]=1;
	for(int i=2; i<=n; i++){
		if(i%2==0 && dp[i]>1+ dp[i/2])
			dp[i] = 1+ dp[i/2];
		else if(i%2==1){
			int val = 1 + Math.min(dp[i-1], i<n? 1+dp[i+1]: Integer.MAX_VALUE);
			if(dp[i]>val) dp[i]=val;
		}
	}	
	return dp[n];*/
}
