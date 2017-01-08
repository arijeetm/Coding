package Google;

import java.util.TreeSet;

public class MaxRectangleSumSmallerThanK {

	public static void main(String[] args) {
		System.out.println(maxSumSubmatrix(new int[][]{{2,2,-1}}, 3));

	}
	//O(n4)
	public static int maxSumSubmatrix(int[][] matrix, int k) {
		if(matrix==null || matrix.length==0) return 0;
		int m= matrix.length, n=matrix[0].length;
		int area[][]=  new int[m][n];
		//find all area swept with the origin
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				int a= matrix[i][j];
				if(i>0) a+= area[i-1][j];
				if(j>0) a+= area[i][j-1];
				if(i>0 && j>0) a-= area[i-1][j-1];
				area[i][j]= a;
			}
		}
		int max=Integer.MIN_VALUE;
		//calculate all areas between (r1,c1) and (r2,c2)
		for(int r1=0; r1<m; r1++){
			for(int c1=0; c1<n; c1++){
				for(int r2=r1; r2<m; r2++){
					for(int c2=c1; c2<n; c2++){
						int a= area[r2][c2];
						if(r1>0) a-= area[r1-1][c2]; // boundary inclusive
						if(c1>0) a-= area[r2][c1-1];
						if(r1>0 && c1>0) a+= area[r1-1][c1-1];
						if(a<=k){
							max= Math.max(max, a);
						}
					}
				}
			}
		}
		return max;
	}
	//O(n3logn)
	public static int maxSumSubmatrixOptimized(int[][] matrix, int k) {
		if(matrix==null || matrix.length==0) return 0;
		int m= matrix.length, n=matrix[0].length;
		int area[][]=  new int[m][n];
		//find all area swept with the origin
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				int a= matrix[i][j];
				if(i>0) a+= area[i-1][j];
				if(j>0) a+= area[i][j-1];
				if(i>0 && j>0) a-= area[i-1][j-1];
				area[i][j]= a;
			}
		}
		int max=Integer.MIN_VALUE;
		
		for(int r1=0; r1<m; r1++){
			for(int r2=0; r2<m; r2++){ //fix r1 and r2, convert to 1d matrix of sub arrays
				TreeSet<Integer> tree= new TreeSet();
				//tree.add(0); // prevent negative area
				for(int c=0; c<n; c++){
					int a= area[r2][c];
					if(r1>0) a-= area[r1][c];
					if(a>=k) {
						int ceil= tree.ceiling(a-k);
						if(ceil!=0){
							max= Math.max(max, a-ceil);
						}
					}
					tree.add(a);
				}
			}
		}
		return max;
	}

}
