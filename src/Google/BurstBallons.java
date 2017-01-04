package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBallons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
	}
	public static int maxCoins(int[] nums) {
		if(nums==null|| nums.length==0) return 0;
		int n= nums.length;
		int dp[][]= new int[n][n]; //dp[i][j]-> max cost by bursting baloons from i to j
		int indx[][]= new int[n][n];
		for(int len=1; len<=n; len++){ //length of group
			for(int i=0; i<=n-len; i++){ //start index
				int j= i+len-1; //end index
				int coins= 0; //accumuate coins
				int max=0, maxindx=0;
				for(int k=i; k<=j; k++){ // last balloon to burst
					coins= nums[k]* getValue(nums, i-1)* getValue(nums, j+1);
					if(k!=i) coins+= dp[i][k-1];
					if(k!=j) coins+= dp[k+1][j];
					if(max< coins){
						max= coins; maxindx=k; 
					}
				}
				dp[i][j]= max;
				indx[i][j]= maxindx;
			}
		}
		//getOrder(nums, indx, dp, indx[0][n-1], 0, n-1);
		return dp[0][n-1];
	}
	private static int getValue(int nums[], int i){
		if(i<0 || i>=nums.length) return 1;
		return nums[i];
	}
	/*private static List<Integer> getOrder(int nums[], int indx[][], int dp[][], int split, int start, int end){
		if(end-start==1){
			return Arrays.asList(nums[split]);
		}
		int left[]= getOrder(nums, indx, dp, )
		
		
		return res;
	}*/
}
