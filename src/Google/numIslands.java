package Google;

public class numIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numIslands(new char[][]{}));
	}

	private static void dfs(char[][] grid, int taken[][], int row, int col){
		int x[] ={-1,1, 0, 0};
		int y[] ={ 0, 0, 1,-1};
		taken[row][col]=1;
		for(int i=0; i<4; i++){
			int corx= row+x[i], cory = col+y[i];
			if(isValid(corx, cory,  grid.length, grid[0].length) && grid[corx][cory]=='1' && taken[corx][cory]!=1){
				dfs(grid, taken, corx, cory);
			}
		}
	}
		public static int numIslands(char[][] grid) {
			if(grid==null || grid.length==0) return 0;
			int count=0;
			int m=grid.length;
			int n=grid[0].length;
			int taken[][] = new int[m][n];
			
			for(int i=0; i<m; i++){
				for(int j=0; j<n; j++){
					if(grid[i][j]=='1' && taken[i][j]==0){
						dfs(grid, taken, i, j);
					    count++;
					}
				}
			}
			return count;
		}

		private static boolean isValid(int corx, int cory, int m, int n) {
			if(corx <0 || cory<0 || corx>=m || cory>=n) return false;
			return true;
		}
}
