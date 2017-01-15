package Google;

import java.util.HashMap;
import java.util.Map;

public class SettleDebt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minTransfers(new int[][]{{0,1,10},{2,0,5}}));
				//{{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}}));
	}
	public static int minTransfers(int[][] trans){
		Map<Integer, Integer> m= new HashMap();
		int len=trans.length;
		for(int i=0; i<len; i++){
			int val= trans[i][2];
			m.put(trans[i][0], m.getOrDefault(trans[i][0], 0) - val); //deficit
			m.put(trans[i][1], m.getOrDefault(trans[i][1], 0) + val); //gain
		}
		int unbalanced[]= new int[m.size()], cnt=0;
		for(Integer i: m.keySet()) {
			if(m.get(i)!=0) unbalanced[cnt++]=m.get(i);
		}
		return minTransfersUtil(unbalanced, 0, cnt, 0);
	}
	private static int minTransfersUtil(int[] arr, int start, int end, int res) {
		int min= Integer.MAX_VALUE;
		for(int i=start+1; i<end; i++){
			if(arr[start]*arr[i]<0){
				arr[start]+= arr[i];
				min= Math.min(min, minTransfersUtil(arr, i, end, res+1)); //recursive
				arr[start]-= arr[i]; //backtrack
			}
		}
		return min!=Integer.MAX_VALUE?min: res;
	}
}
