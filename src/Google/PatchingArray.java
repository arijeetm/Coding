package Google;

public class PatchingArray {

	public static void main(String[] args) {
		System.out.println(minPatches(new int[]{1,2,31,33
				}, 2147483647));
	}
	public static int minPatches(int[] nums, int n) {
		int len= nums.length;
		int patches=0, miss=1, indx=0;
		while(miss>0 && miss<=n) // till all are covered and check for wrap around
		{
			if(indx<len && nums[indx]<=miss) // within range
			{
				miss+=nums[indx++]; // update the next missing value
			} else {
				patches++; // add patch
				miss*=2; // update the next missing value
			}
		}
		return patches;     
	}
}
