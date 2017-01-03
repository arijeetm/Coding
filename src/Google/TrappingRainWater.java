package Google;

import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class TrappingRainWater {

   	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int heightMap[][]= new int[][]
				{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
		System.out.println(trapRainWater(heightMap));
	}
	
	public static int trapRainWater(int[][] heightMap) {
		if(heightMap==null || heightMap.length==0) return 0;
		Set<Point> minheightQueue= new LinkedHashSet<Point>();
		int sum_without_water = addHieghts(heightMap);
		int sum_with_water=0;
		findMinThanNeighbours(heightMap, minheightQueue);
		//Iterator<Point> itr = minheightQueue.iterator();
		while(!minheightQueue.isEmpty()){
			Point h = minheightQueue.iterator().next();
			Set<Point> lateral = new HashSet<Point>();
			int minh = bfs(heightMap, h, lateral);
			if(minh > heightMap[h.x][h.y]){
				for(Point p: lateral){
					heightMap[p.x][p.y]= minh;
					minheightQueue.remove(p);
				}
				minheightQueue.add(h);
			}else{
				for(Point p: lateral){
					minheightQueue.remove(p);
				}
			}
		}
		sum_with_water = addHieghts(heightMap);
		return sum_with_water-sum_without_water;
    }
	
	private static int bfs(int[][] heightMap, Point h, Set<Point> lateral) {
		LinkedList<Point> queue = new LinkedList<Point>();
		queue.add(h);
		lateral.add(h);
		int height= heightMap[h.x][h.y], m=heightMap.length, n=heightMap[0].length;
		int res =Integer.MAX_VALUE;
		int lx[]= {-1,0,0,1}, ly[]={0,-1, 1, 0};
		while(!queue.isEmpty()){
			Point p = queue.poll();
			if(p.x==0 || p.y==0 || p.x==m-1 || p.y==n-1){
				res= Math.min(res, heightMap[p.x][p.y]);
				continue;
			}
			int minh= minHeightInNeighbours(heightMap, p.x, p.y);
			if(minh != height){
				res= Math.min(res, minh);
				continue;
			}
			for(int k=0; k<lx.length; k++){
				Point np = new Point(p.x + lx[k], p.y+ ly[k]);
				if(heightMap[np.x][np.y] != minh){
					res= Math.min(res, heightMap[np.x][np.y]);
				}else if(!lateral.contains(np)){
					lateral.add(np);
					queue.add(np);
				}
			}
		}
		return res;
	}

	private static void findMinThanNeighbours(int[][] heightMap, Set<Point> minheightQueue){
		int m=heightMap.length, n=heightMap[0].length;
		for(int i=1; i<m-1; i++){
			for(int j=1; j<n-1 ; j++) {
				if(minHeightInNeighbours(heightMap, i, j)>=heightMap[i][j]) minheightQueue.add(new Point(i, j));
			}
		}
	}
	private static int minHeightInNeighbours(int[][] heightMap, int i, int j){
		int minh= heightMap[i][j];
		int lx[]= {-1,0,0,1}, ly[]={0,-1, 1, 0};
		for(int k=0; k<lx.length; k++){
			int x=i+ lx[k], y=j +ly[k];
			if(isValidLocation(heightMap.length, heightMap[0].length, x, y)){
				minh= Math.min(minh, heightMap[x][y]);
			}
		}
		return minh;
	}
	
	private static boolean isValidLocation(int sizex, int sizey, int i, int j){
		if(i<0 || j<0 || i>=sizex || j>=sizey) return false;
		return true;
	}
	
	private static int addHieghts(int[][] heightMap){
		int sum=0;
		for(int i=0; i<heightMap.length; i++){
			for(int j=0; j< heightMap[0].length; j++) sum+=heightMap[i][j];
		}
		return sum;
	}
}
