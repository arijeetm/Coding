import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AssignUniqueCap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(placeCaps(new int[][]{{5,100,1},{2},{5,100}}));
	}

	private static int placeCaps(int[][] caps) {
		if(caps==null || caps.length==0) return 0;
		int n= caps.length;
		
		Map<Integer, ArrayList<Integer>> map= new HashMap();
		Map<Integer, ArrayList<Integer>> cmap= new HashMap();
		for(int i=0; i<n; i++){
			for(int j=0; j<caps[i].length; j++){
				if(map.get(caps[i][j])==null){
					map.put(caps[i][j], new ArrayList());
				}
				map.get(caps[i][j]).add(i);
			}
		}
		int k=0;
		for(int i: map.keySet()){
			cmap.put(k++, map.get(i));
		}
		int num = (int) Math.pow(2.0, n); 
		int dp[][]= new int[num][map.size()];
		for(int i=0; i<num; i++) Arrays.fill(dp[i], -1);
		return placeCapsUtil(cmap, 0, 0, (1<<n)-1, dp);
	}

	private static int placeCapsUtil(Map<Integer, ArrayList<Integer>> map, int mask, int start, int target, int dp[][]) {
		if(mask==target) return 1;
		if(start>=map.size()) return 0;
		if(dp[mask][start]!=-1) return dp[mask][start];
		int ways = placeCapsUtil(map, mask, start+1, target, dp); //excluding cap
		for(int i: map.get(start)){ //including cap for each person
			if((mask & (1<<i)) != 0) continue;
			ways += placeCapsUtil(map, mask|(1<<i), start+1, target, dp);
		}
		return dp[mask][start]=ways;
	}

}
