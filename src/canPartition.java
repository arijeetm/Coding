import java.util.Arrays;

public class canPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean canPartition(int[] nums) {
		if(nums==null || nums.length==0) return false;
		int n=nums.length, sum=0, target;
		for(int i=0; i<n; i++) sum+=nums[i];
		if(sum%2==1) return false;
		target=sum/2;
		boolean[][] dp= new boolean[target+1][n+1];
		dp[0][0]=true;
		for(int i=1; i<=target; i++) dp[i][0]=false;
		for(int j=1; j<=n; j++) dp[0][j]= false;
		
		for(int i=1; i<=target; i++){
			for(int j=1; j<=n; j++){
				dp[i][j]= dp[i][j-1];
				if(i>=nums[j-1]) dp[i][j] = dp[i][j] || dp[i-nums[j-1]][j-1];
			}
		}
		return dp[target][n];
	}
}
