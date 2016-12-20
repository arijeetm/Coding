import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sum4 {

	public static class sumpair{
		int x,y,val;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fourSum2(new int[]{0,0,0,0}, 0));
	}
	public static boolean noCommon(sumpair a, sumpair b){
		/*if(a.x==b.x || a.x==b.y || a.y==b.x || a.y==b.y)
			return false;*/
		return true;
	}
	public static List<List<Integer>> fourSum2(int[] nums, int target) {
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		Arrays.sort(nums);
		int len = nums.length, k=0;
		int pair_len = len*(len-1)/2;
		sumpair sum[] = new sumpair[pair_len];
		for(int i=0; i<pair_len; i++)
			sum[i] = new sumpair();

		for(int  i=0 ; i<len-1; i++){
			for(int j=i+1; j<len; j++){
				sum[k].x=nums[i];
				sum[k].y=nums[j];
				sum[k].val = nums[i]+nums[j];
				k++;
			}
		}
		int start=0, end =len-1;
		while(start<end){
			int s = sum[start].val + sum[end].val;
			if(s==target && noCommon(sum[start], sum[end])){
				res.add(Arrays.asList(sum[start].x, sum[start].y, sum[end].x, sum[end].y));
				start++; end--;
			} else if(s<target) start++;
			else end--;
		}
		return new ArrayList<>(res);
	}

	 public static List<List<Integer>> fourSum(int[] nums, int target) {
		 List<List<Integer>> res = new ArrayList<>();
		 Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		 Arrays.sort(nums);
		 for(int i=0; i<nums.length -3; i++){
			 int first = nums[i];
			 if(i>0 && nums[i]==nums[i-1]){
				 continue;
			 }
			 for(int j=i+1; j<nums.length-1; j++){
				 int second = nums[j];
				 if(j>1 && nums[j]==nums[j-1]){
					 continue;
				 }
				 map.clear();
				 for(int k=j+1; k<nums.length; k++){
					 int key = target - (first+second+nums[k]);
					 boolean contains = map.containsKey(key);
					 if(k < nums.length-1 && nums[k]==nums[k+1]){
						 if(!contains) map.put(nums[k], k);
					 } else{
						 if(contains) res.add(Arrays.asList(nums[i], nums[j], key, nums[k]));
					 }
					 if(!contains) map.put(nums[k], k);
				 }
			 }
		 }
		 return res;
	 }
}
