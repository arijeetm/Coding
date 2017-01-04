package Google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RussianDollEnvelopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxEnvelopes(new int[][]{
			{5,4},{6,4},{6,7},{2,3}
		}));
	}
	public static int maxEnvelopes(int[][] envelopes) {
		if(envelopes==null|| envelopes.length==0) return 0;
		int num= envelopes.length;
		int res=0;
		Arrays.sort(envelopes, new Comparator<int[]>(){
			@Override
			public int compare(int[] e1, int[] e2) {
				return e1[0]-e2[0]; // sort by length
			}		
		});
		int dp[]= new int[num]; // dp[i]-> max number of envelopes within i th envelope
		for(int i=0; i<num; i++){
			dp[i]=1; // at least
			for(int j=0; j<i; j++){
				if(envelopes[j][0]< envelopes[i][0] && envelopes[j][1]<envelopes[i][1]){
					dp[i]= Math.max(dp[i], 1+ dp[j]);
				}
			} // O(n2)
			res= Math.max(res, dp[i]); // max till now for any envelope
		}
		return res;
	}
}
