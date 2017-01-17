
public class maxSubArrayProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxProduct(int[] nums) {
		if(nums==null|| nums.length==0) return 0;
		int res=nums[0], len=nums.length;
		int max[]= new int[len];
		int min[]= new int[len];
		min[0]= max[0]= nums[0];
		for(int i=1; i<len; i++){
			// max value is either only the element, or positive val * max so far , or negative value *min so far
			max[i]= Math.max(nums[i], Math.max(nums[i]* max[i-1], nums[i]*min[i-1]));
			// min value is either just the element/positive val*min so far/ negative val * max so far
			min[i]= Math.min(nums[i], Math.min(nums[i]*min[i-1], nums[i]*max[i-1]));
			// get max product value across each sub array from 0..i
			res= Math.max(res, max[i]);
		}
		return res;
	}
}
