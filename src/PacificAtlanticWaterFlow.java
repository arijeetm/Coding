import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Point{
	int x,y;
	Point(int i, int j){
		x=i; y=j;
	}
}
public class PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		System.out.println(pacificAtlantic(new int[][]{
		{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
	}
	static int dirx[]={-1,1,0,0}, diry[]={0,0,-1,1};
	public static List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res= new ArrayList();
		if(matrix==null) return res;
		int m=matrix.length, n=matrix[0].length;
		boolean p[][]= new boolean[m][n];
		boolean a[][]= new boolean[m][n];
		Queue<Point> pq= new LinkedList<>();
		Queue<Point> aq= new LinkedList<>();
		for(int i=0; i<m; i++){
			p[i][0]=true;
			pq.add(new Point(i,0));
			a[i][n-1]=true;
			aq.add(new Point(i, n-1));
		}
		for(int j=0; j<n; j++){
			p[0][j]=true;
			pq.add(new Point(0, j));
			a[m-1][j]=true;
			aq.add(new Point(m-1, j));
		}
		bfs(pq, p, matrix);
		bfs(aq, a, matrix);
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(p[i][j] && a[i][j]) res.add(new int[]{i,j});
			}
		}
		return res;
	}
	private static void bfs(Queue<Point> pq, boolean[][] p, int[][] matrix) {
		int m=matrix.length, n=matrix[0].length;
		while(!pq.isEmpty()){
			Point curr=pq.poll();
			for(int k=0; k<4; k++){
				int x= curr.x + dirx[k];
				int y= curr.y + diry[k];
				if(x<0 || y<0 || x>=m || y>=n || p[x][y] || matrix[x][y] < matrix[curr.x][curr.y]) continue;
				p[x][y]=true;
				pq.add(new Point(x,y));
			}
		}		
	}
}
