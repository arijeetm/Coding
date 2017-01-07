public class SplitArrayLargestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(splitArray(new int[]{1,4,1},3));
	}
	
	//binary search approach
	public static int splitArrayBSearch(int[] nums, int m){
		if(nums==null || nums.length==0) return 0;
		int len=nums.length;
		int low=0, high=0; // low and high value of result, high when the sub array contains all elements
		// low when each sub array split to single elements
		for(int i=0; i<len; i++){
			high += nums[i];
			low= Math.max(low, nums[i]);
		}
		if(m==1) return high; // no partition
		while(low<=high){
			int mid= (low+high)/2;
			boolean is = canSplit(nums, mid, m);
			if(is) high=mid-1;
			else low=mid+1; // low mid
		}
		return low;
	}
	private static boolean canSplit(int[] nums, int target, int m) {
		int count=0, sum=0;
		for(int i=0; i<nums.length; i++){
			sum+=nums[i];
			if(sum>target){
				count++;
				sum=nums[i];
				if(count>=m) return false; // still numbers left
			}
		}
		return true;
	}
	
	//DP
	public static int splitArray(int[] nums, int m) {
		if(nums==null || nums.length==0) return 0;
		int len=nums.length;
		int dp[]= new int[len]; // dp[i]-> minimum of maximum sum for sub array of length i
		//Arrays.sort(nums);
		dp[0]= nums[0];
		for(int i=1; i<len; i++) dp[i]= dp[i-1]+ nums[i]; 
		// num_part=1 is no partition
		for(int num_part=2; num_part<=m; num_part++){
			for(int i=len-1; i>=0; i--){ // smaller sub array may not be partioned, hence cannot be used for larger arrays
				int right= nums[i];
				int min= Integer.MAX_VALUE;
				for(int part=i-1; part>=num_part-2; part--){
					min= Math.min(min, Math.max(dp[part] ,right));
					right+=nums[part];
				}
				dp[i]=min;
			}
		}
		return dp[len-1];
	}
}
