package Google;

public class OnesandZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMaxForm(new String[]{
				//"10", "0", "1"}, 1,1));
				"10","0001","111001","1","0"}, 5, 3));
	}

	public static int findMaxForm(String[] strs, int m, int n) {
		if(m==0 && n==0) return 0;
		int dp[][] = new int[m+1][n+1];
		int count[];
		dp[0][0] =0;
		for(int indx=0; indx<strs.length; indx++){
			count = count01s(strs[indx]);
			//others need to decide to take or leave this string
			for(int i=m; i>=count[0]; i--){
				for(int j=n; j>=count[1]; j--){
					dp[i][j] = Math.max(dp[i][j], dp[i-count[0]][j-count[1]] +1);
				}
			}
		}
		return dp[m][n];
	}
	
	private static int[] count01s(String str){
		int len=str.length(), sum=0;
		int count[] =new int[2];
		for(Character c: str.toCharArray()) 
			sum+=c-'0';
		count[0] = len-sum;
		count[1] = sum;
		return count;
	}
	
}
