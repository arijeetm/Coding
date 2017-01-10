import java.util.Arrays;
import java.util.Comparator;
class Job{
	int start, end, profit;
	Job(int i, int j, int k){
		start=i;
		end=j;
		profit=k;
	}
}
public class WeightedJobScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMaxProfitRec(new Job[]{new Job(3, 10, 20), 
				new Job(1, 2, 50), new Job(6, 19, 100), new Job(2, 100, 200)}));
	}
	public static int findMaxProfitRec(Job[] arr){
		if(arr==null|| arr.length==0) return 0;
		int len= arr.length;
		if(len==1) return arr[0].profit;
		int dp[]= new int[len];
		Arrays.sort(arr, new Comparator<Job>(){
			@Override
			public int compare(Job j1, Job j2) {
				return j1.end-j2.end;
			}		
		});
		dp[0]= arr[0].profit;
		for(int i=1; i<len; i++){
			dp[i]= Math.max(arr[i].profit + findLatestProft(arr, i), dp[i-1]);
		}
		return dp[len-1];
	}
	private static int findLatestProft(Job[] arr, int i) {
		int low=0, high=i-1, mid=0;
		while(low<=high){
			mid=(low+high)/2;
			if(arr[mid].end <= arr[i].start) low=mid+1;
			else high=mid-1;
		}
		/*for(int j=i-1; j>=0; j--){
			if(arr[j].end <= arr[i].start) return arr[j].profit;
		}*/
		return arr[high].profit;
	}
}
