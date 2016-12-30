package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkyLineProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSkyline(new int[][]
				{{1,2,1},{1,2,2},{1,2,3}}));
		//{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}));
	}
	public static List<int[]> getSkyline(int[][] buildings) {
        int num= buildings.length;
        List<int[]> res = new ArrayList<int[]>();
        if(num==0) return res;
        res = mergeSort(buildings, 0, num-1);
        return res;
    }
	private static List<int[]> mergeSort(int[][] buildings, int low, int high) {
		if(low==high){
			return Arrays.asList(new int[]{buildings[low][0], buildings[low][2]},
					new int[]{buildings[low][1], 0});
		}
		
		int mid= (high+low)>>1;
		List<int[]> left = mergeSort(buildings, low, mid);
		List<int[]> right = mergeSort(buildings, mid+1, high);
		return merge(left, right);
	}
	private static List<int[]> merge(List<int[]> left, List<int[]> right) {
		int h1=0 , h2=0, h, i=0, j=0, m=left.size(), n=right.size();
		List<int[]> res = new ArrayList<int[]>();
		while(i<m && j<n){
			if(left.get(i)[0]< right.get(j)[0]){
				h1= left.get(i)[1];
				h=Math.max(h1, h2);
				addToList(res, new int[]{left.get(i)[0], h});
				i++;
			}else{
				h2= right.get(j)[1];
				h=Math.max(h1, h2);
				addToList(res, new int[]{right.get(j)[0], h});
				j++;
			}
		}
		while(i<m){
			addToList(res, left.get(i));
			i++;
		}
		while(j<n){
			addToList(res, right.get(j));
			j++;
		}
		return res;
	}
	private static void addToList(List<int[]> res, int[] p1) {
		if(res.isEmpty()) {
			res.add(0, p1); 
			return;
		}
		int top[] = res.get(0);
		if (top[1] > p1[1]) return;
		res.add(0, p1);
	}
}
