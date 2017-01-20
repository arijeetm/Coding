
public class RangeSumQuery2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int sum[][]; //sum swept with the origin
	
	public RangeSumQuery2D(int[][] matrix) {
		if(matrix==null|| matrix.length==0) return;
		int m=matrix.length, n=matrix[0].length;
		sum = new int[m][n];
		sum[0][0]= matrix[0][0];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				sum[i][j]= matrix[i][j];
				if(i>0) sum[i][j] += sum[i-1][j]; 
				if(j>0) sum[i][j] += sum[i][j-1];
				sum[i][j] -= sum[i-1][j-1];
			}
		}	
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int res = sum[row2][col2];
		res -= sum[row1][col2];
		res -= sum[row2][col1];
		res += sum[row2][col2];
		return res;
	}
}
