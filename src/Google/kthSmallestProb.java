package Google;

public class kthSmallestProb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,-15}}
		,8));
	}
	 public static int kthSmallest(int[][] matrix, int k) {
		 int m=matrix.length;
		 int low=matrix[0][0], high=matrix[m-1][m-1];
		 while(low<high){
			 int mid =low+(high-low)/2;
			 int val = find(matrix, mid);
			 if(val<k) low=mid+1;
			 else high=mid;
		 }
		 return high;
		 
	 }
	private static int find(int[][] matrix, int target) {
		int m=matrix.length;
		int count=0, i=m-1, j=0;
		while(i>=0 && j<m){
			if(matrix[i][j]<=target){
				count+= i+1;
				j++;
			}else i--;
		}
		return count;
	}
}
