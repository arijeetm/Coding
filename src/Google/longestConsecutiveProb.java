package Google;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutiveProb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int longestConsecutive(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		Set<Integer> ele = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++) ele.add(nums[i]);
		int maxlen=1; // minimum length of lcs is just the single element
		for (int i=0; i<nums.length; i++){
			int left= nums[i]-1;
			int right=nums[i]+1;
			int count=1; //minimum length of lcs
			while(ele.contains(left)){
				ele.remove(left);
				count++;
				left--;
			}
			while(ele.contains(right)){
				ele.remove(right);
				count++;
				right++;
			}
			maxlen= Math.max(maxlen, count);
		}
		return maxlen;
	}
}
