
public class MaximizeAs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMaxAs(20));
	}
	private static int getMaxAs(int N){ //N-> number of keystrokes
		if(N<7) return N;
		int dp[]= new int[N];
		for(int i=1; i<=6; i++) dp[i-1]=i;
		for(int i=7; i<=N; i++){
			dp[i-1]=0;
			for(int j=i-3; j>=1; j--){
				int k= (i-j-1)*dp[j-1];
				if(dp[i-1]<k) dp[i-1]=k;
			}
		}
		return dp[N-1];
	}
}
