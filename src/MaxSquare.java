
public class MaxSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maximalSquare(char[][] matrix) {
		int m= matrix.length, n=matrix[0].length;
		int dp[][]= new int[m+1][n+1];
		int res=0;
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(matrix[i-1][j-1]=='1'){
					dp[i][j]= getMin(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1;
					res= Math.max(res, dp[i][j]);
				}
			}
		}
		return res*res; //area
	}
	private int getMin(int c, int d, int e) {
		return Math.min(c, Math.min(d, e));
	}
}
