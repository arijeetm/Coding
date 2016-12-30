package Google;

public class longestIncreasingPathProb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestIncreasingPath(new int[][]
		{{9,9,4},{6,6,8},{2,1,1}}));
	}
	public static int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m=matrix.length, n=matrix[0].length;
        int cache[][]= new int[m][n];
        int maxlen=0;
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		maxlen =Math.max(maxlen, findPath(matrix, i, j, cache, Integer.MAX_VALUE));
        	}
        }
        return maxlen;
    }
	private static int findPath(int[][] matrix, int i, int j, int cache[][], int pre) {
		if(i<0 || j<0 || i>=matrix.length|| j>=matrix[0].length|| matrix[i][j]>=pre) return 0;
		if(cache[i][j]>0) return cache[i][j];
		else{
			int max=0;
			int cur= matrix[i][j];
			max = Math.max(max, findPath(matrix, i-1, j, cache, cur));
			max = Math.max(max, findPath(matrix, i+1, j, cache, cur));
			max = Math.max(max, findPath(matrix, i, j-1, cache, cur));
			max = Math.max(max, findPath(matrix, i, j+1, cache, cur));
			cache[i][j]= ++max; //including (i,j)
			return max;
		}	
	}
	
}
