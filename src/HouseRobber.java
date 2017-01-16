
public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rob(new int[]{0,0,0}));
	}
	 public static int rob(int[] nums) {
			if(nums==null|| nums.length==0) return 0;
			int len= nums.length;
			if(len==1) return nums[0];
			return Math.max(robUtil(nums, 0, len-2), 
					robUtil(nums, 1, len-1));
		}
		
		private static int robUtil(int nums[], int low, int high){
		    int len= high-low+1;
		    if(len==1) return nums[low];
			int dp[]= new int[len];
			dp[0]=nums[low]; 
			dp[1]=Math.max(nums[low], nums[low+1]);
			for(int i=low+2; i<=high; i++){
				dp[i-low]= Math.max(nums[i]+ dp[i-low-2], dp[i-low-1]);
			}
			return dp[len-1];
		}
}
