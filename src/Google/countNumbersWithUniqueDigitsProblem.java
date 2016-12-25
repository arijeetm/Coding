package Google;

public class countNumbersWithUniqueDigitsProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countNumbersWithUniqueDigits(int n) {
		if(n==0) return n;
        int dp[] = new int[n+1]; // dp[i] -> count of numbers with unique digits of length less than i
        dp[1]=10;
        for(int i=2; i<=n; i++){
        	int prod=9; //first term cannot be 0
        	for(int j=0; j<i-1; j++){
        		prod *= (9-j);
        	}
        	dp[i] = dp[i-1] + prod;
        }
        return dp[n];
    }
}
