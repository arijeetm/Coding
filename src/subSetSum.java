
public class subSetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 13));
	}
	public static boolean isSubsetSum(int set[], int sum){
		if(sum==0) return true;
		if(set==null|| set.length==0) return false;
		int len= set.length;
		boolean dp[][]= new boolean[sum+1][len+1];
		for(int i=0; i<=len; i++) dp[0][i]= true;
		for(int i=1; i<=sum; i++) dp[i][0]= false;
		for(int i=1; i<=sum; i++){
			for(int j=1; j<=len; j++){
				dp[i][j] = dp[i][j-1] || 
						(i>=set[j-1] ? dp[i- set[j-1]][j-1]: false);
			}
		}
		return dp[sum][len];
	}
}
