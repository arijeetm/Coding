import java.util.Arrays;

public class CombinationString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum4dp(new int[]{1, 2,3}, 4));
	}
	public static int combinationSum4(int[] nums, int target) {
		int cache[]= new int[target+1];
		Arrays.fill(cache, -1);
		return combinationSum4Util(nums, target, cache);
	}
	private static int combinationSum4Util(int[] nums, int target, int cache[]){
		if(nums==null || nums.length==0) return 0;
		if(target==0) return 1;
		if(cache[target]!=-1) return cache[target];
		int n=nums.length;
		int res=0;
		for(int i=0; i<n; i++){
			if(target>=nums[i]) 
				res+= combinationSum4Util(nums, target-nums[i], cache);
		}
		return cache[target]=res;
	}
	public static int combinationSum4dp(int nums[], int target){
		if(nums==null || nums.length==0) return 0;
		int len=nums.length;
		int dp[]= new int[target+1];
		dp[0]=1;
		for(int i=1; i<=target; i++){
			for(int j=1; j<=len; j++){
				if(nums[j-1]<=i) 
					dp[i]+=  dp[i-nums[j-1]];
			}
		}
		return dp[target];
	}
}
