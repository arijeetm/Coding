/*
 * I) Traverse the given number from rightmost digit, 
 * keep traversing till you find a digit which is smaller than the previously traversed digit. 
 * 
 * II) Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’. 
 * 
 * III) Swap the above found two digits, we get 536974 in above example.
 * 
 * IV) Now sort all digits from position next to ‘d’ to the end of number. 
 * 
*/
package Google;

import java.util.Arrays;

public class nextPermutationProb {

	public static void main(String[] args) {
		// TODO Auto-generated method st
		nextPermutation(new int[]{5,1,1});
	}
	public static void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0) return;
        int indx = getIndex(nums);
        if(indx<0){
        	Arrays.sort(nums);
        	return;
        }
        //find smallest digit greater than nums[indx] on right
        int min=nums[indx], minindx=0;
        for(int i=indx+1; i<nums.length; i++){
        	if(min==nums[indx] && min<nums[i]) min=nums[i];
        	if(min>=nums[i] && nums[i]>nums[indx]) {
        		min=nums[i];
        		minindx=i;
        	}
        }
        //swap
        int temp =nums[indx];
        nums[indx]= nums[minindx];
        nums[minindx]= temp;
        //sort
        Arrays.sort(nums, indx+1, nums.length);
        for(int i=0;i <nums.length; i++)
        	System.out.print(nums[i]);
        return;
    }
	
	private static int getIndex(int[] nums){
		int i=0;
		for(i=nums.length-1; i>0 && nums[i] <= nums[i-1]; i--){}
		return i-1;
	}

}
