package Google;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Cell{
	public Cell(int i, int j, int k) {
		x=i; y=j; h=k;
	}

	int x,y,h;
}
public class TrappingRainWaterII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trapRainWater(new int[][]
				{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}));
	}
	public static int trapRainWater(int[][] heightMap) {
		int water=0;
		if(heightMap==null|| heightMap.length==0 || heightMap[0].length==0) return water;
		int m=heightMap.length, n=heightMap[0].length;
		boolean v[][]= new boolean[m][n];
		Queue<Cell> q= new PriorityQueue<>(1, new Comparator<Cell>(){
			@Override
			public int compare(Cell c1, Cell c2) {		
				return c1.h- c2.h;
			}	
		});
		int dirx[]={-1,1,0,0}, diry[]={0,0,-1,1};
		for(int i=0; i<m; i++){
			v[i][0]=true;  v[i][n-1]= true;
			q.add(new Cell(i, 0, heightMap[i][0]));
			q.add(new Cell(i, n-1, heightMap[i][n-1]));
		}
		for(int i=0;i<n; i++){
			v[0][i]=true; v[m-1][i]=true;
			q.add(new Cell(0, i, heightMap[0][i]));
			q.add(new Cell(m-1, i, heightMap[m-1][i]));
		}
		while(!q.isEmpty()){
			Cell curr= q.poll();
			for(int i=0; i<4; i++){
				int x= curr.x + dirx[i];
				int y= curr.y + diry[i];
				if(x<0|| y<0|| x>=m || y>=n || v[x][y]) continue;
				v[x][y]= true;
				water+= Math.max(0, curr.h- heightMap[x][y]);
				q.add(new Cell(x, y, Math.max(curr.h, heightMap[x][y])));
			}
		}
		return water;
	}
}
