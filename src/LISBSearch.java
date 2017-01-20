import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LISBSearch {

	public static void main(String[] args) {
		System.out.println(getLIS(new int[]{3,4,-1,5,8,2,3,12,7,9,10}));
		//System.out.println(getSimpleLISDP(new int[]{3,4,-1,5,8,2,3,12,7,9,10}));
	}

	//O(n2)
	public static int getSimpleLISDP(int nums[]){
		if(nums==null|| nums.length==0) return 0;
		int n=nums.length, res=0;
		int dp[]= new int[n];
		Arrays.fill(dp, 1);
		for(int i=0; i<n; i++){
			for(int j=0; j<i; j++){
				if(nums[j]<nums[i]) dp[i]= Math.max(dp[i], 1+dp[j]);
				res=Math.max(res, dp[i]);
			}
		}
		return res;
	}
	//O(nlogn)
	public static int getLIS(int arr[]){
		int res=0;
		if(arr==null || arr.length==0) return res;
		int len= arr.length;
		int traverse[]= new int[len];
		Arrays.fill(traverse, -1);
		int index[]= new int[len];
		int k=0;
		index[0]=0;
		for(int i=1; i<len; i++){
			if(arr[index[k]] < arr[i]){
				traverse[i]= index[k];
				index[++k]=i; res++;	
			}
			else {
				int j= getCeiling(arr, index, k, arr[i]);
				index[j]= i;
				traverse[i]= j>0? index[j-1]: -1;
			}
		}
		printLIS(index[k], arr, traverse);
		return res+1;
	}

	private static void printLIS(int end, int[] arr, int[] traverse) {
		List<Integer> l= new ArrayList();
		while(end!=-1){
			l.add(0, arr[end]);
			end= traverse[end];
		}
		System.out.println(l);
	}

	private static int getCeiling(int[] arr, int[] index, int high, int target) {
		int low=0;
		while(low<=high){
			int mid=(low+high)/2;
			if(arr[index[mid]] < target) low=mid+1;
			else high=mid-1;
		}
		return low;
	}
}
