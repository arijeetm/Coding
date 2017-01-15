package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumIslandsII {

	public static void main(String[] args) {
		System.out.println(numIslands2(3,3, new int[][]{{0,0}, {0,1}, {1,2}, {2,1}}));

	}
	public static List<Integer> numIslands2(int m, int n, int[][] positions){
		List<Integer> res= new ArrayList();
		int count=0, id;
		int land[]= new int[m*n];
		Arrays.fill(land, -1);
		int dirx[]={-1,1,0,0}, diry[]={0,0,-1,1};
		for(int p[]: positions){
			id = p[0]*n+ p[1]; // unique id
			land[id]=id; //assume independent land
			count++; //island
			for(int i=0; i<4; i++){
				int nx= p[0]+dirx[i], ny=p[1]+diry[i];
				int uid= nx*n+ny;
				if(nx<0 || ny<0 || nx>=m || ny>=n || land[uid]==-1) continue;
				int rootid= findRootIsland(land, uid);
				if(rootid!=id){ // different island in neighbour
					//update root
					land[id]= rootid;
					id= rootid;
					count--; // not a separate island
				}
			}
			res.add(count);
		}
		return res;
	}
	private static int findRootIsland(int[] land, int uid) {
		while(uid!=land[uid]){
			uid=land[uid];
		}
		return uid;
	}
}
