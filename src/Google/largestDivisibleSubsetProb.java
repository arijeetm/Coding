package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largestDivisibleSubsetProb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(largestDivisibleSubset(new int[]{3,4,16,8}));
	}
	public static List<Integer> largestDivisibleSubset(int[] nums) {
		if(nums==null || nums.length==0) return null;
        List<Integer> res = new ArrayList<Integer>();
        int len=nums.length;
        Arrays.sort(nums);
        int indx[]= new int[len];
        int dp[] = new int[len]; // dp[i] -> largest subset length with i
        Arrays.fill(dp, 1);
        Arrays.fill(indx, -1);
        int max=0, maxindx=0;
        for(int i=1; i<len; i++){
        	for(int j=i-1; j>=0; j--){
        		if(nums[i]%nums[j]==0 
        				&& dp[i]<(dp[j]+1)){
        			dp[i]= dp[j]+1;
        			indx[i]=j;
        			if(max<dp[i]){
        				max=dp[i];
        				maxindx=i;
        			}
        		}
        	}
        }
        int i=maxindx;
        while(i>=0){
        	res.add(nums[i]);
        	i= indx[i];
        }
        return res;
    }
	
}
