package Google;

import java.util.ArrayDeque;
import java.util.Arrays;

public class maxSlidingWindowProb {

	public static void main(String[] args) {
		System.out.println(Arrays.asList(maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
	}
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n=nums.length;
		if(n==0) return new int[0];
		int res[]= new int[n-k+1];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i=0; i<n; i++){
			
			//remove elements out of range from head
			if(!q.isEmpty() && q.getFirst() < i-k+1) 
				q.remove();
			
			//keep the head as maximum by iteratively checking from tail to head
			// each time removing from tail
			while(!q.isEmpty() && nums[q.getLast()]<nums[i]) 
				q.removeLast();
			
			//add elements to tail
			q.add(i);
			
			// start the result
			if(i-k+1>=0) 
				res[i-k+1]= nums[q.getFirst()];
		}
		return res;
	}
}
