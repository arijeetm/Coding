
public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid==null || obstacleGrid.length==0) return 1;
		if(obstacleGrid[0][0]==1) return 0;
		int m= obstacleGrid.length, n=obstacleGrid[0].length;
		int dp[][]= new int[m][n];
		dp[0][0]=1; 
		for(int i=1; obstacleGrid[i][0]==0 && i<m; i++){
			dp[i][0]=1;
		}
		for(int i=1; obstacleGrid[0][i]==0 && i<n; i++){
			dp[0][i]=1;
		}
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				if(obstacleGrid[i][j]==1) continue;
				dp[i][j]= dp[i-1][j]+ dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}
	public int uniquePaths(int m, int n) {
		int dp[][]= new int[m][n];
		dp[0][0]=1;
		for(int i=1; i<m; i++) dp[i][0]=1;
		for(int i=1; i<n; i++) dp[0][i]=1;
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				dp[i][j]= dp[i-1][j]+ dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}
}
